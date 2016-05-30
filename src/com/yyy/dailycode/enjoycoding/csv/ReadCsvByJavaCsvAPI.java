package com.yyy.dailycode.enjoycoding.csv;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;

import com.csvreader.CsvReader;
import com.yyy.util.UUIDFactoryUtil;

public class ReadCsvByJavaCsvAPI {
	private static final Logger log = Logger.getLogger(CsvUtil.class);
	/**
	 * @属性说明：文件的磁盘路径
	 **/
	private static final String ADDRESS_FILE = "D:\\csvsource\\test.csv";
	/**
	 *   @生成时间： 2014-8-2 上午10:05:39
	 *   @方法说明： 测试读取csv文件
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@Test
	public void testReadCsvFile(){
		CsvReader reader;
		try {
			long startTime = System.currentTimeMillis();
			InputStreamReader isr = new InputStreamReader(new FileInputStream(ADDRESS_FILE),"gbk");
			reader = new CsvReader(isr);
//			OracleUnit.getConnection();
//			String [] nextLine;
			String sql = "insert into yyy_csv values('";
			while (reader.readRecord()) {
				StringBuffer insertStringBuffer = new StringBuffer(sql);
				insertStringBuffer.append(UUIDFactoryUtil.getUUID()).append("','");
				insertStringBuffer.append(reader.get(0)).append("','");
				insertStringBuffer.append(reader.get(1)).append("','");
				insertStringBuffer.append(reader.get(2)).append("')");
//				log.debug(insertStringBuffer.toString());
//				OracleUnit.execute(insertStringBuffer.toString());
			}
			long endTime = System.currentTimeMillis();
			log.debug(endTime - startTime);
//			OracleUnit.getConnection().commit();
		} catch (Exception e) {
			log.error("插入失败！", e);
		} finally {
//			try {
//				OracleUnit.getConnection().rollback();
//			} catch (SQLException e) {
//				log.error("回滚失败！", e);
//			}
//			OracleUnit.closeConnection();
		}
	}
}
