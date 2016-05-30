package com.yyy.dailycode.webservicecxf.server;

import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.yyy.dailycode.webservicecxf.server.vo.CXFBean;

/**
 *  @类名： ICXFService
 *  @描述： 
 *  @作者： 杨文胜
 *  @生成时间： 2013-11-13 上午10:14:08
 *  @修改人：
 *  @修改时间：
 */
@WebService
public interface ICXFService {
	@WebMethod
	@WebResult
	public String getServerName(@WebParam String clientName);
	@WebMethod
	@WebResult
	public Map<String,String> getServerInformation(@WebParam Map<String,String> clientInformation);
	@WebMethod
	@WebResult
	public CXFBean getServerBean(@WebParam CXFBean clientCXFbean);
}

