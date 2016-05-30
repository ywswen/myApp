package com.yyy.design.designModel13.bridge.sendmessage;

import junit.framework.TestCase;

/**
 *   @类名： ClientTest
 *   @描述： 客户端类
 *   @作者： 杨文胜
 *   @生成时间： 2012-12-3 下午06:17:38
 *   @修改人：
 *   @修改时间：  
 **/
public class ClientTest extends TestCase{
	/**
	 *   @生成时间： 2012-12-3 下午06:23:43
	 *   @方法说明： 桥接模式测试方法
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void testBriadge(){
		MessageImplementor msgImpl = new  SendSMS();
		AbstractMessage message = new CommonMessage(msgImpl);
		message.sendMessage("win yong", "加速审批");
		msgImpl = new SendEmail();
		message = new UrgencyMessage(msgImpl); 
		message.sendMessage("杨总", "加速申请审批");
	}
}

