package com.xiudoua.micro.study.service;

import java.util.List;

import com.xiudoua.micro.study.model.UserinfoVO;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:16:03
 */
public interface IUserinfoService {

	/**
	 * @desc 
	 * @param param
	 * @return
	 */
	List<UserinfoVO> batchSave(List<UserinfoVO> userinfoList);
	
	/**
	 * 使用数据库生成主键
	 * @param param
	 * @return
	 */
	Long saveAndReturnByDB(UserinfoVO param);
	
	/**
	 * 使用Redis生成主键
	 * @param param
	 * @return
	 */
	Long saveAndReturnByRedis(UserinfoVO param);
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	Long save(UserinfoVO param);
}