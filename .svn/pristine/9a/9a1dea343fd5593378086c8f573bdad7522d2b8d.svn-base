package com.yyy.dailycode.enjoycoding.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.Test;

import au.com.bytecode.opencsv.CSVWriter;

public class CreateCsv {
	
	/**
	 * @属性说明：目的路径
	 **/
	private static final String DESTINATIONPATH = "d:\\csvsource\\test.csv";
	/**
	 *   @生成时间： 2014-8-2 上午11:43:18
	 *   @方法说明： 创建测试数据文件，经过测试闯将10万条数据用时702毫秒
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
//	@Test
	public void testCreateTestFile(){
		try {
			long startTime = System.currentTimeMillis();
			OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(new File(DESTINATIONPATH)),"gbk");
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<100000;i++){
				String count = String.format("%06d", i);
				String msg = "姓名" + count + ",地址" + count + ",邮箱" + count + "\r\n";
				bw.write(msg);
			}
			bw.close();
			fw.close();
			long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 *   @生成时间： 2014-8-2 上午11:43:18
	 *   @方法说明： 通过csv提供的方法创建测试数据文件,经过测试闯将10万条数据用时905毫秒
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@Test
	public void testCreateTestFileByCsvWriter(){
		try {
			long startTime = System.currentTimeMillis();
			OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(new File(DESTINATIONPATH)),"gbk");
			BufferedWriter bw = new BufferedWriter(fw);
			CSVWriter cw = new CSVWriter(bw);
			for(int i=0;i<10000000;i++){
				String count = String.format("%06d", i);
//				String msg = "姓名" + count + ",地址" + count + ",邮箱" + count + "\r\n";
				String[] as = new String[]{"姓名\"," + count, "地址," + count,"邮箱" + count}; 
				cw.writeNext(as);
			}
			cw.close();
			bw.close();
			fw.close();
			long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
