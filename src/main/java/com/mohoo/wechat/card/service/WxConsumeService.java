/*
 * WxConsumeService.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.mohoo.wechat.card.config.BaseConfig;
import com.mohoo.wechat.card.util.PropertiesUtil;

/**
 * 核销卡劵 类描述
 * <p>
 * 创建日期：2016年7月4日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author Administrator
 * @version 1.0
 */
public class WxConsumeService extends WxBaseService {
	
	public WxConsumeService(){}
	public WxConsumeService(BaseConfig bc){
		super(bc);
	}
	
	/**
	 * 查询code接口 方法描述
	 * 
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> getCode(Map<String, Object> paramMap)
			throws IOException {
		String getCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.get_code");
		return excutePost(getCodeUrl, JSONObject.toJSONString(paramMap));
	}
	public Map<String, Object> getCode(String json)
			throws IOException {
		String getCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.get_code");
		return excutePost(getCodeUrl, json);
	}

	/**
	 * 核销code接口 方法描述
	 * 
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> consumeCode(Map<String, Object> paramMap)
			throws IOException {
		String consumeCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.consume_code");
		return excutePost(consumeCodeUrl, JSONObject.toJSONString(paramMap));
	}

	public Map<String, Object> consumeCode(String cardId, String code)
			throws IOException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("code", code);
		paramMap.put("card_id", cardId);
		String consumeCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.consume_code");
		return excutePost(consumeCodeUrl, JSONObject.toJSONString(paramMap));
	}
	
	public Map<String, Object> consumeCode(String json)
			throws IOException {
		String consumeCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.consume_code");
		return excutePost(consumeCodeUrl,json);
	}

	/**
	 * code解码接口 方法描述
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> decryptCode(String encrptCode)
			throws IOException {
		String consumeCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.consume_code");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("encrypt_code", encrptCode);
		return excutePost(consumeCodeUrl, JSONObject.toJSONString(paramMap));
	}

	public String decryptCodeToJson(String encrptCode) throws IOException {
		String consumeCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.consume_code");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("encrypt_code", encrptCode);
		Map<String, Object> resultMap = excutePost(consumeCodeUrl,
				JSONObject.toJSONString(paramMap));
		if (resultMap.get("errcode") != null) {
			if (StringUtils.equals(resultMap.get("errcode").toString(), "0")) {
				return resultMap.get("code").toString();
			}
		}
		throw new IOException("code:" + resultMap.get("errcode") + ",info"
				+ resultMap.get("errmsg"));
	}
}
