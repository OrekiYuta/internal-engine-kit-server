package com.gd.lyr.fullstack.internal.engine.kit.server.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yan.Ru.Li
 * @description Data Mapping Entity
 * @date 7/20/2023 11:30:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorTableColumnInfo {
    private String columnName;
    private String dataType;
    private int dataSize; // Data length, used for VARCHAR and other types
//    private boolean notNull; // IS OR NOT NULL
}
