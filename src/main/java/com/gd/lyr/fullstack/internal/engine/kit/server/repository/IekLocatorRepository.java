package com.gd.lyr.fullstack.internal.engine.kit.server.repository;

import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.entity.IekLocator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Yan.Ru.Li
 * @description IekLocatorRepository
 * @date 2023/7/12 22:00:04
 */
@Repository
public interface IekLocatorRepository extends JpaRepository<IekLocator, Integer> {
    IekLocator findByBizz(String bizz);
}
