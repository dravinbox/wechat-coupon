/*
 * WxVipService.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.mohoo.wechat.card.config.BaseConfig;
import com.mohoo.wechat.card.util.PropertiesUtil;

/**
 * 会员接口 类描述
 * <p>
 * 创建日期：2016年7月8日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author Administrator
 * @version 1.0
 */
public class WxVipService extends WxCreateService {

	public WxVipService(){}
	public WxVipService(BaseConfig bc){
		super(bc);
	}
	/**
	 * 创建会员卡劵 方法描述
	 * 
	 * @param jsonObject
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> createVipCard(String jsonObject)
			throws IOException {
		String createUrl = PropertiesUtil.getPropertyPath("weixin.card_create");
		return excutePost(createUrl, jsonObject);
	}

	/**
	 * 查看卡劵详情接口 方法描述
	 * 
	 * @param cardId
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> getCard(String cardId) throws IOException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", cardId);
		String getCardUrl = PropertiesUtil.getPropertyPath("weixin.get_card");
		return excutePost(getCardUrl, JSONObject.toJSONString(paramMap));
	}

	/**
	 * 群发卡券 方法描述
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> groupSendCard(String cardId) throws IOException {
		String grouSendCardUrl = PropertiesUtil
				.getPropertyPath("weixin.group_send_card");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", cardId);
		return excutePost(grouSendCardUrl, JSONObject.toJSONString(paramMap));
	}

	/**
	 * 接口激活
	 * 
	 * @throws IOException
	 */
	public Map<String, Object> activate(String jsonObject) throws IOException {
		String activateUrl = PropertiesUtil.getPropertyPath("weixin.activate");
		return excutePost(activateUrl, jsonObject);
	}

	/**
	 * 设置开卡字段接口 方法描述
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> setActivateUserForm(String jsonObject)
			throws IOException {
		String userFormUrl = PropertiesUtil
				.getPropertyPath("weixin.activate_user_form");
		return excutePost(userFormUrl, jsonObject);
	}

	/**
	 * 拉取会员信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> getUserInfo(String cardId, String code)
			throws IOException {
		String userInfoUrl = PropertiesUtil
				.getPropertyPath("weixin.get_userinfo");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", cardId);
		paramMap.put("code", code);
		return excutePost(userInfoUrl, JSONObject.toJSONString(paramMap));
	}

	/**
	 * 更新会员信息 方法描述
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> updateUser(String jsonObject) throws IOException {
		String updateUserUrl = PropertiesUtil
				.getPropertyPath("weixin.update_user");
		return excutePost(updateUserUrl, jsonObject);
	}

	/**
	 * 获取用户已领取的卡券
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> getCardIdList(String openId, String cardId)
			throws IOException {
		String getCardIdListUrl = PropertiesUtil
				.getPropertyPath("weixin.get_card_list");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("openid", openId);
		paramMap.put("card_id", cardId);
		return excutePost(getCardIdListUrl, JSONObject.toJSONString(paramMap));
	}

	/**
	 * 批量查询卡列表 方法描述
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> batchGetCard(String jsonObject)
			throws IOException {
		String batchGetCardUrl = PropertiesUtil
				.getPropertyPath("weixin.batch_get_card");
		return excutePost(batchGetCardUrl, jsonObject);
	}

	/**
	 * 更改卡券信息 方法描述
	 * 
	 * @param jsonObject
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> updateCard(String jsonObject) throws IOException {
		String updateCardUrl = PropertiesUtil
				.getPropertyPath("weixin.update_card");
		return excutePost(updateCardUrl, jsonObject);
	}
	/**
	 * 修改库存接口
	 * 方法描述
	 * @param jsonObject
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> updateStock(String jsonObject)
			throws IOException {
		String updateStockUrl = PropertiesUtil
				.getPropertyPath("weixin.update_stock");
		return excutePost(updateStockUrl, jsonObject);
	}
	/**
	 * 删除卡劵
	 * 方法描述
	 * @param cardId
	 * @return
	 * @throws IOException
	 */
	public Map<String,Object> deleteCard(String cardId) throws IOException{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", cardId);
		String deleteCardUrl = PropertiesUtil
				.getPropertyPath("weixin.delete_card");
		return excutePost(deleteCardUrl, JSONObject.toJSONString(paramMap));
	}
	/**
	 * 设置卡券失效
	 * 方法描述
	 * @param jsonObject
	 * @return
	 * @throws IOException
	 */
	public Map<String,Object> setUnavailable(String jsonObject) throws IOException{
		String setUnavailableUrl = PropertiesUtil
				.getPropertyPath("weixin.set_unavailablel");
		return excutePost(setUnavailableUrl, jsonObject);
	}
	
	/**
	 * 拉取会员卡数据
	 * @throws IOException 
	 */
	public Map<String,Object> getCardMemeberCardInfo(String jsonObject) throws IOException{
		String getCardMemeberCardInfoUrl = PropertiesUtil
				.getPropertyPath("weixin.get_card_memeber_cardindo");
		return excutePost(getCardMemeberCardInfoUrl, jsonObject);
	}
}
