package com.yyy.design.designModel5.builderfactory.sendmessage;

public class GoodbyeBuilder extends Builder{
	public GoodbyeBuilder() {
		// TODO Auto-generated constructor stub
		msg=new GoodbyeMessage();
	}
	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		msg.setBody("欢送内容");
	}

	@Override
	public void buildSubject() {
		// TODO Auto-generated method stub
		msg.setSubject("欢送主题");
	}

}
