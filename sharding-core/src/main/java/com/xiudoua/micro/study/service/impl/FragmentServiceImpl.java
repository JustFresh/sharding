package com.xiudoua.micro.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiudoua.micro.study.dao.IFragmentDao;
import com.xiudoua.micro.study.entity.FragmentEntity;
import com.xiudoua.micro.study.service.IFragmentService;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午5:03:32
 */
@Service
public class FragmentServiceImpl implements IFragmentService{
	
	@Autowired
	private IFragmentDao fragmentDao;

	public int saveAll(List<FragmentEntity> paramList) {
		List<FragmentEntity>  resList = fragmentDao.saveAll(paramList);
		if(resList != null) {
			return resList.size();
		}
		return 0;
	}

	public void deleteAll() {
		fragmentDao.deleteAll();
	}

	public FragmentEntity findByIdIn(Long id) {
		return fragmentDao.findByIdIn(id);
	}

	public List<FragmentEntity> findEffectiveList() {
		return fragmentDao.findEffectiveList();
	}

}