package com.yyy.projectcode.cetc.xxcj.csv;

import java.io.File;

import org.junit.Test;

import com.csvreader.CsvReader;
import com.yyy.util.GetCSVReader;

public class OpenCvsTest {
	private static final String filePath = "D:\\123.csv";
	/**
	 *   @生成时间： Aug 5, 2014 10:19:22 AM
	 *   @方法说明： 测试读取csv文件内容
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@Test
	public void testCsvContent(){
		File file = new File(filePath);
		try {
			CsvReader cr = GetCSVReader.getCSVReader(file);
//			cr.readNext();
////			cr.readHeaders();
////			String[] headers = cr.getHeaders();
////			//读取cvs的第一列，解析为数据库的列字段
////			for(String aa : headers){
////				System.out.println(aa);
////			}
			cr.readHeaders();
			String[] records = cr.getHeaders();
			//读取cvs的第一列，解析为数据库的列字段
			for(String aa : records){
				System.out.println(aa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
