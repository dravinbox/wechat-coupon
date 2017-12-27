/*
 * BaseInfo.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.baseinfo;

import java.util.Map;

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
public class BaseInfo {
	public static String COLOR010 = "Color010";
	public static String COLOR020 = "Color020";
	public static String COLOR030 = "Color030";
	public static String COLOR040 = "Color040";
	public static String COLOR050 = "Color050";
	public static String COLOR060 = "Color060";
	public static String COLOR070 = "Color070";
	public static String COLOR080 = "Color080";
	public static String COLOR090 = "Color090";
	public static String COLOR100 = "Color100";
	public static String COLOR101 = "Color101";
	public static String COLOR102 = "Color102";

	/**
	 * 必填字段
	 */
	protected String logo_url;
	protected String code_type;
	protected String brand_name;
	protected String title;
	protected String sub_title;
	protected String color;
	protected String notice;
	protected String description;
	protected Map<String, Object> sku;
	protected DateInfo date_info;
	// protected int fixed_term;
	// protected int fixed_begin_term;

	/**
	 * 非必填字段
	 */
	protected boolean use_custom_code;
	protected boolean bind_openid;
	protected String service_phone;
	protected int[] location_id_list;
	protected String source;
	protected String center_title;
	protected String center_sub_title;
	protected String center_url;
	protected String custom_url_name;
	protected String custom_url;
	protected String custom_url_sub_title;
	protected String promotion_url_name;
	protected String promotion_url;
	protected String promotion_url_sub_title;
	protected int get_limit = 50;
	protected boolean can_share;
	protected boolean can_give_friend;

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Object> getSku() {
		return sku;
	}

	public void setSku(Map<String, Object> sku) {
		this.sku = sku;
	}

	public DateInfo getDate_info() {
		return date_info;
	}

	public void setDate_info(DateInfo date_info) {
		this.date_info = date_info;
	}

	// public int getFixed_term() {
	// return fixed_term;
	// }
	// public void setFixed_term(int fixed_term) {
	// this.fixed_term = fixed_term;
	// }
	// public int getFixed_begin_term() {
	// return fixed_begin_term;
	// }
	// public void setFixed_begin_term(int fixed_begin_term) {
	// this.fixed_begin_term = fixed_begin_term;
	// }
	public boolean isUse_custom_code() {
		return use_custom_code;
	}

	public void setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}

	public boolean isBind_openid() {
		return bind_openid;
	}

	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}

	public String getService_phone() {
		return service_phone;
	}

	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}

	public int[] getLocation_id_list() {
		return location_id_list;
	}

	public void setLocation_id_list(int[] location_id_list) {
		this.location_id_list = location_id_list;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCustom_url_name() {
		return custom_url_name;
	}

	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}

	public String getCenter_title() {
		return center_title;
	}

	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}

	public String getCenter_sub_title() {
		return center_sub_title;
	}

	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}

	public String getCenter_url() {
		return center_url;
	}

	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}

	public String getCustom_url() {
		return custom_url;
	}

	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}

	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}

	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}

	public String getPromotion_url_name() {
		return promotion_url_name;
	}

	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}

	public String getPromotion_url() {
		return promotion_url;
	}

	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}

	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}

	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}

	public int getGet_limit() {
		return get_limit;
	}

	public void setGet_limit(int get_limit) {
		this.get_limit = get_limit;
	}

	public boolean isCan_share() {
		return can_share;
	}

	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
	}

	public boolean isCan_give_friend() {
		return can_give_friend;
	}

	public void setCan_give_friend(boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}
}
