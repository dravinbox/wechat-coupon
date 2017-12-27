/*
 * WxCreateService.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.mohoo.wechat.card.config.BaseConfig;
import com.mohoo.wechat.card.entity.CardInfo;
import com.mohoo.wechat.card.util.PropertiesUtil;

/**
 * 创建卡劵 类描述
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
public class WxCreateService extends WxBaseService {
	
	public WxCreateService(){}
	public WxCreateService(BaseConfig bc){
		super(bc);
	}
	/**
	 * 上传图片 方法描述 http:\/\/mmbiz.qpic.cn\/mmbiz\/
	 * LLialCGQGiaEeTccVzMHyaFebQlxJUOy2vjkIsib8uTENiayyrdCF6WzpvVQn3CVXS2eqOLIsbiaHdj502GeHoRckVw
	 * \/0
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> uploadImg(File file) throws IOException {
		String imgUrl = PropertiesUtil
				.getPropertyPath("weixin.uploadimg");
		return excutePostFile(imgUrl, file);
	}

	public String uploadImgToJson(File file) throws IOException {
		String imgUrl = PropertiesUtil
				.getPropertyPath("weixin.uploadimg");
		Map<String, Object> resultMap = excutePostFile(imgUrl, file);
		if (resultMap.get("url") != null) {
			return resultMap.get("url").toString();
		} else {
			throw new IOException("code:" + resultMap.get("errcode") + ",info"
					+ resultMap.get("errmsg"));
		}
	}
	
	/**
	 * 创建卡劵 3种类型，6种方法
	 * 
	 * @param cardInfo
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> createCard(CardInfo cardInfo) throws IOException {
		String jsonObject = JSONObject.toJSONString(cardInfo);
		return callCreateCard(jsonObject);
	}

	public Map<String, Object> createCard(Map<String, Object> paramMap)
			throws IOException {
		String jsonObject = JSONObject.toJSONString(paramMap);
		return callCreateCard(jsonObject);
	}

	public Map<String, Object> createCard(String jsonObject) throws IOException {
		return callCreateCard(jsonObject);
	}

	public String createCardToJson(CardInfo cardInfo) throws IOException {
		String jsonObject = JSONObject.toJSONString(cardInfo);
		Map<String, Object> resultMap = callCreateCard(jsonObject);
		if (resultMap.get("card_id") != null) {
			return resultMap.get("card_id").toString();
		} else {
			throw new IOException("code:" + resultMap.get("errcode") + ",info"
					+ resultMap.get("errmsg"));
		}
	}

	public String createCardToJson(Map<String, Object> paramMap)
			throws IOException {
		String jsonObject = JSONObject.toJSONString(paramMap);
		Map<String, Object> resultMap = callCreateCard(jsonObject);
		if (resultMap.get("card_id") != null) {
			return resultMap.get("card_id").toString();
		} else {
			throw new IOException("code:" + resultMap.get("errcode") + ",info"
					+ resultMap.get("errmsg"));
		}
	}

	public String createCardToJson(String jsonObject) throws IOException {
		Map<String, Object> resultMap = callCreateCard(jsonObject);
		if (resultMap.get("card_id") != null) {
			return resultMap.get("card_id").toString();
		} else {
			throw new IOException("code:" + resultMap.get("errcode") + ",info"
					+ resultMap.get("errmsg"));
		}
	}

	protected Map<String, Object> callCreateCard(String json)
			throws IOException {
		String createUrl = PropertiesUtil
				.getPropertyPath("weixin.card_create");
		return excutePost(createUrl, json);
	}

	/**
	 * 设置买单接口 方法描述
	 * 
	 * @param CardId
	 * @param isOpen
	 * @throws IOException
	 */
	public Map<String, Object> setPayCell(String CardId, boolean isOpen)
			throws IOException {
		String payCellUrl = PropertiesUtil
				.getPropertyPath("weixin.paycell");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", CardId);
		paramMap.put("is_open", isOpen);
		return excutePost(payCellUrl, JSONObject.toJSONString(paramMap));
	}

	public boolean setPayCellToJson(String CardId, boolean isOpen)
			throws IOException {
		String payCellUrl = PropertiesUtil
				.getPropertyPath("weixin.paycell");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", CardId);
		paramMap.put("is_open", isOpen);
		Map<String, Object> resultMap = excutePost(payCellUrl,
				JSONObject.toJSONString(paramMap));
		if (resultMap.get("errcode") != null) {
			if (StringUtils.equals(resultMap.get("errcode").toString(), "0")) {
				return true;
			}
		}
		throw new IOException("code:" + resultMap.get("errcode") + ",info"
				+ resultMap.get("errmsg"));
	}

	/**
	 * 设置自主核销 方法描述
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> setSelfconsumecell(String CardId, boolean isOpen)
			throws IOException {
		String selfconsumecellUrl = PropertiesUtil
				.getPropertyPath("weixin.selfconsumecell");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", CardId);
		paramMap.put("is_open", isOpen);
		return excutePost(selfconsumecellUrl, JSONObject.toJSONString(paramMap));
	}

	public boolean setSelfconsumecellToJson(String CardId, boolean isOpen)
			throws IOException {
		String selfconsumecellUrl = PropertiesUtil
				.getPropertyPath("weixin.selfconsumecell");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", CardId);
		paramMap.put("is_open", isOpen);
		Map<String, Object> resultMap = excutePost(selfconsumecellUrl,
				JSONObject.toJSONString(paramMap));
		if (resultMap.get("errcode") != null) {
			if (StringUtils.equals(resultMap.get("errcode").toString(), "0")) {
				return true;
			}
		}
		throw new IOException("code:" + resultMap.get("errcode") + ",info"
				+ resultMap.get("errmsg"));
	}
}
