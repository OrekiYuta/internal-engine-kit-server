package com.gd.lyr.fullstack.internal.engine.kit.server.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Yan.Ru.Li
 * @description Layer Transport Entity - In Service
 * @date 2023/7/7 23:18:15
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocatorDTO {
    private Integer id;
    private String bizz;
    private String title;
    private String website;
    private String account;
    private String hexSecret;
    private String remark;
    private char isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
