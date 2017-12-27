/*
 * AdvancedInfo.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.absract;

/**
 * 卡劵高级信息 类描述
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
public class AdvancedInfo {
	protected UseCondition use_condition;
	protected String least_cost;
	protected String object_use_for;
	protected Abstract abstract1;// /
	protected TextImage[] text_image_list;
	protected String[] business_service;//
	protected TimeLimit[] time_limit;//

	public UseCondition getUse_condition() {
		return use_condition;
	}

	public void setUse_condition(UseCondition use_condition) {
		this.use_condition = use_condition;
	}

	public String getLeast_cost() {
		return least_cost;
	}

	public void setLeast_cost(String least_cost) {
		this.least_cost = least_cost;
	}

	public String getObject_use_for() {
		return object_use_for;
	}

	public void setObject_use_for(String object_use_for) {
		this.object_use_for = object_use_for;
	}

	public Abstract getAbstract() {
		return abstract1;
	}

	public void setAbstract(Abstract abstract1) {
		this.abstract1 = abstract1;
	}

	public TextImage[] getText_image_list() {
		return text_image_list;
	}

	public void setText_image_list(TextImage[] text_image_list) {
		this.text_image_list = text_image_list;
	}

	public String[] getBusiness_service() {
		return business_service;
	}

	public void setBusiness_service(String[] business_service) {
		this.business_service = business_service;
	}

	public TimeLimit[] getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(TimeLimit[] time_limit) {
		this.time_limit = time_limit;
	}
}
