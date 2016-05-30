package com.yyy.design.designModel5.builderfactory.sendmessage;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AutoMessage {
	//收件人地址
	private String to;
	//发件人地址
	private String from;
	//主题
	private String subject;
	//内容
	private String body;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	//发送日期
	private Date sendDate;
	public void send(){
		System.out.println("发件人地址："+from);
		System.out.println("收件人地址："+to);
		System.out.println("主               题："+subject);
		System.out.println("内               容："+body);
		System.out.println("发 送   时 间："+sf.format(sendDate));
	}
}
