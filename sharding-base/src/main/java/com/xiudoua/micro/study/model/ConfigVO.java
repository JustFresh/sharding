package com.xiudoua.micro.study.model;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:47:12
 */
public class ConfigVO extends AbsVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -198507157444531961L;
	
	private String key;
	
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