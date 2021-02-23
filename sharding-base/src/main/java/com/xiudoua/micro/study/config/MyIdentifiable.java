package com.xiudoua.micro.study.config;

import java.io.Serializable;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午10:05:14
 */
public interface MyIdentifiable<T extends Serializable> {
	
    T getId();
    
}