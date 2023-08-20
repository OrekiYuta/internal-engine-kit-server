package com.gd.lyr.fullstack.internal.engine.kit.server.pojo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Yan.Ru.Li
 * @description Database Mapping Entity
 * @date 2023/7/7 21:23:44
 */
@Data
@Entity
@Table(name = "IEK_LOCATOR")
public class IekLocator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bizz;
    private String title;
    private String website;
    private String account;
    private String hexSecret;
    private String remark;
    private char isActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

}
