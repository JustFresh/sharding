package com.xiudoua.micro.study.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午12:41:57
 */
public class AbsVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8890726499765161493L;

	protected Long id;

	protected Date createTime;

	protected Date optTime;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the optTime
	 */
	public Date getOptTime() {
		return optTime;
	}

	/**
	 * @param optTime the optTime to set
	 */
	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}
	
}