package com.yyy.dailycode.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author win young
 * 
 * @创建时间:2012-10-18 下午04:33:05
 * 
 * @version 1
 * 
 * @类说明：
 */

public class SimpleWebServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socketClient = null;
		int connectCount = 0;
		try {
			serverSocket = new ServerSocket(80, 5);
			while (connectCount < 5) {
				socketClient = serverSocket.accept();
				ServiceClient(socketClient);
				connectCount++;
			}
			serverSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void ServiceClient(Socket client) throws IOException {
		DataInputStream inbound = null;
		DataOutputStream outbound = null;
		try {
			// 得到IO流
			inbound = new DataInputStream(client.getInputStream());
			outbound = new DataOutputStream(client.getOutputStream());
			// 格式化输出(回应头和很少的HTML文档)
			StringBuffer buffer = new StringBuffer("123");//new PrepareOutput();
			String inputLine;
			while ((inputLine = inbound.readLine()) != null) {
				// 如果到了HTTP请求的尾部,就发送回应
				if (inputLine.equals("")) {
					outbound.writeBytes(buffer.toString());
					break;
				}
			}
		} finally {
			// 清除
			System.out.println("Cleaning up connection: " + client);
			outbound.close();
			inbound.close();
			client.close();
			client.close();
		}
	}
}
