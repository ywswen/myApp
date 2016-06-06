package com.yyy.design.designModel5.builderfactory.sendmessage;

public class Director {
	private Builder builder;
	public Director(Builder builder) {
		// TODO Auto-generated constructor stub
		this.builder=builder;
	}
	public void construct(String from,String to){
		this.builder.buildTo(to);
		this.builder.buildFrom(from);
//		this.builder.sendMessage(msg);
		this.builder.buildBody();
		this.builder.buildSubject();
		this.builder.buildSendDate();
		this.builder.sendMessage();
		
	}
}
