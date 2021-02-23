package com.xiudoua.micro.study.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiudoua.micro.study.dao.IAddressDao;
import com.xiudoua.micro.study.entity.AddressEntity;
import com.xiudoua.micro.study.entity.UserinfoEntity;
import com.xiudoua.micro.study.model.AddressVO;
import com.xiudoua.micro.study.model.UserinfoVO;
import com.xiudoua.micro.study.service.IAddressService;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:54:04
 */
@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private IAddressDao addressDao;
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	private AddressEntity getEntity(AddressVO param) {
		if(param != null && param.getUserinfo() != null) {
			AddressEntity res = new AddressEntity();
			BeanUtils.copyProperties(param, res);
			UserinfoEntity userinfoEntity = new UserinfoEntity();
			BeanUtils.copyProperties(param.getUserinfo(), userinfoEntity);
			res.setUserinfo(userinfoEntity);
			return res;
		}
		return null;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	private AddressVO getVO(AddressEntity entity) {
		if(entity != null && entity.getUserinfo() != null) {
			AddressVO res = new AddressVO();
			BeanUtils.copyProperties(entity, res);
			UserinfoVO userinfo = new UserinfoVO();
			BeanUtils.copyProperties(entity.getUserinfo(), userinfo);
			res.setUserinfo(userinfo);
			return res;
		}
		return null;
	}
	
	@Transactional(rollbackOn = Exception.class)
	public int batchSave(List<AddressVO> addressList) {
		if(addressList != null && !addressList.isEmpty()) {
			List<AddressEntity> entityList = new ArrayList<>();
			for(AddressVO vo : addressList) {
				entityList.add(getEntity(vo));
			}
			return addressDao.saveAll(entityList).size();
		}
		return 0;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public AddressVO update(AddressVO param) {
		return getVO(addressDao.save(getEntity(param)));
	}

}