/*
 * WxManagerService.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.service;

import java.io.IOException;
import java.util.Map;

import com.mohoo.wechat.card.config.BaseConfig;
import com.mohoo.wechat.card.util.PropertiesUtil;

/**
 * 类描述 <p>
 * 创建日期：2016年7月8日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * @author Administrator
 * @version 1.0
 */
public class WxManagerService extends WxBaseService{
	
	public WxManagerService(){}
	public WxManagerService(BaseConfig bc){
		super(bc);
	}
	/**
	 * 更改code接口
	 * @throws IOException 
	 */
	public Map<String,Object> updateCode(String jsonObject) throws IOException{
		String updateCodeUrl = PropertiesUtil
				.getPropertyPath("weixin.update_code");
		return excutePost(updateCodeUrl, jsonObject);
	}
	/**
	 * 获取卡劵概况接口
	 * 方法描述
	 * @param jsonObject
	 * @return
	 * @throws IOException
	 */
	public Map<String,Object> getCardBizuinfo(String jsonObject) throws IOException{
		String getCardBizuinfoUrl = PropertiesUtil
				.getPropertyPath("weixin.get_card_bizuinfo");
		return excutePost(getCardBizuinfoUrl, jsonObject);
	}
	
	/**
	 *  获取免费券数据接口
	 * 方法描述
	 * @param jsonObject
	 * @return
	 * @throws IOException
	 */
	public Map<String,Object> getCardCardinfo(String jsonObject) throws IOException{
		String getCardCardinfoUrl = PropertiesUtil
				.getPropertyPath("weixin.get_card_cardinfo");
		return excutePost(getCardCardinfoUrl, jsonObject);
	}
}
