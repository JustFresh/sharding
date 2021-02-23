package com.xiudoua.micro.study.service;

import java.util.List;

import com.xiudoua.micro.study.model.AddressVO;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:15:49
 */
public interface IAddressService {

	/**
	 * @desc 
	 * @param userinfoList
	 * @return
	 */
	int batchSave(List<AddressVO> addressList);
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	AddressVO update(AddressVO param);
}