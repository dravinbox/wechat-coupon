/*
 * DisCount.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.card;

import com.mohoo.wechat.card.entity.coupon.DisCount;

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
public class DisCountCard extends Card {
	protected DisCount discount;

	public DisCountCard() {
		this.card_type = "DISCOUNT";
	}

	public DisCountCard(DisCount discount) {
		this.card_type = "DISCOUNT";
		this.discount = discount;
	}

	public DisCount getDiscount() {
		return discount;
	}

	public void setDiscount(DisCount discount) {
		this.discount = discount;
	}
}
