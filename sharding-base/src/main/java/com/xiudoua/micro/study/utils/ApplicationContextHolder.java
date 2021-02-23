package com.xiudoua.micro.study.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午4:30:47
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware{

	private static ApplicationContext applicationContext = null;

	/**
	 * 获取applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext属性未注入, 请在SpringBoot启动类中注册SpringContextHolder.");
		} else {
			return applicationContext;
		}
	}

	/**
	 * 通过name获取 Bean
	 * 
	 * @param name 类名称
	 * @return 实例对象
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	/**
	 * 通过class获取Bean
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	/**
	 * 通过name,以及Clazz返回指定的Bean
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextHolder.applicationContext = applicationContext;
	}

}