package com.xiudoua.micro.study.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiudoua.micro.study.dao.IConfigDao;
import com.xiudoua.micro.study.entity.ConfigEntity;
import com.xiudoua.micro.study.model.ConfigVO;
import com.xiudoua.micro.study.service.IConfigService;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:56:36
 */
@Service
public class ConfigServiceImpl implements IConfigService{

	@Autowired
	private IConfigDao configDao;
	
	/**
	 * @param saveAll
	 * @return
	 */
	private List<ConfigVO> getVOList(List<ConfigEntity> entityList) {
		if(entityList != null && !entityList.isEmpty()) {
			List<ConfigVO> resList = new ArrayList<>();
			for(ConfigEntity entity : entityList) {
				resList.add(getVO(entity));
			}
			return resList;
		}
		return null;
	}

	/**
	 * @param entity
	 * @return
	 */
	private ConfigVO getVO(ConfigEntity entity) {
		if(entity != null) {
			ConfigVO res = new ConfigVO();
			BeanUtils.copyProperties(entity, res);
			return res;
		}
		return null;
	}

	/**
	 * @param vo
	 * @return
	 */
	private ConfigEntity getEntity(ConfigVO param) {
		if(param != null) {
			ConfigEntity res = new ConfigEntity();
			BeanUtils.copyProperties(param, res);
			return res;
		}
		return null;
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public List<ConfigVO> batchSave(List<ConfigVO> configList) {
		if(configList != null && !configList.isEmpty()) {
			List<ConfigEntity> entityList = new ArrayList<>();
			for(ConfigVO vo : configList) {
				entityList.add(getEntity(vo));
			}
			return getVOList(configDao.saveAll(entityList));
		}
		return null;
	}

}