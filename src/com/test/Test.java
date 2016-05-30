package com.test;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class Test {
		
		public static void sendMsg(String _phone,String _pwd,String _to,String _msg) throws HttpException, IOException{
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://3.ibtf.sinaapp.com/f.php");
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
			NameValuePair[] data ={ 
					new NameValuePair("phone", _phone),
					new NameValuePair("pwd", _pwd),
					new NameValuePair("to",_to),
					new NameValuePair("msg",_msg),
					new NameValuePair("type","0")
					};
			post.setRequestBody(data);
		
			client.executeMethod(post);
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:"+statusCode);
			for(Header h : headers){
				System.out.println(h.toString());
			}
			//String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
			//System.out.println(result);
			System.out.println("ok!");
			post.releaseConnection();
		}
		public static void main(String[] args) {
			try {
				sendMsg("13810514005","151sa#$AA","13810514005","Testsinaapp");
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
