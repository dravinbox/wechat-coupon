/*
 * TimeLimit.java
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
public class TimeLimit {
	protected String type;
	protected int begin_hour;
	protected int begin_minute;
	protected int end_hour;
	protected int end_minute;

	public TimeLimit() {
	}

	public TimeLimit(String type, int begin_hour, int begin_minute,
			int end_hour, int end_minute) {
		this.type = type;
		this.begin_hour = begin_hour;
		this.begin_minute = begin_minute;
		this.end_hour = end_hour;
		this.end_minute = end_minute;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBegin_hour() {
		return begin_hour;
	}

	public void setBegin_hour(int begin_hour) {
		this.begin_hour = begin_hour;
	}

	public int getBegin_minute() {
		return begin_minute;
	}

	public void setBegin_minute(int begin_minute) {
		this.begin_minute = begin_minute;
	}

	public int getEnd_hour() {
		return end_hour;
	}

	public void setEnd_hour(int end_hour) {
		this.end_hour = end_hour;
	}

	public int getEnd_minute() {
		return end_minute;
	}

	public void setEnd_minute(int end_minute) {
		this.end_minute = end_minute;
	}

}
