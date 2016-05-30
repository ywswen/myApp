package com.yyy.design.designModel13.bridge.sendmessage;
/**
 *   @类名： AbstractMessage
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-12-3 上午10:50:30
 *   @修改人：
 *   @修改时间：  
 **/
public class AbstractMessage {
	private MessageImplementor msgImpl;
	public AbstractMessage(MessageImplementor msgImpl) {
		this.msgImpl = msgImpl;
	}
	public void sendMessage(String toUser, String msg){
		this.msgImpl.send(toUser, msg);
	}
}

