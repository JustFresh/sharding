package com.xiudoua.micro.study;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiudoua.micro.study.model.UserinfoVO;
import com.xiudoua.micro.study.service.IUserinfoService;
import com.xiudoua.micro.study.utils.SnowFlakeUtil;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月21日 下午7:16:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InitApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserinfoServiceTest {

	@Autowired
	private IUserinfoService userinfoService;
	
	@Value("${config.snowflake.distributed.data.center.worker.id:0}")
	private int dataCenterWorkerId;
	
	@Value("${config.snowflake.machine.worker.id:0}")
	private int machineWorkerId;
	
	@Test
	public void test1SaveAndReturnByDB() {
		for(int i=0;i<200;i++) {
			UserinfoVO userinfo = new UserinfoVO("user" + i,"**" + i + "**","test" + i + "@qq.com");
			userinfoService.saveAndReturnByDB(userinfo);
		}
	}
	
	@Test
	public void test2SaveAndReturnByRedis() {
		for(int i=0;i<200;i++) {
			UserinfoVO userinfo = new UserinfoVO("user" + i,"**" + i + "**","test" + i + "@qq.com");
			userinfoService.saveAndReturnByRedis(userinfo);
		}
	}
	
	@Test
	public void test3Save() {
		SnowFlakeUtil snowFlake = new SnowFlakeUtil(dataCenterWorkerId,machineWorkerId); 
		for(int i=0;i<200;i++) {
			UserinfoVO userinfo = new UserinfoVO("user" + i,"**" + i + "**","test" + i + "@qq.com");
			userinfo.setId(snowFlake.nextId(false));
			userinfoService.save(userinfo);
		}
	}
}