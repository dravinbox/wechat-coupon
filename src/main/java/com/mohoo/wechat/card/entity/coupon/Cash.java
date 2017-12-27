/*
 * Cash.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.coupon;

/**
 * 代金券 类描述
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
public class Cash extends Coupon {
	protected int least_cost;
	protected int reduce_cost;

	public int getLeast_cost() {
		return least_cost;
	}

	public void setLeast_cost(int least_cost) {
		this.least_cost = least_cost;
	}

	public int getReduce_cost() {
		return reduce_cost;
	}

	public void setReduce_cost(int reduce_cost) {
		this.reduce_cost = reduce_cost;
	}

}
