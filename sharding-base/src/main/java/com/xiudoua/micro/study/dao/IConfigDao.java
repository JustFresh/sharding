package com.xiudoua.micro.study.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.study.entity.ConfigEntity;

/**
 * @author JustFresh
 *
 */
@Repository
public interface IConfigDao extends JpaRepository<ConfigEntity, Long> {

}