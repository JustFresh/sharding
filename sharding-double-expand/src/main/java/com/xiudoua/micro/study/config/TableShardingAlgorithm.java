package com.xiudoua.micro.study.config;

import java.util.Collection;
import java.util.Set;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.xiudoua.micro.study.constant.CommonConstant;
import com.xiudoua.micro.study.entity.FragmentEntity;
import com.xiudoua.micro.study.utils.ApplicationContextHolder;
import com.xiudoua.micro.study.utils.JsonUtil;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 上午9:13:26
 */
public class TableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	private RedisTemplate<String,String> redisTemplate;
	
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		String shardTableName = null;
		String tableSuffix = getTableSuffix(shardingValue.getValue());
		for(String tableName : availableTargetNames) {
			if(tableName.contains(tableSuffix)) {
				shardTableName = tableName;
				break;
			}
		}
		return shardTableName;
	}

	/**
	 * @desc 获取配置的数据库后缀
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getTableSuffix(Long value) {
		String resKey = null;
		redisTemplate = ApplicationContextHolder.getBean("stringRedisTemplate",RedisTemplate.class);
		HashOperations<String,String,String> opsHash = redisTemplate.opsForHash();
		Set<String> fragmentKeySet = opsHash.keys(CommonConstant.REDIS_KEY_EXPAND_HASH_DATA);
		if(fragmentKeySet == null || fragmentKeySet.isEmpty()) {
			return null;
		}
		for(String fragmentKey : fragmentKeySet) {
			String[] idArr = fragmentKey.split("_");
			Long startId = Long.parseLong(idArr[0]);
			Long endId = Long.parseLong(idArr[1]);
			if(value > startId && value <= endId) {
				String fragmentStr = opsHash.get(CommonConstant.REDIS_KEY_EXPAND_HASH_DATA, fragmentKey);
				FragmentEntity fragment = JsonUtil.string2Obj(fragmentStr, FragmentEntity.class);
				resKey = fragment.getTableSuffix();
				break;
			}
		}
		return resKey;
	}

}