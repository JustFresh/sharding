package com.xiudoua.micro.study.utils;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午1:05:22
 */
public class JsonUtil {

	private static Logger log = LoggerFactory.getLogger(JsonUtil.class);

	private static ObjectMapper objectMapper = new ObjectMapper();
	// 日起格式化
	private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
	static {
		// 对象的所有字段全部列入
		objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		// 取消默认转换timestamps形式
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		// 忽略空Bean转json的错误
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		// 所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
		objectMapper.setDateFormat(new SimpleDateFormat(STANDARD_FORMAT));
		// 忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * 对象转Json格式字符串
	 * 
	 * @param obj 对象
	 * @return Json格式字符串
	 */
	public static <T> String objectToJson(T obj) {
		if (obj == null) {
			return null;
		}
		try {
			return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.warn("Parse Object to String error : {}", e.getMessage());
			return null;
		}
	}

	/**
	 * 对象转Json格式字符串(格式化的Json字符串)
	 * 
	 * @param obj 对象
	 * @return 美化的Json格式字符串
	 */
	public static <T> String obj2StringPretty(T obj) {
		if (obj == null) {
			return null;
		}
		try {
			return obj instanceof String ? (String) obj
					: objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.warn("Parse Object to String error : {}", e.getMessage());
			return null;
		}
	}

	/**
	 * 字符串转换为自定义对象
	 * 
	 * @param str   要转换的字符串
	 * @param clazz 自定义对象的class对象
	 * @return 自定义对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T string2Obj(String str, Class<T> clazz) {
		if (StringUtils.isEmpty(str) || clazz == null) {
			return null;
		}
		try {
			return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
		} catch (Exception e) {
			log.warn("Parse String to Object error : {}", e.getMessage());
			return null;
		}
	}
	
}