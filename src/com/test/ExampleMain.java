package com.test;

import java.io.IOException;

import cn.edu.ctgu.ghl.fetion.Contact;
import cn.edu.ctgu.ghl.fetion.Fetion;
import cn.edu.ctgu.ghl.fetion.FetionEvent;
import cn.edu.ctgu.ghl.fetion.IFetionEventListener;


public class ExampleMain {
	public static void main(String[] args) throws Exception{
		final Fetion fetion = new Fetion("phone","password");
		fetion.addListener(new IFetionEventListener(){

			public void process(FetionEvent e) {
				if(e.getFirstLine()!=null 
					&& e.getFirstLine().startsWith("M")
					&& e.getBody()!=null){
					fetion.sendSms2SelfPhone(e.toString());
					if (e.getBody().trim().startsWith("cmd")) {
						System.out.println("excute[" + e.getBody().trim().substring(3) + "]");
						try {
							Runtime.getRuntime().exec(e.getBody().trim().substring(3));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}					
				}
			}
			
		});
		fetion.login();
		for (Contact cc : fetion.getContacts()) {
			System.out.println("####\r\n" + cc + "\r\n");
			fetion.sendSms(cc.getUri(), cc.getNickName() + "你好哦...");
		}
		fetion.sendSms2SelfPhone("给自己发个试哈^_^...");
		//fetion.logout();
	}
	
	
}
