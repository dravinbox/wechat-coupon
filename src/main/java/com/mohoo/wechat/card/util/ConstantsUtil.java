/*
 * ConstantsUtil.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.util;

import com.alibaba.fastjson.JSONObject;
import com.mohoo.wechat.card.entity.CardInfo;
import com.mohoo.wechat.card.entity.absract.AdvancedInfo;
import com.mohoo.wechat.card.entity.baseinfo.BaseInfo;
import com.mohoo.wechat.card.entity.card.GroupOnCard;
import com.mohoo.wechat.card.entity.coupon.GroupOn;

/**
 * 类描述
 * <p>
 * 创建日期：2016年7月1日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author Administrator
 * @version 1.0
 */
public class ConstantsUtil {
	public static void main(String[] args) {
		GroupOn go = new GroupOn();
		go.setBase_info(new BaseInfo());
		go.setDeal_detail("123");
		AdvancedInfo ai = new AdvancedInfo();
		System.out.println("info:" + JSONObject.toJSON(go));
		System.out.println("info:" + JSONObject.toJSON(ai));

		CardInfo card = new CardInfo(new GroupOnCard(go));
		System.out.println("info:" + JSONObject.toJSON(card));
	}
}
