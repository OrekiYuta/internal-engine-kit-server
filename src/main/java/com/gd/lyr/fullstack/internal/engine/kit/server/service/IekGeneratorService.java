package com.gd.lyr.fullstack.internal.engine.kit.server.service;

import com.alibaba.druid.sql.ast.SQLDataType;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.gd.lyr.fullstack.internal.engine.kit.server.constants.DbColumnConstants;
import com.gd.lyr.fullstack.internal.engine.kit.server.enums.GeneratorEnum;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.dto.GeneratorDTO;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.entity.IekGenerator;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.model.GeneratorDataPatchExpect;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.model.GeneratorDataPatchSource;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.model.GeneratorTableColumnInfo;
import com.gd.lyr.fullstack.internal.engine.kit.server.repository.IekGeneratorRepository;
import com.gd.lyr.fullstack.internal.engine.kit.server.utils.PojoUtils;
import com.github.javafaker.Faker;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.gd.lyr.fullstack.internal.engine.kit.server.utils.DateUtils.formatTimestamp;
import static com.gd.lyr.fullstack.internal.engine.kit.server.utils.StringUtils.truncateString;

/**
 * @author Yan.Ru.Li
 * @description IekGeneratorService
 * @date 2023/7/7 21:40:56
 */
@Service
public class IekGeneratorService {

    private final IekGeneratorRepository iekGeneratorRepository;

    // Create Gson object, disable HTML escape and special character escape
    private static final Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .disableInnerClassSerialization()
            .create();
    private static final Faker faker = new Faker();

    public IekGeneratorService(IekGeneratorRepository iekGeneratorRepository) {
        this.iekGeneratorRepository = iekGeneratorRepository;
    }


    public GeneratorDTO createGenerator(GeneratorDTO generatorDTO) {

        // Pipeline Converter
        GeneratorDTO pipelineResult = pipelineGenerator(generatorDTO);
        // Update DB
        IekGenerator iekGenerator = PojoUtils.convertDTOToEntity(pipelineResult, IekGenerator.class);

        iekGenerator.setBizz(UUID.randomUUID().toString());
        iekGenerator.setIsActive(DbColumnConstants.IS_ACTIVE_Y);
        LocalDateTime now = LocalDateTime.now();
        iekGenerator.setCreatedAt(now);
        iekGenerator.setUpdatedAt(now);
        IekGenerator save = iekGeneratorRepository.save(iekGenerator);

        GeneratorDTO result = PojoUtils.convertEntityToDTO(save, GeneratorDTO.class);
        return result;
    }


    public GeneratorDTO pipelineGenerator(GeneratorDTO generatorDTO) {
        // Get the GeneratorEnum based on the attribute in GeneratorDTO
        GeneratorEnum generatorEnum = GeneratorEnum.valueOf(generatorDTO.getAttribute());

        String expectResult = "";

        // Define a list of entity types to check during JSON parsing
        List<Class<?>> entityTypes = new ArrayList<>();
        entityTypes.add(GeneratorDataPatchSource.class);
        // Add other entity types to the entityTypes list, if applicable

        // Parse the source as a JsonElement
        JsonElement jsonElement = JsonParser.parseString(generatorDTO.getSource());
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            for (Class<?> entityType : entityTypes) {

                // Try to parse the JSON source as the current entity type
                Object entity = gson.fromJson(jsonObject, entityType);

                if (entity != null) {
                    // If the conversion is successful, execute the corresponding entity's operation
                    if (entity instanceof GeneratorDataPatchSource) {
                        GeneratorDataPatchSource dataPatchSource = (GeneratorDataPatchSource) entity;
                        expectResult = generatorEnum.handle(dataPatchSource.getStatement(), dataPatchSource.getCount());
                    }
                    /**
                     * Uncomment and add more conditions for other entity types if needed.
                     * For example:
                     *
                     * if (entity instanceof OtherEntity) {
                     *     // Execute operations for the OtherEntity type
                     *     // ...
                     * }
                     *
                     **/

                    // Exit the loop after successful conversion and operation execution
                    break;
                }
            }
        } else {
            // If source is not a JSON object, execute operations for non-JSON object types
            expectResult = generatorEnum.handle(generatorDTO.getSource());
        }

        // Set the expectResult in the GeneratorDTO and return it
        generatorDTO.setExpect(expectResult);
        return generatorDTO;
    }


    public static String generatorStream(String str) {
//        Reserved Extension
        return str;
    }

    public static String generatorDataPatch(String str, int count) {
        String tableName = getTableNameFromSQL(str);
        List<GeneratorTableColumnInfo> columnInfoList = parseTableColumns(str);

        List<String> dataPatchSqlStatementList = IntStream.range(0, count).mapToObj(
                i -> dataPatchSqlStatement(columnInfoList, tableName)
        ).collect(Collectors.toList());

        List<JsonObject> dataPatchJsonStatementList = IntStream.range(0, count).mapToObj(
                i -> dataPatchJsonStatement(columnInfoList)
        ).collect(Collectors.toList());

        GeneratorDataPatchExpect generatorDataPatchExpect = GeneratorDataPatchExpect.builder()
                .sqlStatement(dataPatchSqlStatementList)
                .jsonStatement(dataPatchJsonStatementList)
                .build();

        return gson.toJson(generatorDataPatchExpect);
    }

    private static String dataPatchSqlStatement(List<GeneratorTableColumnInfo> columnInfoList, String tableName) {

        StringBuilder insertIntoSql = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder valuesSql = new StringBuilder("VALUES (");

        for (GeneratorTableColumnInfo columnInfo : columnInfoList) {
            String columnName = columnInfo.getColumnName();
            String dataType = columnInfo.getDataType();
            int dataSize = columnInfo.getDataSize();

            // Generate random data
            String value = getColumnValue(dataType, dataSize);

            // Construct Insert Into statements and JSON data
            insertIntoSql.append(columnName).append(", ");
            valuesSql.append(value).append(", ");
        }

        // Remove the last comma
        insertIntoSql.setLength(insertIntoSql.length() - 2);
        valuesSql.setLength(valuesSql.length() - 2);

        insertIntoSql.append(") ").append(valuesSql).append(");");

        return insertIntoSql.toString();
    }

    private static JsonObject dataPatchJsonStatement(List<GeneratorTableColumnInfo> columnInfoList) {
        JsonObject jsonData = new JsonObject();

        for (GeneratorTableColumnInfo columnInfo : columnInfoList) {
            String columnName = columnInfo.getColumnName();
            String dataType = columnInfo.getDataType();
            int dataSize = columnInfo.getDataSize();

            // Generate random data
            String value = getColumnValue(dataType, dataSize);

            String valueFormat = value.replaceAll("^'+|'+$", "");
            jsonData.addProperty(columnName, valueFormat);
        }

        return jsonData;
    }

    private static String getColumnValue(String dataType, int dataSize) {
        String value;
        if (dataType.equalsIgnoreCase("INTEGER")) {
            value = String.valueOf(faker.number().randomNumber());
        } else if (dataType.equalsIgnoreCase("VARCHAR")) {
            value = "'" + truncateString(faker.lorem().sentence(dataSize), dataSize) + "'";
        } else if (dataType.equalsIgnoreCase("LONGTEXT")) {
            value = "'" + truncateString(faker.lorem().sentence(255), 255) + "'";
        } else if (dataType.equalsIgnoreCase("CHAR")) {
            value = "'" + faker.options().option("Y", "N") + "'";
        } else if (dataType.equalsIgnoreCase("TIMESTAMP")) {
            value = "'" + formatTimestamp(faker.date().past(365, TimeUnit.DAYS)) + "'";
        } else {
            value = "NULL"; // For data types that cannot be processed, default to NULL
        }
        return value;
    }

    private static List<GeneratorTableColumnInfo> parseTableColumns(String createTableSQL) {
        List<GeneratorTableColumnInfo> columnInfoList = new ArrayList<>();

        // Parsing CREATE TABLE statements using Druid
        MySqlStatementParser parser = new MySqlStatementParser(createTableSQL);
        SQLStatement stmt = parser.parseCreateTable();

        // Extract columnName, dataType, and dataSize
        if (stmt instanceof SQLCreateTableStatement) {
            SQLCreateTableStatement createTableStmt = (SQLCreateTableStatement) stmt;
            List<SQLColumnDefinition> columnDefinitions = new ArrayList<>();

            // Extract SQLColumnDefinition object
            for (SQLTableElement tableElement : createTableStmt.getTableElementList()) {
                if (tableElement instanceof SQLColumnDefinition) {
                    columnDefinitions.add((SQLColumnDefinition) tableElement);
                }
            }

            // Process each SQLColumnDefinition object
            for (SQLColumnDefinition columnDef : columnDefinitions) {
                SQLName columnName = columnDef.getName();
                SQLDataType dataType = columnDef.getDataType();
                SQLExpr dataSizeExpr = dataType.getArguments().size() > 0 ? dataType.getArguments().get(0) : null;

                String columnNameStr = columnName.getSimpleName();
                String dataTypeStr = dataType.getName().toUpperCase();
                int dataSize = 0;

                if (dataSizeExpr != null) {
                    dataSize = Integer.parseInt(dataSizeExpr.toString());
                }

                GeneratorTableColumnInfo columnInfo = new GeneratorTableColumnInfo(columnNameStr, dataTypeStr, dataSize);
                columnInfoList.add(columnInfo);
            }
        }


        return columnInfoList;
    }

    private static String getTableNameFromSQL(String createTableSQL) {
        // Parsing CREATE TABLE statements using Druid
        MySqlStatementParser parser = new MySqlStatementParser(createTableSQL);
        SQLCreateTableStatement stmt = parser.parseCreateTable();

        // Extract Table Name
        SQLExprTableSource tableSource = stmt.getTableSource();
        String tableName = tableSource.getName().getSimpleName();

        return tableName;
    }

    public static void main(String[] args) {
        String s = generatorDataPatch("CREATE TABLE IEK_GENERATOR ( id INTEGER PRIMARY KEY, bizz VARCHAR(36) NOT NULL, topic VARCHAR(20) NOT NULL, attribute VARCHAR(20) NOT NULL, source LONGTEXT, expect LONGTEXT, remark VARCHAR(255), is_active CHAR(1) NOT NULL CHECK (is_active IN ('Y', 'N')), created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP );", 3);
        System.out.println(s);
//        String c = generatorDataPatch("CREATE TABLE IEK_LOCATOR( id INTEGER PRIMARY KEY, bizz VARCHAR(36) NOT NULL, title VARCHAR(20) NOT NULL, website VARCHAR(100) NOT NULL, account VARCHAR(100) NOT NULL, hex_secret VARCHAR(150) NOT NULL, remark VARCHAR(255), is_active CHAR(1) NOT NULL CHECK (is_active IN ('Y', 'N')), created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);"
//        ,);
//        System.out.println(c);


    }
}
