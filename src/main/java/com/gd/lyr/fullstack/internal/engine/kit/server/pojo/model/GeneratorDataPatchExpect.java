package com.gd.lyr.fullstack.internal.engine.kit.server.pojo.model;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Yan.Ru.Li
 * @description Data Mapping Entity
 * @date 7/20/2023 15:50:26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorDataPatchExpect {

    private List<String> sqlStatement;
    private List<JsonObject> jsonStatement;
}
