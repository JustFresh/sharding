package com.xiudoua.micro.study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午4:33:40
 */
@Entity
@Table(name = "TB_SHARDING_GROUP")
public class ShardingGroupEntity extends AbsEntity{

	/**
	 * 分组标题
	 */
	@Column(name = "TITLE")
	private String title;
	
	/**
	 * 分组是否可写入
	 */
	@Column(name = "WRITE_ABLE")
	private Boolean writeable;
	
	/**
	 * 分组起始写入值
	 */
	@Column(name = "START_ID")
	private Long startId;
	
	/**
	 * 分组最大写入值
	 */
	@Column(name = "END_ID")
	private Long endId;
	
	/**
	 * 分组取模存储的HASH值
	 */
	@Column(name = "HASH_VALUE")
	private Integer hashValue;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the writeable
	 */
	public Boolean getWriteable() {
		return writeable;
	}

	/**
	 * @param writeable the writeable to set
	 */
	public void setWriteable(Boolean writeable) {
		this.writeable = writeable;
	}

	/**
	 * @return the startId
	 */
	public Long getStartId() {
		return startId;
	}

	/**
	 * @param startId the startId to set
	 */
	public void setStartId(Long startId) {
		this.startId = startId;
	}

	/**
	 * @return the endId
	 */
	public Long getEndId() {
		return endId;
	}

	/**
	 * @param endId the endId to set
	 */
	public void setEndId(Long endId) {
		this.endId = endId;
	}

	/**
	 * @return the hashValue
	 */
	public Integer getHashValue() {
		return hashValue;
	}

	/**
	 * @param hashValue the hashValue to set
	 */
	public void setHashValue(Integer hashValue) {
		this.hashValue = hashValue;
	}
	
}