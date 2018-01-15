package com.yyy.dailycode.stock.getstockdata.diffchannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.yyy.dailycode.db.dbunit.OracleUnit;
import com.yyy.util.DateFormatTools;

/**
 *   @类名： GetStockHisDataFromSohu
 *   @描述： 从搜狐获得数据
 *   @作者： 杨文胜
 *   @生成时间： 2015-12-22 下午05:47:43
 *   @修改人：
 *   @修改时间：  
 **/
public class GetStockHisDataFromSohu {
	
	/**
	 * @属性说明：日志
	 **/
	private static final Logger _log = Logger.getLogger(GetStockHisDataFromSohu.class);
	/**
	 * @属性说明：批量导入的记录数
	 **/
	private static final int BATCH = 50;
	
	/**
	 * @属性说明：周期类型，日：d、月:m、年:y
	 **/
	public static final String CYCLETYPE = "d";
	
	/**
	 * @属性说明：json数据格式
	 **/
	private static final String HQ = "hq";

	public static void main(String[] args) {
//		List<StockItems> listStockItems = new GetStockDataFromDB().getStockItems();
		String stockCode,initURLStr;
//		for(StockItems si : listStockItems){
//			stockCode = si.getStock_code_url();
			stockCode = "300463";
//			System.out.println(stockCode);
			initURLStr = initURLStr(stockCode,CYCLETYPE);
			loadDataToDb(initURLStr, stockCode, 0);
//		}
//		String stockCode = "600158.ss";
//		String initURLStr = initURLStr(stockCode,CYCLETYPE);
//		loadDataToDb(initURLStr,stockCode);
//		loadDataToDb("http://q.stock.sohu.com/hisHq?code=cn_000002&start=20170101&end=20170501",stockCode);
//		loadDataToDb("l",stockCode);
		
	}
	/**
	 * @生成时间： 2015-12-22 下午05:12:02
	 * @方法说明： stockCode代码，cycleType周期类型，日：d、月:m、年:y
	 * @参数：
	 * @返回值：
	 * @异常：
	 **/
	public static String initURLStr(String stockCode, String cycleType) {
		String startDay = "20180105";
		String endDay = DateFormatTools.getCurrentDateStr();
		StringBuffer url = new StringBuffer("http://q.stock.sohu.com/hisHq");
		url.append("?code=cn_").append(stockCode);
		url.append("&start=").append(startDay);
		url.append("&end=").append(endDay);
//		System.out.println(url.toString());
		return url.toString();
	}
	/**
	 *   @生成时间： 2015-12-22 下午05:33:55
	 *   @方法说明： 获取数据入库
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@SuppressWarnings("unchecked")
	public static void loadDataToDb(String urlStr, String stockCode, int i) {
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
			int count = 1;
			String line = null;
			Connection conn = null;
			PreparedStatement ps = null;
			StringBuffer sqlPrefix = new StringBuffer("insert into stock_data_sohu(stock_code,date1,open,close,turnover,gain,low,high,volume,amount,exchange) values(?,?,?,?,?,?,?,?,?,?,?)");
			try {
//				// 获得链接
				conn = OracleUnit.getConnection();
				ps = conn.prepareStatement(sqlPrefix.toString());
				//获取返回内容，并且返回成功"status":0
				while ((line = br.readLine()) != null && line.startsWith("[{\"status\":0,")) {
					
					JSONObject jsonObject = JSONObject.fromObject(line.substring(1, line.length()-1));
					JSONArray jsonArray = jsonObject.getJSONArray(HQ);
					Collection<Object> col = JSONArray.toCollection(jsonArray, Object.class);
					Iterator<Object> it = col.iterator();
					while (it.hasNext()) {
						//[["2017-04-28","20.76","20.97","0.02","0.10%","20.60","21.20","25375","5317.53","4.86%"]
						@SuppressWarnings("rawtypes")
						ArrayList o = (ArrayList)it.next();
						Object[] content= (Object[]) o.toArray();
						if (count % BATCH == 0 && count != 0) {
							ps.executeBatch();
							ps.close();
							ps = conn.prepareStatement(sqlPrefix.toString());
						}
						ps.setString(1, stockCode);
						for (int j = 0; j < content.length; j++) {
							ps.setString(j + 2, content[j].toString());
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
			_log.error(stockCode + "入库失败！");
			i++;
			//为了保证稳定性，请求两次
			if(i<3){
				loadDataToDb(urlStr, stockCode,i);
			}
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
