package com.yyy.util;

import java.io.IOException;

import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;


/**
 *   @类名： NetUtil
 *   @描述： 测试地址和端口是否连通
 *   @作者： 吴建华
 *   @生成时间： 2012-2-15 下午02:03:31
 *   @修改人： 
 *   @修改时间：  
 **/
public class NetUtil {
	class Node{
		String ip;
		String port;
		Node(String ip, String port){
			this.ip = ip;
			this.port = port;
		}
		String getIp(){
			return ip;
		}
		String getPort(){
			return port;
		}
	}
	private static Logger _log = Logger.getLogger(NetUtil.class);
	
	public static boolean isConnect(String ip, int port){
		TelnetClient client = new TelnetClient();
		boolean isconn = false;
		try{
			client.connect(ip, port);
			isconn = client.isConnected();
		}catch(Exception ex){
			_log.error("连通测试【" + ip + "】节点时失败!");
			isconn = false;
		}finally{
			try {
				if(true == isconn)
					client.disconnect();
			} catch (IOException e) {
				_log.error("关闭测试【" + ip + "】节点时失败!");
			}
		}
		return isconn;
	}
	private static Node Node(String ipPrefix, String port) {
		return NetUtil.Node(ipPrefix,port);
	}
	public static void main(String[] args) {
		String ipPrefix = "10.25.104.";
		for(int i = 110; i<155;i++){
			String ip = ipPrefix + i;
			boolean a = isConnect(ip,1433);
			if(a){
				System.out.println("telent 成功的ip为【"+ ip +"】");
			}
		}
	}
}
