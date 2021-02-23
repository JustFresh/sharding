package com.xiudoua.micro.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
* @Desc 
* @Author JustFresh
* @Time 2021年2月17日 下午2:10:49
*/
/**
 * @author JustFresh
 *
 */
@EnableJpaAuditing
@SpringBootApplication
public class InitApp {
	
	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
}