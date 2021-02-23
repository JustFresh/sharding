package com.xiudoua.micro.study.service;

import java.util.List;

import com.xiudoua.micro.study.entity.FragmentEntity;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午5:02:47
 */
public interface IFragmentService {

	/**
	 * @desc 
	 * @param paramList
	 * @return
	 */
	int saveAll(List<FragmentEntity> paramList);
	
	/**
	 * @desc 
	 *
	 */
	void deleteAll();
	
	/**
	 * @desc 
	 * @param writeAble
	 * @return
	 */
	FragmentEntity findByIdIn(Long id);
	
	/**
	 * @desc 
	 * @return
	 */
	List<FragmentEntity> findEffectiveList();
	
}