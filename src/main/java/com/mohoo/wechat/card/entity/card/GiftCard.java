/*
 * GiftCard.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.card;

import com.mohoo.wechat.card.entity.coupon.Gift;

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
public class GiftCard extends Card {
	protected Gift gift;

	public GiftCard() {
		this.card_type = "GIFT";
	}

	public GiftCard(Gift gift) {
		this.card_type = "GIFT";
		this.gift = gift;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}
}
