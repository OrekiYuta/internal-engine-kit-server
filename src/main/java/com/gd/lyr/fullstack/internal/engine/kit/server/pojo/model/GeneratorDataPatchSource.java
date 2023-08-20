package com.gd.lyr.fullstack.internal.engine.kit.server.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yan.Ru.Li
 * @description Data Mapping Entity
 * @date 7/21/2023 09:17:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorDataPatchSource {
    private String statement;
    private Integer count;
}
