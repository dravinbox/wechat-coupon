/*
 * GroupOnCard.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.card;

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
public class GroupOnCard extends Card {
	protected GroupOn groupon;

	public GroupOnCard() {
		this.card_type = "GROUPON";
	}

	public GroupOnCard(GroupOn groupon) {
		this.card_type = "GROUPON";
		this.groupon = groupon;
	}

	public GroupOn getGroupon() {
		return groupon;
	}

	public void setGroupon(GroupOn groupon) {
		this.groupon = groupon;
	}

}
