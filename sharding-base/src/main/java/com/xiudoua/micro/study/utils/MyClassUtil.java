package com.xiudoua.micro.study.utils;

import javax.persistence.Table;

import org.springframework.util.StringUtils;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月21日 下午6:45:27
 */
public class MyClassUtil {

	/**
	 * 
	 * @param cls
	 * @return
	 */
	public static String getTableName(Class<?> cls) {
        // 获取表名
        String tableName = JavaNameToTableName(cls.getSimpleName());
        Table annotation[] = cls.getDeclaredAnnotationsByType(Table.class);
        if (annotation != null && annotation.length > 0) {
            tableName = annotation[0].name();
        }
        return tableName;
    }
	
	/**
	 * 
	 * @param fieldName
	 * @return
	 */
	private static String JavaNameToTableName(String fieldName) {
        if (!StringUtils.isEmpty(fieldName)) {
            StringBuilder columnName = new StringBuilder();
            char chars[] = fieldName.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                // 如果出现大写字母,增加一个下划线
                if (i != 0 && Character.isUpperCase(chars[i])) {
                    columnName.append("_");
                }
                columnName.append(chars[i]);
            }
            return columnName.toString().toLowerCase();
        }
        return null;
    }
}