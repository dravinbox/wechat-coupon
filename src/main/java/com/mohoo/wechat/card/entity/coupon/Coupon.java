/*
 * Coupon.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.coupon;

import com.mohoo.wechat.card.entity.absract.AdvancedInfo;
import com.mohoo.wechat.card.entity.baseinfo.BaseInfo;

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
public class Coupon {
	protected BaseInfo base_info;
	protected AdvancedInfo advanced_info;

	public AdvancedInfo getAdvanced_info() {
		return advanced_info;
	}

	public void setAdvanced_info(AdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}

	public BaseInfo getBase_info() {
		return base_info;
	}

	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

}
