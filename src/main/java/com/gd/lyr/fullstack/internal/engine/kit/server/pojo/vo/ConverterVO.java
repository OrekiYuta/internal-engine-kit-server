package com.gd.lyr.fullstack.internal.engine.kit.server.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yan.Ru.Li
 * @description View Mapping Entity
 * @date 2023/7/7 22:55:49
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConverterVO {
    private String bizz;
    private String topic;
    private String attribute;
    private String source;
    private String expect;
    private String remark;
}
