package com.gd.lyr.fullstack.internal.engine.kit.server.service;

import com.gd.lyr.fullstack.internal.engine.kit.server.constants.DbColumnConstants;
import com.gd.lyr.fullstack.internal.engine.kit.server.enums.ConverterEnum;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.dto.ConverterDTO;
import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.entity.IekConverter;
import com.gd.lyr.fullstack.internal.engine.kit.server.repository.IekConvertorRepository;
import com.gd.lyr.fullstack.internal.engine.kit.server.utils.PojoUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Yan.Ru.Li
 * @description IekConverterService
 * @date 2023/7/7 21:40:32
 */
@Service
public class IekConverterService {

    private final IekConvertorRepository iekConvertorRepository;

    public IekConverterService(IekConvertorRepository iekConvertorRepository) {
        this.iekConvertorRepository = iekConvertorRepository;
    }

    public ConverterDTO createConverter(ConverterDTO converterDTO) {

        // Pipeline Converter
        ConverterDTO pipelineResult = pipelineConverter(converterDTO);
        // Update DB
        IekConverter iekConverter = PojoUtils.convertDTOToEntity(pipelineResult, IekConverter.class);

        iekConverter.setBizz(UUID.randomUUID().toString());
        iekConverter.setIsActive(DbColumnConstants.IS_ACTIVE_Y);
        LocalDateTime now = LocalDateTime.now();
        iekConverter.setCreatedAt(now);
        iekConverter.setUpdatedAt(now);
        IekConverter save = iekConvertorRepository.save(iekConverter);

        return PojoUtils.convertEntityToDTO(save, ConverterDTO.class);
    }

    public ConverterDTO pipelineConverter(ConverterDTO converterDTO) {

        ConverterEnum converterEnum = ConverterEnum.valueOf(converterDTO.getAttribute());
        String expectResult = converterEnum.handle(converterDTO.getSource());

        converterDTO.setExpect(expectResult);
        return converterDTO;
    }


    public static String converterUuid(String uuidStr) {
        return uuidStr.replace("-", "");
    }

}
