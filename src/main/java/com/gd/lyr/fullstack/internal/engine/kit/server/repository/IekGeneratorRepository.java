package com.gd.lyr.fullstack.internal.engine.kit.server.repository;

import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.entity.IekGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yan.Ru.Li
 * @description IekGeneratorRepository
 * @date 2023/7/13 00:12:00
 */
@Repository
public interface IekGeneratorRepository extends JpaRepository<IekGenerator, Integer> {
}
