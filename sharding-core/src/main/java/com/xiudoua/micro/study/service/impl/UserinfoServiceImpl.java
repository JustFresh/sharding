package com.xiudoua.micro.study.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.xiudoua.micro.study.constant.IdGeneraterKey;
import com.xiudoua.micro.study.dao.IUserinfoDao;
import com.xiudoua.micro.study.entity.UserinfoEntity;
import com.xiudoua.micro.study.model.UserinfoVO;
import com.xiudoua.micro.study.service.IUserinfoService;
import com.xiudoua.micro.study.service.SequenceService;
import com.xiudoua.micro.study.utils.MyClassUtil;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:54:48
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserinfoServiceImpl.class);

	@Autowired
	private IUserinfoDao userinfoDao;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	private UserinfoEntity getEntity(UserinfoVO param) {
		if(param != null) {
			UserinfoEntity res = new UserinfoEntity();
			BeanUtils.copyProperties(param, res);
			return res;
		}
		return null;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	private UserinfoVO getVO(UserinfoEntity entity) {
		if(entity != null) {
			UserinfoVO res = new UserinfoVO();
			BeanUtils.copyProperties(entity, res);
			return res;
		}
		return null;
	}
	
	/**
	 * 
	 * @param entityList
	 * @return
	 */
	private List<UserinfoVO> getVOList(List<UserinfoEntity> entityList){
		if(entityList != null && !entityList.isEmpty()) {
			List<UserinfoVO> resList = new ArrayList<>();
			for(UserinfoEntity entity : entityList) {
				resList.add(getVO(entity));
			}
			return resList;
		}
		return null;
	}

	@Transactional(rollbackOn = Exception.class)
	public List<UserinfoVO> batchSave(List<UserinfoVO> userinfoList) {
		if(userinfoList != null && !userinfoList.isEmpty()) {
			List<UserinfoEntity> entityList = new ArrayList<>();
			for(UserinfoVO vo : userinfoList) {
				entityList.add(getEntity(vo));
			}
			return getVOList(userinfoDao.saveAll(entityList));
		}
		return null;
	}

	@Override
	@Transactional
	public Long saveAndReturnByDB(UserinfoVO param) {
		String seqName = MyClassUtil.getTableName(UserinfoEntity.class);
		Long id = sequenceService.getNextVal(seqName);
		param.setId(id);
		userinfoDao.save(this.getEntity(param));
		return id;
	}

	@Override
	public Long saveAndReturnByRedis(UserinfoVO param) {
		Long id = redisTemplate.opsForValue().increment(IdGeneraterKey.REDIS_KEY_GENERATER_USERINFO,1);
		param.setId(id);
		try {
			UserinfoEntity entity = userinfoDao.save(this.getEntity(param));
			if(entity != null) {
				return id;
			}
			logger.error("使用Redis方式生成主键保存TB_USERINFO数据失败！");
			redisTemplate.opsForValue().decrement(IdGeneraterKey.REDIS_KEY_GENERATER_USERINFO,1);
		} catch (Exception e) {
			logger.error("使用Redis方式生成主键保存TB_USERINFO数据出错！",e);
			redisTemplate.opsForValue().decrement(IdGeneraterKey.REDIS_KEY_GENERATER_USERINFO,1);
		}
		return null;
	}

	@Override
	public Long save(UserinfoVO param) {
		try {
			UserinfoEntity entity = userinfoDao.save(this.getEntity(param));
			if(entity == null) {
				logger.error("保存TB_USERINFO数据失败！");
				return null;
			}
			return entity.getId();
		} catch (Exception e) {
			logger.error("保存TB_USERINFO数据出错！",e);
		}
		return null;
	}

}