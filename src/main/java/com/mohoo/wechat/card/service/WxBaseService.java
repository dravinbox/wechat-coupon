/*
 * WxService.java
 * 版权所有：南京摩虎网络科技有限公司 2010 - 2020
 * 南京摩虎网络科技有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.mohoo.wechat.card.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.mohoo.wechat.card.config.BaseConfig;
import com.mohoo.wechat.card.util.OkHttpUtil;
import com.mohoo.wechat.card.util.PropertiesUtil;

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
public class WxBaseService {
	protected static final Logger logger = LoggerFactory
			.getLogger(WxBaseService.class);

	protected BaseConfig baseConfig;

	protected static final int expiredTime = 7200;
	protected static final long sleepTime = 1000;
	// token有效时间2小时

	public WxBaseService(){}
	public WxBaseService(BaseConfig bc){
		this.baseConfig = bc;
	}
	
	public BaseConfig getBaseConfig() {
		return baseConfig;
	}

	public void setBaseConfig(BaseConfig baseConfig) {
		this.baseConfig = baseConfig;
	}

	/**
	 * 获取access_token 方法描述
	 * 
	 * @param flag
	 * @return
	 */
	public String getAccessToken() {
		return getAccessToken(false);
	}

	/**
	 * 获取access_token 方法描述
	 * 
	 * @param flag
	 * @return
	 */
	public String getAccessToken(boolean flag) {
		if (flag) {
			baseConfig.expireAccessToken();
		}
		if (baseConfig.isAccessTokenExpired()) {
			synchronized (baseConfig.globalAccessTokenRefreshLock) {
				if (baseConfig.isAccessTokenExpired()) {
					while (true) {
						String accessToken = "";
						if (baseConfig.isGetToken()) {
							try {
								accessToken = findAccessToken2();
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {
							try {
								accessToken = findAccessToken2();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (StringUtils.isNotEmpty(accessToken)) {
							baseConfig.updateAccessToken(accessToken,
									expiredTime);
							logger.info("==========accessToken:" + accessToken);
							break;
						}
						try {
							Thread.sleep(sleepTime);
							logger.info("==========token result is baded,after sleep one second,refresh token!");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return baseConfig.getAccessToken();
	}

	/**
	 * 调用接口获取参数 方法描述
	 * 
	 * @return
	 * @throws IOException
	 */
	protected String findAccessToken() throws IOException {
		String jsonMap = OkHttpUtil.doGetHttpRequest(baseConfig.getAccessTokenUrl());
		if (StringUtils.isNotEmpty(jsonMap)) {
			Map<String, Object> resultMap = JSONObject.parseObject(jsonMap);
			if (resultMap.get("status") != null
					&& StringUtils.isNotEmpty(resultMap.get("status")
							.toString())
					&& StringUtils.equals(resultMap.get("status").toString(),
							"200") && resultMap.get("data") != null) {
				return resultMap.get("data").toString();
			}
		}
		return null;
	}

	/**
	 * 调用接口获取参数 方法描述
	 * 
	 * @return
	 * @throws IOException
	 */
	protected String findAccessToken2() throws IOException {
		String jsonMap = OkHttpUtil.doGetHttpRequest(PropertiesUtil
				.getPropertyPath("weixin.get_access_token").concat("&appid=")
				.concat(baseConfig.getAppid()).concat("&secret=")
				.concat(baseConfig.getSecret()));
		if (StringUtils.isNotEmpty(jsonMap)) {
			Map<String, Object> resultMap = JSONObject.parseObject(jsonMap);
			if (resultMap.get("access_token") != null
					&& StringUtils.isNotEmpty(resultMap.get("access_token")
							.toString())) {
				return resultMap.get("access_token").toString();
			}
		}
		return null;
	}

	/**
	 * 请求接口补全参数access_token 方法描述
	 * 
	 * @param url
	 * @return
	 */
	protected String getRealyUrl(String url) {
		if (StringUtils.isNotEmpty(url)) {
			if (url.indexOf("access_token=") != -1) {
				throw new IllegalArgumentException("uri参数中不允许有access_token: "
						+ url);
			}
			String accessToken = getAccessToken(false);
			url += url.indexOf('?') == -1 ? "?access_token=" + accessToken
					: "&access_token=" + accessToken;
		}
		return url;
	}

	/**
	 * 普通get请求方法 方法描述
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	protected Map<String, Object> excuteGet(String url) throws IOException {
		String info = OkHttpUtil.doGetHttpRequest(getRealyUrl(url));
		Map<String, Object> resultMap = JSONObject.parseObject(info);
		if (resultMap.get("errcode") != null) {
			String errcode = resultMap.get("errcode").toString();
			if (StringUtils.equals(errcode, "42001")
					|| StringUtils.equals(errcode, "40001")) {
				baseConfig.expireAccessToken();
				return excuteGet(url);
			}
		}
		return resultMap;
	}

	/**
	 * 普通post请求方法 方法描述
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws IOException
	 */
	protected Map<String, Object> excutePost(String url, String data)
			throws IOException {
		String info = OkHttpUtil.doPostHttpRequest(getRealyUrl(url), data);
		Map<String, Object> resultMap = JSONObject.parseObject(info);
		if (resultMap.get("errcode") != null) {
			String errcode = resultMap.get("errcode").toString();
			if (StringUtils.equals(errcode, "42001")
					|| StringUtils.equals(errcode, "40001")) {
				baseConfig.expireAccessToken();
				return excutePost(url, data);
			}
		}
		return resultMap;
	}

	/**
	 * 调用接口，上传文件 方法描述
	 * 
	 * @param url
	 * @param file
	 * @return
	 * @throws IOException
	 */
	protected Map<String, Object> excutePostFile(String url, File file)
			throws IOException {
		String info = OkHttpUtil.doPostImgHttpRequest(getRealyUrl(url), file);
		Map<String, Object> resultMap = JSONObject.parseObject(info);
		if (resultMap.get("errcode") != null) {
			String errcode = resultMap.get("errcode").toString();
			if (StringUtils.equals(errcode, "42001")
					|| StringUtils.equals(errcode, "40001")) {
				baseConfig.expireAccessToken();
				return excutePostFile(url, file);
			}
		}
		return resultMap;
	}
}
