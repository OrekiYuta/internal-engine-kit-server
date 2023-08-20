package com.gd.lyr.fullstack.internal.engine.kit.server.pojo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Yan.Ru.Li
 * @description Database Mapping Entity
 * @date 2023/7/7 21:24:06
 */
@Data
@Entity
@Table(name = "IEK_CONVERTER")
public class IekConverter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bizz;
    private String topic;
    private String attribute;
    private String source;
    private String expect;
    private String remark;
    private char isActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


}
