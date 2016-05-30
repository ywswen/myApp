package com.yyy.design.designModel5.builderfactory.sendmessage;

import java.util.Date;

public abstract class Builder {
	protected AutoMessage msg;
	public void buildTo(String to) {
		msg.setTo(to);
	}
	public void buildFrom(String from){
		msg.setFrom(from);
	};
	public abstract void buildBody();
	public abstract void buildSubject();
	public void buildSendDate(){
		msg.setSendDate(new Date());
	};
	public void sendMessage(){
		msg.send();
	};
}
