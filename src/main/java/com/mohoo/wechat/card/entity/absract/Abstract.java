/*
 * Abstract.java
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
public class Abstract {
	protected String abstract1;
	protected String[] icon_url_list;

	public String getAbstract() {
		return abstract1;
	}

	public void setAbstract(String abstract1) {
		this.abstract1 = abstract1;
	}

	public String[] getIcon_url_list() {
		return icon_url_list;
	}

	public void setIcon_url_list(String[] icon_url_list) {
		this.icon_url_list = icon_url_list;
	}

	public Abstract() {
	}

	public Abstract(String abstract1, String[] icon_url_list) {
		this.abstract1 = abstract1;
		this.icon_url_list = icon_url_list;
	}
}
