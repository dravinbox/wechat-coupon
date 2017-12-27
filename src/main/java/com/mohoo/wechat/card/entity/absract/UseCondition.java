/*
 * UseCondition.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.absract;

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
public class UseCondition {
	protected String accept_category;
	protected String reject_category;
	protected boolean can_use_with_other_discount;

	public UseCondition() {
	}

	public UseCondition(String accept_category, String reject_category,
			boolean can_use_with_other_discount) {
		this.accept_category = accept_category;
		this.reject_category = reject_category;
		this.can_use_with_other_discount = can_use_with_other_discount;
	}

	public String getAccept_category() {
		return accept_category;
	}

	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}

	public String getReject_category() {
		return reject_category;
	}

	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}

	public boolean isCan_use_with_other_discount() {
		return can_use_with_other_discount;
	}

	public void setCan_use_with_other_discount(
			boolean can_use_with_other_discount) {
		this.can_use_with_other_discount = can_use_with_other_discount;
	}
}
