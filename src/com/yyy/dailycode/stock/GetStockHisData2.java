package com.yyy.dailycode.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.yyy.dailycode.db.dbunit.OracleUnit;
import com.yyy.dailycode.stock.vo.StockItems;

/**
 *   @类名： GetStockHisData
 *   @描述： 导入历史数据
 *   @作者： 杨文胜
 *   @生成时间： 2015-12-22 下午05:47:43
 *   @修改人：
 *   @修改时间：  
 **/
public class GetStockHisData2 {
	
	/**
	 * @属性说明：日志
	 **/
	private static final Logger _log = Logger.getLogger(GetStockHisData2.class);
	/**
	 * @属性说明：批量导入的记录数
	 **/
	private static final int BATCH = 50;
	
	/**
	 * @属性说明：周期类型，日：d、月:m、年:y
	 **/
	private static final String CYCLETYPE = "d";

	public static void main(String[] args) {
		List<StockItems> listStockItems = new GetStockDataFromDB().getStockItems();
		String stockCode,initURLStr;
		for(StockItems si : listStockItems){
			stockCode = si.getStock_code();
			
			initURLStr = initURLStr(stockCode,CYCLETYPE);
			loadDataToDb(initURLStr,stockCode);
		}
//		String stockCode = "600158.ss";
//		String initURLStr = initURLStr(stockCode,CYCLETYPE);
//		loadDataToDb(initURLStr,stockCode);
		//loadDataToDb("http://table.finance.yahoo.com/table.csv?s=000528.sz&d=2&e=10&f=2011&g=d&a=11&b=18&c=2010&ignore=.csv",stockCode);
		//loadDataToDb("http://real-chart.finance.yahoo.com/table.csv?s=300072.SZ&a=05&b=11&c=2010&d=07&e=23&f=2010&g=d&ignore=.csv",stockCode);
		
	}
	/**
	 * @生成时间： 2015-12-22 下午05:12:02
	 * @方法说明： stockCode代码，cycleType周期类型，日：d、月:m、年:y
	 * @参数：
	 * @返回值：
	 * @异常：
	 **/
	public static String initURLStr(String stockCode, String cycleType) {
		Calendar calendar = Calendar.getInstance();
		int endDay = calendar.get(Calendar.DAY_OF_MONTH);
		int endMonth = calendar.get(Calendar.MONTH);
		int endYear = calendar.get(Calendar.YEAR);
		calendar.add(Calendar.DAY_OF_YEAR, -10);
		int startDay = calendar.get(Calendar.DAY_OF_MONTH);
		int startMonth = calendar.get(Calendar.MONTH);
		int startYear = calendar.get(Calendar.YEAR);
		StringBuffer url = new StringBuffer(
				"http://real-chart.finance.yahoo.com/table.csv?ignore=.csv");
		url.append("&s=").append(stockCode);
		url.append("&a=").append(startMonth);
		url.append("&b=").append(startDay);
		url.append("&c=").append(startYear);
		url.append("&d=").append(endMonth);
		url.append("&e=").append(endDay);
		url.append("&f=").append(endYear);
		url.append("&g=").append(cycleType);
		System.out.println(url.toString());
		return url.toString();
	}
	/**
	 *   @生成时间： 2015-12-22 下午05:33:55
	 *   @方法说明： 获取数据入库
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void loadDataToDb(String urlStr, String stockCode) {
		URL url = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			url = new URL(urlStr);
			URLConnection urlcon = url.openConnection();
			urlcon.setConnectTimeout(30000);
			is = urlcon.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
//			br = new BufferedReader(new InputStreamReader(urlcon.getInputStream())) ; 
			int count = 0;
			String line = null;
			Connection conn = null;
			PreparedStatement ps = null;
			StringBuffer sqlPrefix = new StringBuffer("insert into stock_data(stock_code,date1,open,high,low,close,volume,adjclose) values(?,?,?,?,?,?,?,?)");
			try {
//				// 获得链接
				conn = OracleUnit.getConnection();
				ps = conn.prepareStatement(sqlPrefix.toString());
				while ((line = br.readLine()) != null) {
					if (count > 0) {
						String[] datas = line.split(",");
						if (count % BATCH == 0 && count != 0) {
							ps.executeBatch();
							ps.close();
							ps = conn.prepareStatement(sqlPrefix.toString());
						}
						ps.setString(1, stockCode);
						for (int j = 0; j < datas.length; j++) {
							ps.setString(j + 2, datas[j].trim());
						}
						ps.addBatch();
					}
					count++;
//					System.out.println(count);
				}
				ps.executeBatch();
				conn.commit();
			}catch (Exception e) {
				_log.error("第" + (count+2) + "条数据导入数据库数据失败", e);
				conn.rollback();
				throw new Exception(e);
			}
			finally {
				if(ps != null)
					ps.close();
			}
		} catch (Exception e) {
			_log.error(stockCode + "入库失败！", e);
			loadDataToDb(urlStr, stockCode);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				_log.error("关闭流失败！", e);
			}
		}
	}
}
