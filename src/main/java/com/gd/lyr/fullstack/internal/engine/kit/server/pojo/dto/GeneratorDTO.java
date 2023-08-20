package com.gd.lyr.fullstack.internal.engine.kit.server.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Yan.Ru.Li
 * @description Layer Transport Entity - In Service
 * @date 2023/7/7 23:18:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorDTO {
    private Integer id;
    private String bizz;
    private String topic;
    private String attribute;
    private String source;
    private String expect;
    private String remark;
    private char isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
