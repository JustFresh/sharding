package com.xiudoua.micro.study.config;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 上午9:13:07
 */
public class UserinfoDbShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
	
	private static Logger logger = LoggerFactory.getLogger(UserinfoDbShardingAlgorithm.class);

	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		long dbNum = shardingValue.getValue() % 8 / 4;
		logger.info("当前分库分表生成的主键ID为：{}，分配到的数据库为：db{}",shardingValue.getValue(),dbNum);
		return "db" + dbNum;
	}

}