package com.xiudoua.micro.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午4:05:52
 */
@EnableJpaAuditing
@SpringBootApplication
public class InitApp {
	
	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
}