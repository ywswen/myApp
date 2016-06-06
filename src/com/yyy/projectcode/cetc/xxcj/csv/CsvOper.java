package com.yyy.projectcode.cetc.xxcj.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.junit.Test;

/**
 *   @类名： CsvOper
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： Jul 30, 2014 11:14:37 AM
 *   @修改人：
 *   @修改时间：  
 **/
public class CsvOper {
	private static final String filePath = "D:\\北京八月出口.csv";
	/**
	 *   @生成时间： Jul 30, 2014 11:14:39 AM
	 *   @方法说明： 
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@Test
	public void analysisCvs(){
		File file = new File(filePath);
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(new FileInputStream(file), "UTF-16LE");
			BufferedReader br = new BufferedReader(isr);
			
			//读取cvs的第一列，解析为数据库的列字段
			String head = br.readLine();
			System.out.println(head);
			StringTokenizer st = new StringTokenizer(head, ",");
			while(st.hasMoreTokens()){
				System.out.println(st.nextToken().replace("\"", ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
