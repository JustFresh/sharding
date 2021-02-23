package com.xiudoua.micro.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiudoua.micro.study.constant.IdGeneraterKey;
import com.xiudoua.micro.study.model.AddressVO;
import com.xiudoua.micro.study.model.UserinfoVO;
import com.xiudoua.micro.study.service.IAddressService;
import com.xiudoua.micro.study.service.IUserinfoService;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午5:13:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InitApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExpandTest {

	private static final Logger logger = LoggerFactory.getLogger(ExpandTest.class);
	
	@Autowired
	private IUserinfoService userinfoService;
	
	@Autowired
	private IAddressService addressService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Test
	public void testSave() {
		for(int i=1;i<4001;i++) {
			Long userId = redisTemplate.opsForValue().increment(IdGeneraterKey.REDIS_KEY_GENERATER_USERINFO,1);
			UserinfoVO userinfo = new UserinfoVO("Tony" + i,"11111","test@qq.com");
			userinfo.setId(userId);
			userId = userinfoService.save(userinfo);
			if(userId == null) {
				redisTemplate.opsForValue().decrement(IdGeneraterKey.REDIS_KEY_GENERATER_USERINFO,1);
			}else {
				logger.info("=====单元测试插入用户数据成功，用户ID={}======",userId);
			}
			
			int num = new Random().nextInt(2) + 1;
			List<AddressVO> addressList = new ArrayList<AddressVO>();
			for(int j=0;j<num;j++) {
				Long addressId = redisTemplate.opsForValue().increment(IdGeneraterKey.REDIS_KEY_GENERATER_ADDRESS,1);
				AddressVO address = new AddressVO("测试地址" + j, "155****1234");
				address.setId(addressId);
				address.setUserinfo(userinfo);
				addressList.add(address);
			}
			int successCount = addressService.batchSave(addressList);
			redisTemplate.opsForValue().decrement(IdGeneraterKey.REDIS_KEY_GENERATER_ADDRESS,addressList.size() - successCount);
			logger.info("=====单元测试插入{}用户地址数据成功，查了了{}条地址数据",userId,successCount);
		}
		
	}
	
}