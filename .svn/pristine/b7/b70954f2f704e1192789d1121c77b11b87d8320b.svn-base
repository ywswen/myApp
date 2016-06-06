package com.yyy.dailycode.callcmd;

import java.io.File;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 *   @类名： CallBatFile
 *   @描述： 调用bat命令
 *   @作者： 杨文胜
 *   @生成时间： 2014-4-15 下午06:11:13
 *   @修改人：
 *   @修改时间：  
 **/
public class CallBatFile {
	private static final Logger log = Logger.getLogger(CallBatFile.class);
	private static final String WINDOWD_CMD = "cmd /c start ";
	/**
	 *   @生成时间： 2014-4-15 下午06:11:24
	 *   @方法说明：调用bat命令 
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void callBatFile(String resourcePath){
		
		File file = new File(resourcePath);
		if(!file.exists()){
			log.error("文件不存在！");
			return ;
		}
		resourcePath = WINDOWD_CMD + resourcePath; 
		Process ps;
		try {
			ps = Runtime.getRuntime().exec(resourcePath);
			InputStream in = ps.getInputStream();
			int c;
			while((c = in.read() )!= -1){
				log.debug("执行命令行" + c);
			}
			in.close();
			ps.waitFor();
		} catch (Exception e) {
			log.error("执行命令失败");
		}
	}
	@Test
	public void testCallBatFile(){
		String resourcePath = "c:\\a.bat";
		callBatFile(resourcePath);
	}
}
