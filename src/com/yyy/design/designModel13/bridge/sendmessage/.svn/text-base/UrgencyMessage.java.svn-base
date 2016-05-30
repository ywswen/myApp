package com.yyy.design.designModel13.bridge.sendmessage;
/**
 *   @类名： UrgencyMessage
 *   @描述： 加急消息类
 *   @作者： 杨文胜
 *   @生成时间： 2012-12-3 下午06:10:56
 *   @修改人：
 *   @修改时间：  
 **/
public class UrgencyMessage extends AbstractMessage{

	public UrgencyMessage(MessageImplementor msgImpl) {
		super(msgImpl);
	}
	public void sengMessage(String toUser, String msg){
		super.sendMessage(toUser, msg);
	}
	/**
	 *   @生成时间： 2012-12-3 下午06:14:26
	 *   @方法说明： 扩展自己的新功能，监控某消息的处理状态 
	 *   @参数：msgId
	 *   @返回值： 监控到的消息的处理状态 
	 *   @异常：
	 **/
	public Object watch(String msgId){
		System.out.println("please watch!");
		return null;
	}
}

