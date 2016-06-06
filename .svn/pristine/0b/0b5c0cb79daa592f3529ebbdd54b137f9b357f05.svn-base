package com.yyy.dailycode.webservicecxf.server.impl;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.yyy.dailycode.log.SinoLogger;
import com.yyy.dailycode.webservicecxf.server.ICXFService;
import com.yyy.dailycode.webservicecxf.server.vo.CXFBean;

/**
 *  @类名： CXFServiceImpl
 *  @描述： 
 *  @作者： 杨文胜
 *  @生成时间： 2013-11-13 上午10:18:07
 *  @修改人：
 *  @修改时间：
 */
public class CXFServiceImpl implements ICXFService{
	private static final SinoLogger _log = SinoLogger.getLogger(CXFServiceImpl.class); 
	private static final String USER_NAME = System.getProperty("user.name");
	private static final String WEBSERVICE_WEBURL = "http://localhost:8080/myApp/";
	private static final String CLIENT_NAME = "client";
	private static final String SERVER_NAME = "server";
	
	/**
	 *   @生成时间： 2013-11-13 上午10:22:30
	 *   @方法说明： 根据客户端名称获取服务器名称
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public String getServerName(String clientName) {
		_log.info("客户端名称为：" + clientName);
		_log.info("服务器端名称为" + USER_NAME);
		return USER_NAME;
	}

	/**
	 *   @生成时间： 2013-11-13 下午04:15:43
	 *   @方法说明： 获取服务器的名称,返回map集合
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public Map <String,String>getServerInformation(Map <String,String>clientInformation) {
		Hashtable <String,String>map = new Hashtable<String,String>();
		String clientName = (String)clientInformation.get(CLIENT_NAME);
		_log.info(clientName);
		map.put(SERVER_NAME, SERVER_NAME);
		return map;
	}

	/**
	 *   @生成时间： 2013-11-13 下午04:39:45
	 *   @方法说明： 测试bean
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public CXFBean getServerBean(CXFBean clientCXFbean) {
		_log.info("客户端发送过来的bean的名字:" + clientCXFbean.getName());
		_log.info("客户端发送过来的bean的map名字:" + clientCXFbean.getMap().get(CLIENT_NAME));
		CXFBean serverBean = new CXFBean();
		serverBean.setName("server");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SERVER_NAME, SERVER_NAME);
		map.put(WEBSERVICE_WEBURL, WEBSERVICE_WEBURL.getBytes());
		map.put(CLIENT_NAME, new CXFBean());
		serverBean.setMap(map);
		return serverBean;
	}
}

