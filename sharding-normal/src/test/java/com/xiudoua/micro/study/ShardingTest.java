package com.xiudoua.micro.study;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiudoua.micro.study.model.AddressVO;
import com.xiudoua.micro.study.model.ConfigVO;
import com.xiudoua.micro.study.model.UserinfoVO;
import com.xiudoua.micro.study.service.IAddressService;
import com.xiudoua.micro.study.service.IConfigService;
import com.xiudoua.micro.study.service.IUserinfoService;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:53:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InitApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShardingTest {
	
	@Autowired
	private IAddressService addressService;
	
	@Autowired
	private IUserinfoService userinfoService;
	
	@Autowired
	private IConfigService configService;
	
	@Test
	public void test1BatchConfig() {
		List<ConfigVO> configList = new ArrayList<>();
		for(int i=1;i<11;i++) {
			ConfigVO vo = new ConfigVO();
			vo.setId(i + 0L);
			vo.setKey("key" + i);
			vo.setValue("value" + i);
			configList.add(vo);
		}
		configService.batchSave(configList);
	}

	@Test
	public void test2BatchSaveUser() {
		List<UserinfoVO> userinfoList = new ArrayList<>();
		for(int i=0;i<200;i++) {
			UserinfoVO userinfo = new UserinfoVO("user" + i,"**" + i + "**","test" + i + "@qq.com");
			Long userId = i + 1L;
			userinfo.setId(userId);
			userinfoList.add(userinfo);
		}
		userinfoService.batchSave(userinfoList);
	}

	@Test
	public void test3BatchSaveAddress() {
		List<AddressVO> addressList = new ArrayList<>();
		for(int i=0;i<200;i++) {
			UserinfoVO userinfo = new UserinfoVO();
			Long userId = i + 1L;
			userinfo.setId(userId);
			for(int j=0;j<2;j++) {
				AddressVO address = new AddressVO();
				address.setId(userId * 2 - j);
				address.setAddress("Address_" + (i + 1) + "_" + (j + 1));
				address.setPhone("155****9784");
				address.setUserinfo(userinfo);
				addressList.add(address);
			}
		}
		addressService.batchSave(addressList);
	}
}