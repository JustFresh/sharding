package com.xiudoua.micro.study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:45:20
 */
@Entity
@Table(name = "TB_CONFIG")
public class ConfigEntity extends AbsEntity{

	@Column(name = "CONFIG_KEY")
	private String key;
	
	@Column(name = "CONFIG_VALUE")
	private String value;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}