/*
 * WxServiceTest.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.alibaba.fastjson.JSONObject;
import com.mohoo.wechat.card.config.BaseConfig;
import com.mohoo.wechat.card.entity.CardInfo;
import com.mohoo.wechat.card.entity.absract.Abstract;
import com.mohoo.wechat.card.entity.absract.AdvancedInfo;
import com.mohoo.wechat.card.entity.absract.TextImage;
import com.mohoo.wechat.card.entity.absract.TimeLimit;
import com.mohoo.wechat.card.entity.absract.UseCondition;
import com.mohoo.wechat.card.entity.baseinfo.BaseInfo;
import com.mohoo.wechat.card.entity.baseinfo.DateInfo;
import com.mohoo.wechat.card.entity.card.GroupOnCard;
import com.mohoo.wechat.card.entity.coupon.GroupOn;

/**
 * 类描述
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WxServiceTest {
	WxConsumeService wcs = new WxConsumeService();
	WxCreateService wcrs =new WxCreateService();
	WxPushService wps=new WxPushService();

	public static String IMG_URL = "http://mmbiz.qpic.cn/mmbiz/LLialCGQGiaEd0RibuxJWUVrYLJIh8pAyxz71pXXSXYgQOlaekYmXcOmxQVUxZ2wA3icLMIn044IggSFc63wVtASsA/0";
	public static String CARD_ID = "pKXUCj0H0h4XsVe4znnvMdL63Ti0";
	public static String OPEN_ID = "oKXUCjyMRHD12cQLDxZiLpxtEdJE";
	BaseConfig bc = new BaseConfig();

	// public static String OPEN_ID="oVzhVw9-PXV427t6PWjDWxyoaoQ4";
	 @Before
	public void init() {
		wcs.setBaseConfig(bc);
		wps.setBaseConfig(bc);
		wcrs.setBaseConfig(bc);
	}

	/**
	 * http://mmbiz.qpic.cn/mmbiz/
	 * LLialCGQGiaEd0RibuxJWUVrYLJIh8pAyxz71pXXSXYgQOlaekYmXcOmxQVUxZ2wA3icLMIn044IggSFc63wVtASsA
	 * /0 上传logo 方法描述
	 */
//	 @Test
	public void uploadImage() {
		String imgurl = null;
		try {
			imgurl = wcrs.uploadImgToJson(new File("file/test.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("imgurl:" + imgurl);
		IMG_URL = imgurl;
		Assert.assertNotNull(imgurl);
	}

	/**
	 * pVzhVw_RWKVJqMNFsNlPC698yb14 创建卡劵 方法描述
	 */
	// @Test
	public void createCard() {
		String cardId = null;
		try {
			// wcs.createCardToJson("");
			BaseInfo bi = new BaseInfo();
			bi.setLogo_url(IMG_URL);
			bi.setBrand_name("测试餐厅");
			bi.setCode_type("CODE_TYPE_TEXT");
			bi.setTitle("huang——测试卡劵");
			bi.setSub_title("周末狂欢必备");
			bi.setColor(BaseInfo.COLOR010);
			bi.setNotice("使用时向服务员出示此券");
			bi.setService_phone("020-88888888");
			bi.setDescription("不可与其他优惠同享\n如需团购券发票，请在消费时向商户提出\n店内均可使用，仅限堂食");
			bi.setDate_info(new DateInfo("DATE_TYPE_FIX_TIME_RANGE",
					1397577600, 1472724261));
			bi.setSku(new HashMap<String, Object>() {
				{
					put("quantity", "50000");
				}
			});
			bi.setGet_limit(3);
			bi.setUse_custom_code(false);
			bi.setBind_openid(false);
			bi.setCan_share(true);
			bi.setCan_give_friend(true);
			bi.setLocation_id_list(new int[] { 123, 123456, 123456789 });
			bi.setCenter_title("立即使用");
			bi.setCenter_sub_title("按钮下方的wording");
			bi.setCenter_url("www.qq.com");
			bi.setCustom_url_name("立即使用");
			bi.setCustom_url("http://www.qq.com/");
			bi.setCustom_url_sub_title("6个汉字tips");
			bi.setPromotion_url_sub_title("小标题优惠");
			bi.setPromotion_url_name("更多优惠");
			bi.setPromotion_url("http://www.qq.com/");
			bi.setSource("大众点评");
			AdvancedInfo ai = new AdvancedInfo();
			ai.setUse_condition(new UseCondition("鞋类", "阿迪达斯", true));
			ai.setAbstract(new Abstract(
					"微信餐厅推出多种新季菜品，期待您的光临",
					new String[] { "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0" }));
			ai.setText_image_list(new TextImage[] {

					new TextImage(
							"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0",
							"此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾"),
					new TextImage(
							"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0",
							"此菜品迎合大众口味，老少皆宜，营养均衡") });
			TimeLimit tl = new TimeLimit();
			tl.setType("HOLIDAY");
			ai.setTime_limit(new TimeLimit[] {
					new TimeLimit("MONDAY", 0, 10, 10, 59), tl });
			ai.setBusiness_service(new String[] { "BIZ_SERVICE_FREE_WIFI",
					"BIZ_SERVICE_WITH_PET", "BIZ_SERVICE_FREE_PARK",
					"BIZ_SERVICE_DELIVER" });
			GroupOn go = new GroupOn();
			go.setAdvanced_info(ai);
			go.setBase_info(bi);
			;
			go.setDeal_detail("以下锅底2选1（有菌王锅、麻辣锅、大骨锅、番茄锅、清补 凉锅、酸菜鱼锅可选）：\n大锅1份 12元\n小锅2份 16元");
			GroupOnCard card = new GroupOnCard(go);
			CardInfo cardInfo = new CardInfo(card);
			String info = JSONObject.toJSONString(cardInfo);
			System.out.println(info);
			cardId = wcrs.createCardToJson(cardInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("cardId:" + cardId);
		CARD_ID = cardId;
		Assert.assertNotNull(cardId);
	}

	/**
	 * 创建二维码 方法描述
	 */
	// @After
	public void creatQrcode() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("action_name", "QR_CARD");
		paramMap.put("expire_seconds", 1800);
		Map<String, Object> actionMap = new HashMap<String, Object>();

		Map<String, Object> cardMap = new HashMap<String, Object>();
		cardMap.put("card_id", CARD_ID);
		cardMap.put("code", "123456789_test");
		cardMap.put("openid", OPEN_ID);
		cardMap.put("is_unique_code", false);
		cardMap.put("outer_id", 1);
		actionMap.put("card", cardMap);
		paramMap.put("action_info", actionMap);
		System.out.println(paramMap);
		Map<String, Object> resultMap = null;
		try {
			resultMap = wps.createQrcode(paramMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resultMap);
		Assert.assertNotNull(resultMap);
		Assert.assertNotNull(resultMap.get("show_qrcode_url"));
		Assert.assertNotNull(resultMap.get("ticket"));
		String qrcodeurl = resultMap.get("show_qrcode_url").toString();
		String ticket = resultMap.get("ticket").toString();
		System.out.println(qrcodeurl);
		System.out.println(ticket);
	}

	/**
	 * 设置测试白名单 方法描述
	 */
	// @Test
	public void setTestWhiteList() {
		Map<String, Object> resultMap = null;
		try {
			resultMap = wps.testWhiteList(new String[] { OPEN_ID }, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(resultMap);
		System.out.println(resultMap);
		Assert.assertEquals(resultMap.get("errcode").toString(), "0");
	}

	/**
	 * 查询code
	 */
	String code = "947363396944";

	// @Test
	public void searchCode() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("card_id", CARD_ID);
		paramMap.put("code", code);
		paramMap.put("check_consume", true);
		Map<String, Object> resultMap = null;
		try {
			resultMap = wcs.getCode(paramMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("searchCode:" + resultMap);
		Assert.assertNotNull(resultMap);
		Assert.assertEquals(resultMap.get("errcode").toString(), "0");
	}

	/**
	 * 核销卡劵 方法描述
	 */
	// @Test
	public void consumeCard() {
		Map<String, Object> resultMap = null;
		try {
			resultMap = wcs.consumeCode(CARD_ID, code);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resultMap);
		Assert.assertNotNull(resultMap);
		Assert.assertEquals(resultMap.get("errcode").toString(), "0");
	}
}
