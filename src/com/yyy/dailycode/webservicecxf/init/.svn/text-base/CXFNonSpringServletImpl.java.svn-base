package com.yyy.dailycode.webservicecxf.init;
import javax.servlet.ServletConfig;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.apache.log4j.Logger;

import com.yyy.dailycode.webservicecxf.server.impl.CXFServiceImpl;
import com.yyy.dailycode.webservicecxf.util.ReadProperties;
/**
 * @类名： CXFNonSpringServletImpl
 * @描述：内容管理的初始化服务（仅Tomcat发布WebService时用）
 * @作者： 杨文胜
 * @生成时间： 2013-9-10 下午04:44:17
 * @修改人：
 * @修改时间：
 */
public class CXFNonSpringServletImpl extends CXFNonSpringServlet{
	
	private static final long serialVersionUID = 1L;
	private static final Logger _log = Logger.getLogger(CXFNonSpringServletImpl.class);
	private static String suffix = ReadProperties.getProp("webservice_suffix").substring(3);
	private static String compressSign = ReadProperties.getProp("webservice_compress_sign");
	
	/**
	 *   @生成时间： 2013-11-13 下午05:22:53
	 *   @方法说明： 入口
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void loadBus(ServletConfig servletConfig) {
		_log.debug("执行 loadBus...");
		try {
			super.loadBus(servletConfig);
			initCxfWebService();
		} catch (Exception e) {
			_log.error("WebService启动异常！", e);
		}
	}
	
	/**
	 * @生成时间： 2013-9-10 下午09:46:59
	 * @方法说明： 初始化WebService
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	private void initCxfWebService() throws Exception {
		try {
			_log.debug("WebService初始化...");
			Bus bus = getBus();
			BusFactory.setDefaultBus(bus);
			JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
			factoryBean.setServiceClass(CXFServiceImpl.class);
			factoryBean.setAddress(suffix);
			if ("on".equals(compressSign)) {
				factoryBean.getInInterceptors().add(new GZIPInInterceptor());
				factoryBean.getOutInterceptors().add(new GZIPOutInterceptor());
			}
			Server server = factoryBean.create();
			server.getDestination();
			factoryBean.create();
			_log.info("WebService初始化结束！");
		} catch (Exception e) {
			throw e;
		}
	}
}
