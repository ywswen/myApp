package com.yyy.design.designModel13.bridge.sendmessage;
/**
 *   @类名： MessageImplementor
 *   @描述： 实现发送消息的统一接口
 *   @作者： 杨文胜
 *   @生成时间： 2012-12-3 上午10:59:12
 *   @修改人：
 *   @修改时间：  
 **/
public interface MessageImplementor {
	/**
	 *   @生成时间： 2012-12-3 上午11:03:03
	 *   @方法说明： 
	 *   @参数：toUser:消息的接收者，msg：消息内容
	 *   @返回值： 
	 *   @异常：
	 **/
	public void send(String toUser, String msg);
}

