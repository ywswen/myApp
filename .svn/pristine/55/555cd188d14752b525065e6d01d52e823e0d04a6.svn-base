package com.test.readxml;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 *   @类名： ReadXml
 *   @描述： 读取xml文件，用于导出xml文件，使用outputstream
 *   @作者： 杨文胜
 *   @生成时间： 2014-6-3 下午03:43:50
 *   @修改人：
 *   @修改时间：  
 **/
public class ReadXml {
	String filePath = "C:\\temp\\export\\201405301651214358D4B86F.xml";
	@Test
	public void testRead(){
		//创建输入流，并设置头文件
		try {
			SAXReader saxReader = new SAXReader();
			BufferedInputStream bufferInputStream = new BufferedInputStream(new FileInputStream(filePath));
			Document doc = saxReader.read(bufferInputStream);
			System.out.println(doc.asXML());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**输出文件  ，jsp调用方式为
	 * @param filePath
	 * @param response
	 * @throws IOException
	 * @author   杨文胜
	 * @version  2014-5-14 下午04:09:01
	 * @since    JDK 1.5
	 */
	public static void outputXmlFile(String fileName, String filePath, boolean ifDelete, HttpServletResponse response) throws IOException
	{
		File file = new File(filePath);			//创建文件
		
		if (file.exists() && file.canRead()) {	//如果文件不存在
			
			//创建输入流，并设置头文件
			BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file));
			response.reset();//ZBY 20130730 处理正式下载乱码  这句话非常重要！！！
//			response.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("GBK");
			response.setContentType("application/octet-stream");
			response.setHeader ("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
			response.setContentLength((int)file.length());
			
			OutputStream outputStream = response.getOutputStream();
		    byte[] buffer = new byte[1024];
		    int i = -1;
		    while ((i = fileInputStream.read(buffer)) != -1) {
		     outputStream.write(buffer, 0, i);
		    }
		  
		    outputStream.flush();
		    outputStream.close();

			fileInputStream.close();
			if(ifDelete){
				file.delete();
			}
			
		}else{
			System.out.println("导出文件时错误，文件不存在！");
		}
	}
}
