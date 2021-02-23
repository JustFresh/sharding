package com.xiudoua.micro.study.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月21日 下午2:00:31
 */
@Entity
@Table(name = "TB_SEQUENCE",uniqueConstraints = @UniqueConstraint(columnNames = {"SEQ_NAME"}))
public class SequenceEntity{
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@CreatedDate
    @Column(name = "CREATE_TIME")
	protected Date createTime;

	@LastModifiedDate
	@Column(name = "OPT_TIME")
	protected Date optTime;

	/**
     * 序列名称
     */
    @Column(name = "SEQ_NAME", length = 50)
    private String seqName;

    /**
     * 最小数
     */
    @Column(name = "MIN_VALUE")
    private Long minValue;

    /**
     * 最大数
     */
    @Column(name = "MAX_VALUE")
    private Long maxValue;

    /**
     * 当前数
     */
    @Column(name = "CURRENT_VAL")
    private Long currentVal;

    /**
     * 增长数
     */
    @Column(name = "INCREMENT_VAL")
    private Long incrementVal;

	/**
	 * @return the seqName
	 */
	public String getSeqName() {
		return seqName;
	}

	/**
	 * @param seqName the seqName to set
	 */
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	/**
	 * @return the minValue
	 */
	public Long getMinValue() {
		return minValue;
	}

	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(Long minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the maxValue
	 */
	public Long getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the currentVal
	 */
	public Long getCurrentVal() {
		return currentVal;
	}

	/**
	 * @param currentVal the currentVal to set
	 */
	public void setCurrentVal(Long currentVal) {
		this.currentVal = currentVal;
	}

	/**
	 * @return the incrementVal
	 */
	public Long getIncrementVal() {
		return incrementVal;
	}

	/**
	 * @param incrementVal the incrementVal to set
	 */
	public void setIncrementVal(Long incrementVal) {
		this.incrementVal = incrementVal;
	}

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