package com.yyy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.csvreader.CsvReader;
import com.yyy.projectcode.cetc.xxcj.filecharset.GetFileCharset;

/**
 *   @类名： GetCSVReader
 *   @描述： 根据第一行分隔符获取CSV文件的初始化CsvReader，例如第一行含有\t则使用\t分隔符，否则的话使用默认的分隔符
 *   @作者： 杨文胜
 *   @生成时间： Aug 5, 2014 12:21:39 PM
 *   @修改人：
 *   @修改时间：  
 **/
public class GetCSVReader {
	/**
	 *   @生成时间： Aug 5, 2014 2:07:15 PM
	 *   @方法说明： 根据文件获取CsvReader
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static CsvReader getCSVReader(File file){
		CsvReader cr = null;
		InputStreamReader isr;
		BufferedReader brFirstLine = null;
		try {
			String filecharset = GetFileCharset.getFilecharset(file);
			isr= new InputStreamReader(new FileInputStream(file), filecharset);
			brFirstLine = new BufferedReader(isr);
			String line = brFirstLine.readLine();
			isr = new InputStreamReader(new FileInputStream(file), filecharset);
			brFirstLine = new BufferedReader(isr);
			if(line.contains("\t")){
				cr = new CsvReader(brFirstLine,'\t');
			}else{
				cr = new CsvReader(brFirstLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cr;
	}
}
