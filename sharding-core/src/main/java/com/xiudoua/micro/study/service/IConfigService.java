package com.xiudoua.micro.study.service;

import java.util.List;

import com.xiudoua.micro.study.model.ConfigVO;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:48:38
 */
public interface IConfigService {

	/**
	 * @desc 
	 * @param param
	 * @return
	 */
	List<ConfigVO> batchSave(List<ConfigVO> userinfoList);
	
}