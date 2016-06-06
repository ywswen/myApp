package com.yyy.util;

import java.io.BufferedWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FileWriter {
	/**
	 * @属性说明：换行符
	 **/
	private static final String NEXT_LINE = System.getProperty("line.separator");
	private static final Logger log = Logger.getLogger(FileWriter.class);
	public static void write(String str, String filePath){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new java.io.FileWriter(filePath, true));
			bw.write(str);
			bw.write(NEXT_LINE);
			bw.flush();
		} catch (IOException e) {
			log.error("写入文件失败",e);
		} finally{
			if(null != bw)
				try {
					bw.close();
				} catch (IOException e) {
					log.error("关闭文件失败！", e);
				}
		}
	}
}
