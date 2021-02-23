package com.xiudoua.micro.study.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.study.entity.UserinfoEntity;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月17日 下午2:24:11
 */
@Repository
public interface IUserinfoDao extends JpaRepository<UserinfoEntity, Long> {

}