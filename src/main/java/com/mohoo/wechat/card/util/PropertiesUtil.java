package com.mohoo.wechat.card.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 获取properties文件信息
 * @author Administrator
 *
 */
public class PropertiesUtil {
	
	public static final String ENCODING = "UTF-8";
	/**
	 * 根据名称获取properties文件信息
	 * @param key
	 * @return
	 */
	public static String getPropertyPath(String key) {
		InputStream inputStream = new PropertiesUtil().getClass().getClassLoader()
				.getResourceAsStream("projectInfo.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		String value = p.getProperty(key);
		if (value == null){
		    return null;
		}
	         // 编码转换，从ISO8859-1转向指定编码
		try {
		    value = new String(value.getBytes("ISO8859-1"), ENCODING);
		} catch (UnsupportedEncodingException e) {
		    value=null;
		}
		return value;
	}
	/**
	 * 根据名称获取properties文件信息
	 * @param key
	 * @return
	 */
	public static String getPropertyFile(String fileName,String key) {
		InputStream inputStream = new PropertiesUtil().getClass().getClassLoader()
				.getResourceAsStream(fileName);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		String value = p.getProperty(key);
		if (value == null){
		    return null;
		}
	         // 编码转换，从ISO8859-1转向指定编码
		try {
		    value = new String(value.getBytes("ISO8859-1"), ENCODING);
		} catch (UnsupportedEncodingException e) {
		    value=null;
		}
		return value;
	}
}
