package com.gd.lyr.fullstack.internal.engine.kit.server.repository;

import com.gd.lyr.fullstack.internal.engine.kit.server.pojo.entity.IekConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yan.Ru.Li
 * @description IekConvertorRepository
 * @date 2023/7/13 00:12:18
 */
@Repository
public interface IekConvertorRepository extends JpaRepository<IekConverter, Integer> {

}
