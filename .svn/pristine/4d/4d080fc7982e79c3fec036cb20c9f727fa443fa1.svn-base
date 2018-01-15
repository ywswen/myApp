package com.yyy.dailycode.stock.model;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *   @类名： SendMessage
 *   @描述： 发送短信接口
 *   @作者： 杨文胜
 *   @生成时间： 2017-5-2 下午10:13:28
 *   @修改人：
 *   @修改时间：  
 **/
public class SendMessage {
	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
		//123qweASD
		NameValuePair[] data = { new NameValuePair("Uid", "ywswen12"), new NameValuePair("Key", "4cd283533b9b73d491ff"), new NameValuePair("smsMob", "13810514005"),
				new NameValuePair("smsText", "002282,600874") };
		post.setRequestBody(data);

		client.executeMethod(post);
//		Header[] headers = post.getResponseHeaders();
//		int statusCode = post.getStatusCode();
//		System.out.println("statusCode:" + statusCode);
//		for (Header h : headers) {
//			System.out.println(h.toString());
//		}
//		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
//		System.out.println(result); // 打印返回消息状态
		post.releaseConnection();
	}
}
