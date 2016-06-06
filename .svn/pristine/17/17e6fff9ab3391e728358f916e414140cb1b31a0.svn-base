package com.yyy.projectcode.cetc.xxcj.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.csvreader.CsvReader;
import com.yyy.projectcode.cetc.xxcj.filecharset.GetFileCharset;

/**
 *   @类名： JavaCsvTest
 *   @描述： 参数csv的运行
 *   @作者： 杨文胜
 *   @生成时间： Aug 5, 2014 10:19:24 AM
 *   @修改人：
 *   @修改时间：  
 **/
public class JavaCsvTest {
	private static final String filePath = "D:\\1.csv";
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
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(new FileInputStream(file), GetFileCharset.getFilecharset(file));
			BufferedReader br = new BufferedReader(isr);
			
			CsvReader cr = new CsvReader(br);
			cr.readHeaders();
			String[] headers = cr.getHeaders();
			//读取cvs的第一列，解析为数据库的列字段
			for(String aa : headers){
				System.out.println(aa);
			}
			cr.readRecord();
			String[] records = cr.getValues();
			//读取cvs的第一列，解析为数据库的列字段
			for(String aa : records){
				System.out.println(aa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
