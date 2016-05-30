package com.yyy.dailycode.webservicecxf.client;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.yyy.dailycode.log.SinoLogger;
import com.yyy.dailycode.webservicecxf.server.ICXFService;
import com.yyy.dailycode.webservicecxf.server.vo.CXFBean;
import com.yyy.dailycode.webservicecxf.util.ReadProperties;

/**
 *  @类名： CXFClientTest
 *  @描述： 
 *  @作者： 杨文胜
 *  @生成时间： 2013-11-13 上午10:36:31
 *  @修改人：
 *  @修改时间：
 */
public class CXFClientTest extends TestCase{
	
	private static SinoLogger _log = SinoLogger.getLogger(CXFClientTest.class);
	private static final String WEBSERVICE_WEBURL = "http://localhost:8080/myApp/";
	private static final String WEBSERVICE_SUFFIX = "webservice_suffix";
	private static final String CONNECTION_TIMEOUT = "connection_timeout";
	private static final String CLIENT_NAME = "client";
	private static final String SERVER_NAME = "server";
	
	private static ICXFService cxfService = null;
	
	static{
		try {
			String address = ReadProperties.getProp(WEBSERVICE_SUFFIX);
			String connectionTimeOut = ReadProperties.getProp(CONNECTION_TIMEOUT);
			JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
			factoryBean.setAddress(WEBSERVICE_WEBURL + address);
			factoryBean.setServiceClass(ICXFService.class);
			Object obj = factoryBean.create();
			Client proxy = ClientProxy.getClient(obj);
			HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
			HTTPClientPolicy policy = new HTTPClientPolicy();
			policy.setConnectionTimeout(Integer.parseInt(connectionTimeOut));
			conduit.setClient(policy);
			cxfService = (ICXFService) obj;
		} catch (Exception e) {
			_log.error("连接webservice失败" + e);
		}
	}
	/**
	 *   @生成时间： 2013-11-13 下午04:07:33
	 *   @方法说明： 测试webservice连接传输字符串
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void testWebServiceString() {
		String serverName = cxfService.getServerName(CLIENT_NAME);
		_log.info("客户端获取的服务器名称:" + serverName);
	}
	/**
	 *   @生成时间： 2013-11-13 下午04:10:18
	 *   @方法说明： 测试map连接,测试结果map不可用
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void testWebServiceMap(){
		Map<String,String> clientInformation = new HashMap<String,String>();
		clientInformation.put(CLIENT_NAME, CLIENT_NAME);
		Map<String,String> serverInformation = cxfService.getServerInformation(clientInformation);
		_log.info("客户端获取的服务器名称:" + serverInformation.get(SERVER_NAME));
	}
	/**
	 *   @生成时间： 2013-11-13 下午05:21:04
	 *   @方法说明： 测试传输bean,bean由map组成
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void testWebServiceBean(){
		CXFBean clientCXFbean = new CXFBean();
		clientCXFbean.setName(CLIENT_NAME);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(CLIENT_NAME, CLIENT_NAME);
		map.put(WEBSERVICE_WEBURL, WEBSERVICE_WEBURL.getBytes());
		map.put(ICXFService.class.getSimpleName(), new CXFBean());
		clientCXFbean.setMap(map);
		CXFBean serverBean = cxfService.getServerBean(clientCXFbean);
		_log.info("服务器返回结果" + serverBean.getName());
		_log.info(serverBean.getMap());
	}
}

