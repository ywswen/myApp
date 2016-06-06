package com.yyy.project.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yyy.project.servlet.initserver.IToftInitServer;


/**
 *   @类名： ToftCentext
 *   @描述： 需要启动时加载的业务处理类
 *   @作者： 杨文胜
 *   @生成时间： 2013-2-17 上午11:01:45
 *   @修改人： 
 *   @修改时间：  
 **/
@SuppressWarnings("serial")
public class ToftContext extends HttpServlet{
	
	private final static Logger log = Logger.getLogger(ToftContext.class);
	
	private ApplicationContext appctx = null;
	
	private List<IToftInitServer> listServer = new ArrayList<IToftInitServer>();
	
	public void destroy() {
		appctx = null;
		int listS = listServer.size();
		for(int i=0; i<listS; i++){
			listServer.get(i).destroy();
		}
	}
	
	public void init(ServletConfig config) throws ServletException {
		log.info("初始化服务启动开始。。。");
		appctx = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		String serversInit = config.getInitParameter("serversInit");
		if(null != serversInit && !"".equals(serversInit.trim())){
			String[] serversInits = serversInit.split("\\,");
			int servsersInitsLen = serversInits.length;
			for(int i=0; i<servsersInitsLen; i++){
				String serverx = serversInits[i].trim();
				log.info("执行初始化服务【" + serverx + "】开始。。。");
				boolean retEx = true;
				try{
					IToftInitServer iserver = ((IToftInitServer)Class.forName(serverx).newInstance());
					retEx = iserver.execute(appctx);
					listServer.add(iserver);
				}catch(Exception nfex){
					log.error("服务【" + serverx + "】执行异常，请查找原因并处理后重新启动！", nfex);
					retEx = false;
				}
				if(true == retEx)
					log.info("执行初始化服务【" + serverx + "】结束，初始化结果【成功】。");
				else
					log.info("执行初始化服务【" + serverx + "】结束，初始化结果【失败】。");
			}
		}
		log.info("初始化服务启动结束。");
	}
}
