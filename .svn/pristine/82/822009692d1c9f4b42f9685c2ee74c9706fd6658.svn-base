package com.yyy.dailycode.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author win young
 * 
 * @创建时间:2012-10-18 下午02:58:14
 * 
 * @version 1
 * 
 * @类说明：
 */

public class SimpleWebClient {
	public static void main(String[] args) throws Exception, IOException {
		Socket clientSocket = new Socket("127.0.0.1",80);
		System.out.println("clientSocket" +clientSocket);
		getPage(clientSocket);
	}
	@SuppressWarnings("deprecation")
	public static void getPage(Socket clientSocket) throws Exception{
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		out.writeBytes("GET /HHTP/1.0\r\n\r\n");
		String responseLine;
		while((responseLine=in.readLine())!=null){
			System.out.println(responseLine);
			if(responseLine.indexOf("")==1){
				break;
			}
		}
		out.close();
		in.close();
		clientSocket.close();
	}
}
