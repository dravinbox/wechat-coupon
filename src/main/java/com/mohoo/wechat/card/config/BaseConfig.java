/*
 * BaseConfig.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.config;

/**
 * 类描述
 * <p>
 * 创建日期：2016年6月30日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author Administrator
 * @version 1.0
 */
public class BaseConfig {
	protected volatile String accessToken;

	protected volatile long accessTokenExpiresTime;

	protected volatile String wxCardTicket;
	protected volatile long wxCardTicketExpiresTime;
	
	protected volatile String appid;
	protected volatile String secret;
	
	protected volatile String accessTokenUrl;
	
	protected volatile boolean isGetToken=false;
	
	public final Object globalAccessTokenRefreshLock = new Object();
	
	public final Object globalWxCardTicketRefreshLock = new Object();

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getAccessTokenExpiresTime() {
		return accessTokenExpiresTime;
	}

	public void setAccessTokenExpiresTime(long accessTokenExpiresTime) {
		this.accessTokenExpiresTime = accessTokenExpiresTime;
	}

	public String getWxCardTicket() {
		return wxCardTicket;
	}

	public void setWxCardTicket(String wxCardTicket) {
		this.wxCardTicket = wxCardTicket;
	}

	public long getWxCardTicketExpiresTime() {
		return wxCardTicketExpiresTime;
	}

	public void setWxCardTicketExpiresTime(long wxCardTicketExpiresTime) {
		this.wxCardTicketExpiresTime = wxCardTicketExpiresTime;
	}

	public boolean isWxCardTicketExpired() {
		return System.currentTimeMillis() > this.wxCardTicketExpiresTime;
	}

	public boolean isAccessTokenExpired() {
		return System.currentTimeMillis() > this.accessTokenExpiresTime;
	}

	public synchronized void updateWxCardTicket(String wxCardTicket,
			int expiresInSeconds) {
		this.wxCardTicket = wxCardTicket;
		// 预留200秒的时间
		this.wxCardTicketExpiresTime = System.currentTimeMillis()
				+ (expiresInSeconds - 200) * 1000l;
	}

	public synchronized void updateAccessToken(String accessToken,
			int expiresInSeconds) {
		this.accessToken = accessToken;
		// 预留200秒的时间
		this.accessTokenExpiresTime = System.currentTimeMillis()
				+ (expiresInSeconds - 200) * 1000l;
	}

	public void expireAccessToken() {
		this.accessTokenExpiresTime = 0;
	}

	public void expireWxCardTicket() {
		this.wxCardTicketExpiresTime = 0;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAccessTokenUrl() {
		return accessTokenUrl;
	}

	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl=accessTokenUrl;
//		if(appid==null||secret==null){
//			return ;
//		} else{
//			this.accessTokenUrl = accessTokenUrl+"&appid="+appid+"&secret="+secret;
//		}
	}

	public boolean isGetToken() {
		return isGetToken;
	}

	public void setGetToken(boolean isGetToken) {
		this.isGetToken = isGetToken;
	}

	@Override
	public String toString() {
		return "BaseConfig [accessToken=" + accessToken + ", accessTokenExpiresTime=" + accessTokenExpiresTime
				+ ", wxCardTicket=" + wxCardTicket + ", wxCardTicketExpiresTime=" + wxCardTicketExpiresTime + ", appid="
				+ appid + ", secret=" + secret + ", accessTokenUrl=" + accessTokenUrl + ", isGetToken=" + isGetToken
				+ ", globalAccessTokenRefreshLock=" + globalAccessTokenRefreshLock + ", globalWxCardTicketRefreshLock="
				+ globalWxCardTicketRefreshLock + "]";
	}
	
}
