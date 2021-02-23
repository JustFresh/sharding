package com.xiudoua.micro.study.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiudoua.micro.study.constant.CommonConstant;
import com.xiudoua.micro.study.dao.ISequenceDao;
import com.xiudoua.micro.study.entity.SequenceEntity;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月21日 下午6:10:34
 */
@Service
public class SequenceService {
	
	private static final Logger logger = LoggerFactory.getLogger(SequenceService.class);

	/**
	 * 注入SequenceDAO
	 */
	@Autowired
	private ISequenceDao seqDAO;

	/**
	 * 获取下一个自增ID
	 *
	 * @param seqName 序列名称
	 * @return id
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public long getNextVal(String seqName) {
		try {
			SequenceEntity se = seqDAO.findBySeqName(seqName);
			if (Objects.isNull(se)) {
				SequenceEntity sequence = new SequenceEntity();
				sequence.setSeqName(seqName);
				sequence.setMinValue(CommonConstant.SEQUENCE_DEFALUT_MIN_VALUE);
				sequence.setMaxValue(CommonConstant.SEQUENCE_DEFALUT_MAX_VALUE);
				sequence.setCurrentVal(CommonConstant.SEQUENCE_DEFALUT_CURRENT_VAL);
				sequence.setIncrementVal(CommonConstant.SEQUENCE_DEFALUT_INCREMENT_VAL);
				se = seqDAO.save(sequence);
				return CommonConstant.SEQUENCE_DEFALUT_CURRENT_VAL;
			}

			long incrementV = se.getIncrementVal();
			if (incrementV < CommonConstant.SEQUENCE_DEFALUT_MIN_VALUE) {
				incrementV = CommonConstant.SEQUENCE_DEFALUT_MIN_VALUE;
			}

			Long val = se.getCurrentVal();
			Long min = se.getMinValue();
			Long max = se.getMaxValue();
			Long nextVal = val + incrementV;
			if (nextVal > max) {
				nextVal = min;
			}

			if (nextVal < min) {
				nextVal = min;
			}
			se.setCurrentVal(nextVal);
			seqDAO.save(se);
			return nextVal;
		} catch (Exception e) {
			logger.error("使用数据库生成{}表的主键发生异常！",seqName, e);
		}
		return 0;
	}

}