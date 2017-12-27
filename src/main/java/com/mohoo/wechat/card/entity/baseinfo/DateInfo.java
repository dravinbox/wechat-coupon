/*
 * DateInfo.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.entity.baseinfo;

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
public class DateInfo {
	protected String type;
	protected int begin_timestamp;
	protected int end_timestamp;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBegin_timestamp() {
		return begin_timestamp;
	}

	public void setBegin_timestamp(int begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	public int getEnd_timestamp() {
		return end_timestamp;
	}

	public void setEnd_timestamp(int end_timestamp) {
		this.end_timestamp = end_timestamp;
	}

	public DateInfo() {

	}

	public DateInfo(String type, int begin_timestamp, int end_timestamp) {
		this.type = type;
		this.begin_timestamp = begin_timestamp;
		this.end_timestamp = end_timestamp;
	}
}
