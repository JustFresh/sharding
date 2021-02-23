package com.xiudoua.micro.study.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月23日 下午4:31:44
 */
@Entity
@Table(name = "TB_FRAGMENT")
public class FragmentEntity extends AbsEntity{

	@Column(name = "TITLE")
	private String title;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SHARD_ID")
	private ShardingEntity shard;
	
	@Column(name = "START_ID")
	private Long startId;
	
	@Column(name = "END_ID")
	private Long endId;
	
	@Column(name = "TABLE_SUFFIX")
	private String tableSuffix;

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
	 * @return the shard
	 */
	public ShardingEntity getShard() {
		return shard;
	}

	/**
	 * @param shard the shard to set
	 */
	public void setShard(ShardingEntity shard) {
		this.shard = shard;
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
	 * @return the tableSuffix
	 */
	public String getTableSuffix() {
		return tableSuffix;
	}

	/**
	 * @param tableSuffix the tableSuffix to set
	 */
	public void setTableSuffix(String tableSuffix) {
		this.tableSuffix = tableSuffix;
	}

}