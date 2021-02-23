package com.xiudoua.micro.study.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.xiudoua.micro.study.constant.CommonConstant;
import com.xiudoua.micro.study.entity.FragmentEntity;
import com.xiudoua.micro.study.service.IFragmentService;
import com.xiudoua.micro.study.utils.JsonUtil;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午5:01:44
 */
@Order(1)
@Component
public class LoadFragmentData implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(LoadFragmentData.class);

	@Autowired
	private IFragmentService fragmentService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public void run(String... args) throws Exception {
		List<FragmentEntity> fragmentList = fragmentService.findEffectiveList();
		if(fragmentList != null && !fragmentList.isEmpty()) {
			redisTemplate.delete(CommonConstant.REDIS_KEY_EXPAND_HASH_DATA);
			Map<String,String> map = new HashMap<String, String>();
			for(FragmentEntity fragment : fragmentList) {
				map.put(fragment.getStartId() + "_" + fragment.getEndId(), JsonUtil.objectToJson(fragment));
			}
			redisTemplate.opsForHash().putAll(CommonConstant.REDIS_KEY_EXPAND_HASH_DATA, map);
			logger.info("往缓存中加载了{}条基础分库分表相关数据！",fragmentList.size());
		}
	}
	
}