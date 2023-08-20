package com.gd.lyr.fullstack.internal.engine.kit.server.utils;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yan.Ru.Li
 * @description PojoUtils
 * @date 2023/7/12 23:10:14
 */
public class PojoUtils {

    private static ModelMapper modelMapper = new ModelMapper();

    public static <S, T> T convertDTOToEntity(S entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public static <S, T> List<T> convertEntityToDTOList(List<S> entityList, Class<T> dtoClass) {
        return entityList.stream()
                .map(entity -> convertEntityToDTO(entity, dtoClass))
                .collect(Collectors.toList());
    }

    public static <S, T> T convertEntityToDTO(S entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public static <S, T> List<T> convertDTOToVOList(List<S> entityList, Class<T> dtoClass) {
        return entityList.stream()
                .map(entity -> convertDTOToVO(entity, dtoClass))
                .collect(Collectors.toList());
    }

    public static <S, T> T convertDTOToVO(S entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public static <S, T> T convertVOToDTO(S entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}
