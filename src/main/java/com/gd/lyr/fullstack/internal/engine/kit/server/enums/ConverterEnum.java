package com.gd.lyr.fullstack.internal.engine.kit.server.enums;

import com.gd.lyr.fullstack.internal.engine.kit.server.service.IekConverterService;

/**
 * @author Yan.Ru.Li
 * @description ConverterEnum
 * @date 7/20/2023 09:38:33
 */
public enum ConverterEnum {

    C_UUID {
        @Override
        public String handle(String str) {
            return IekConverterService.converterUuid(str);
        }
    };


    public abstract String handle(String str);

}
