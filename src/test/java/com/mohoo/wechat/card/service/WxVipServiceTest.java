/*
 * WxVipServiceTest.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.service;

import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mohoo.wechat.card.config.BaseConfig;

/**
 * 类描述
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
public class WxVipServiceTest {
	WxVipService wcs = new WxVipService();
	BaseConfig bc = new BaseConfig();

	@Before
	public void init() {
		String appid="wx9f6e2c93e991fcaa";
		String secret="d4624c36b6795d1d99dcf0547af5443d";
		bc.setGetToken(true);
		bc.setSecret(secret);
		bc.setAppid(appid);
		wcs.setBaseConfig(bc);
	}
//	String CARD_ID="pKXUCj9IQYI_MMiqvSrZ6uXqV_SY";
	String CARD_ID="pVzhVw7gQgM6pr7SQFlAz8vOAYYQ";
//	@Test
	public void createVipCard() {
		String json = "{ \"card\": { \"card_type\": \"MEMBER_CARD\", \"member_card\": { \"base_info\": { \"logo_url\": "
				+ "\"http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZJkmG8xXhiaHqkKSVMMWeN3hLut7X7hicFNjakmxibMLGWpXrEXB33367o7zHN0CwngnQY7zb7g/0\","
				+ " \"brand_name\": \"海底捞\", \"code_type\": \"CODE_TYPE_TEXT\", \"title\": \"test_会员卡\", \"color\": \"Color010\", \"notice\":"
				+ " \"使用时向服务员出示此券\", \"service_phone\": \"020-88888888\", \"description\": \"不可与其他优惠同享\", \"date_info\": { \"type\":"
				+ " \"DATE_TYPE_PERMANENT\" }, \"sku\": { \"quantity\": 50000000 }, \"get_limit\": 3, \"use_custom_code\": false, \"can_give_friend\":"
				+ " true, \"location_id_list\": [ 123, 12321, 345345 ], \"custom_url_name\": \"立即使用\", \"custom_url\": \"http://www.xxx.com\", "
				+ "\"custom_url_sub_title\": \"6个汉字tips\", \"promotion_url_name\": \"营销入口1\", \"promotion_url\": \"http://www.xxx.com\", \"need_push_on_view\": true },"
				+ " \"supply_bonus\": true, \"supply_balance\": false, \"prerogative\": \"test_prerogative\", \"auto_activate\": true, \"custom_field1\":"
				+ " { \"name_type\": \"FIELD_NAME_TYPE_LEVEL\", \"url\": \"http://www.xxx.com\" }, \"activate_url\": \"http://www.xxx.com\", \"custom_cell1\": "
				+ "{ \"name\": \"使用入口2\", \"tips\": \"激活后显示\", \"url\": \"http://www.xxx.com\" }, \"bonus_rule\": {\"cost_money_unit\": 100,\"increase_bonus\":"
				+ " 1,\"max_increase_bonus\": 200,\"init_increase_bonus\": 10,\"cost_bonus_unit\": 5,\"reduce_money\":100,\"least_money_to_use_bonus\": 1000, \"max_reduce_bonus\": 50 }, \"discount\": 10 } }}";
		Map<String, Object> resultMap = null;
		try {
			resultMap = wcs.createVipCard(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resultMap);
		Assert.assertNotNull(resultMap);
		Assert.assertNotNull(resultMap.get("card_id"));
	}
//	@Test
	public void getCard(){
		Map<String, Object> resultMap = null;
		try {
			resultMap = wcs.getCard(CARD_ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resultMap);
		Assert.assertNotNull(resultMap);
		Assert.assertEquals(resultMap.get("errcode").toString(),"0");
	}
//	@Test
	public void groupSendCard(){
		Map<String, Object> resultMap = null;
		try {
			resultMap = wcs.groupSendCard(CARD_ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resultMap);
		Assert.assertNotNull(resultMap);
		Assert.assertEquals(resultMap.get("errcode").toString(),"0");
	}
//	@Test
	public void activate(){
		Map<String, Object> resultMap = null;
		try {
			resultMap = wcs.activate("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resultMap);
		Assert.assertNotNull(resultMap);
		Assert.assertEquals(resultMap.get("errcode").toString(),"0");
	}
//	public void 
	
//	@Test
	public void deleteCard(){
		Map<String, Object> resultMap = null;
		try {
			resultMap = wcs.deleteCard(CARD_ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resultMap);
		Assert.assertNotNull(resultMap);
		Assert.assertEquals(resultMap.get("errcode").toString(),"0");
	}
}
