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
 * @time 2021年2月23日 下午4:32:24
 */
@Entity
@Table(name = "TB_SHARDING")
public class ShardingEntity extends AbsEntity{

	/**
	 * 
	 */
	@Column(name = "TITLE")
	private String title;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "GROUP_ID")
	private ShardingGroupEntity group;
	
	/**
	 * 例如： 0,1,2这样的字符串，标识为在这个Shard中可同时支持三组分片
	 */
	@Column(name = "HASH_VALUE_LIST")
	private String hashValueList;
	
	@Column(name = "DB_SUFFIX")
	private String dbSuffix;

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
	 * @return the group
	 */
	public ShardingGroupEntity getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(ShardingGroupEntity group) {
		this.group = group;
	}

	/**
	 * @return the hashValueList
	 */
	public String getHashValueList() {
		return hashValueList;
	}

	/**
	 * @param hashValueList the hashValueList to set
	 */
	public void setHashValueList(String hashValueList) {
		this.hashValueList = hashValueList;
	}

	/**
	 * @return the dbSuffix
	 */
	public String getDbSuffix() {
		return dbSuffix;
	}

	/**
	 * @param dbSuffix the dbSuffix to set
	 */
	public void setDbSuffix(String dbSuffix) {
		this.dbSuffix = dbSuffix;
	}
	
}