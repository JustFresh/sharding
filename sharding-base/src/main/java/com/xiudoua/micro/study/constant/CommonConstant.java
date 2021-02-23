/**
 * @desc
 * @author JustFresh
 * @time 2021年2月17日 下午2:15:48
 */
package com.xiudoua.micro.study.constant;

/**
 * @author JustFresh
 *
 */
public class CommonConstant {

	public static final String CACHE_KEY_HASH_USER_PREFIX = "sharding:data:hash:user:";
	public static final String CACHE_KEY_HASH_ADDRESS_PREFIX = "sharding:data:hash:address:";
	
	public static final Long SEQUENCE_DEFALUT_MIN_VALUE = 1L;
	public static final Long SEQUENCE_DEFALUT_MAX_VALUE = 99999999999999L;
	public static final Long SEQUENCE_DEFALUT_CURRENT_VAL = 1L;
	public static final Long SEQUENCE_DEFALUT_INCREMENT_VAL = 1L;
	
	public static final String TABLe_userinfo = "TB_USERINFO";
	
	public static final String REDIS_KEY_EXPAND_HASH_DATA = "shard:dynimac:expand:hash";
}