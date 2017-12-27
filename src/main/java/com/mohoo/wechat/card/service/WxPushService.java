/*
 * WxPushService.java
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
 * 投放卡劵 类描述
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
public class WxPushService extends WxBaseService {
	
	public WxPushService(){}
	public WxPushService(BaseConfig bc){
		super(bc);
	}
	/**
	 * 创建二维码 方法描述
	 * 
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> createQrcode(Map<String, Object> paramMap)
			throws IOException {
		String createQrcodeUrl = PropertiesUtil
				.getPropertyPath("weixin.qrcode_create");
		return excutePost(createQrcodeUrl, JSONObject.toJSONString(paramMap));
	}

	public Map<String, Object> createQrcode(String Json) throws IOException {
		String createQrcodeUrl = PropertiesUtil
				.getPropertyPath("weixin.qrcode_create");
		return excutePost(createQrcodeUrl, Json);
	}

	/**
	 * 创建货架 方法描述
	 * 
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> createLandingpage(Map<String, Object> paramMap)
			throws IOException {
		String createLandingpageUrl = PropertiesUtil
				.getPropertyPath("weixin.landingpage_create");
		return excutePost(createLandingpageUrl,
				JSONObject.toJSONString(paramMap));
	}

	public Map<String, Object> createLandingpage(String json)
			throws IOException {
		String createLandingpageUrl = PropertiesUtil
				.getPropertyPath("weixin.landingpage_create");
		return excutePost(createLandingpageUrl, json);
	}

	/**
	 * 导入code接口 方法描述
	 * 
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> depositCode(Map<String, Object> paramMap)
			throws IOException {
		String depositCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.deposit_code");
		return excutePost(depositCodeUrl, JSONObject.toJSONString(paramMap));
	}

	public Map<String, Object> depositCode(String json) throws IOException {
		String depositCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.deposit_code");
		return excutePost(depositCodeUrl, json);
	}

	/**
	 * 查询导入code数目接口 方法描述
	 * 
	 * @param cardId
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> getDepositCount(String cardId)
			throws IOException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", cardId);
		String getDepositCountUrl = PropertiesUtil
				.getPropertyPath("weixin.deposit_code");
		return excutePost(getDepositCountUrl, JSONObject.toJSONString(paramMap));
	}

	public int getDepositCountToJson(String cardId) throws IOException {
		String getDepositCountUrl = PropertiesUtil
				.getPropertyPath("weixin.getdepositcount");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", cardId);
		Map<String, Object> resultMap = excutePost(getDepositCountUrl,
				JSONObject.toJSONString(paramMap));
		if (resultMap.get("errcode") != null) {
			if (StringUtils.equals(resultMap.get("errcode").toString(), "0")) {
				return Integer.parseInt(resultMap.get("count").toString());
			}
		}
		throw new IOException("code:" + resultMap.get("errcode") + ",info"
				+ resultMap.get("errmsg"));
	}

	/**
	 * 核查code 方法描述
	 * 
	 * @param cardId
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> checkCode(String cardId, int[] code)
			throws IOException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", cardId);
		paramMap.put("code", code);
		String checkCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.checkcode");
		return excutePost(checkCodeUrl, JSONObject.toJSONString(paramMap));
	}

	public Map<String, Object> checkCode(String json) throws IOException {
		String checkCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.checkcode");
		return excutePost(checkCodeUrl, json);
	}

	/**
	 * 图文消息群发卡劵 方法描述
	 * 
	 * @param cardId
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> mpNewsGetHtml(String cardId) throws IOException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", cardId);
		String mpNewsGetHtml = PropertiesUtil
				.getPropertyPath("weixin.mpnews_gethtml");
		return excutePost(mpNewsGetHtml, JSONObject.toJSONString(paramMap));
	}

	/**
	 * 设置测试白名单 方法描述
	 * 
	 * @param openids
	 * @param username
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> testWhiteList(String[] openids,
			String[] usernames) throws IOException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("openid", openids);
		paramMap.put("username", usernames);
		String testWhiteListUrl = PropertiesUtil
				.getPropertyPath("weixin.testwhitelist");
		return excutePost(testWhiteListUrl, JSONObject.toJSONString(paramMap));
	}

	public Map<String, Object> testWhiteList(String json) throws IOException {
		String testWhiteListUrl = PropertiesUtil
				.getPropertyPath("weixin.testwhitelist");
		return excutePost(testWhiteListUrl, json);
	}
}
