/**
 * @desc
 * @author JustFresh
 * @time 2021年2月17日 下午2:16:32
 */
package com.xiudoua.micro.study.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author JustFresh
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbsEntity{

	@Id
	@Column(name = "ID")
	protected Long id;

	@CreatedDate
    @Column(name = "CREATE_TIME")
	protected Date createTime;

	@LastModifiedDate
	@Column(name = "OPT_TIME")
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