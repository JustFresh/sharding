package com.xiudoua.micro.study.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.study.entity.SequenceEntity;


/**
 * @desc
 * @author JustFresh
 * @time 2021年2月21日 下午6:11:04
 */
@Repository
public interface ISequenceDao extends JpaRepository<SequenceEntity, Long> {

	/**
	 * 
	 * @param seqName
	 * @return
	 */
	@Query(value = "select * from TB_SEQUENCE where SEQ_NAME = :seqName for update",nativeQuery = true)
	SequenceEntity findBySeqName(@Param("seqName") String seqName);
	
}