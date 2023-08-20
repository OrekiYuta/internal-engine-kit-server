package com.gd.lyr.fullstack.internal.engine.kit.server.enums;

import com.gd.lyr.fullstack.internal.engine.kit.server.service.IekGeneratorService;


/**
 * @author Yan.Ru.Li
 * @description GeneratorEnum
 * @date 7/20/2023 10:31:47
 */
public enum GeneratorEnum {
    G_STREAM {
        @Override
        public String handle(String str) {
            return IekGeneratorService.generatorStream(str);
        }

        @Override
        public String handle(String str, int count) {
            return null;
        }
    },
    G_DATA_PATCH {
        @Override
        public String handle(String str) {
            return null;
        }

        @Override
        public String handle(String str, int count) {
            return IekGeneratorService.generatorDataPatch(str, count);
        }
    };


    public abstract String handle(String str);

    public abstract String handle(String str, int count);

}
