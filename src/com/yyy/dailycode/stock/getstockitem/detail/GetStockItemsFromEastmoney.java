package com.yyy.dailycode.stock.getstockitem.detail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.yyy.dailycode.db.dbunit.OracleUnit;
import com.yyy.dailycode.stock.vo.StockItems;

/**
 *   @类名： GetStockData
 *   @描述： 从东方财富获取股票基本数据
 *   @作者： 杨文胜
 *   @生成时间： 2017-4-28 下午02:53:48
 *   @修改人：
 *   @修改时间：  
 **/
public class GetStockItemsFromEastmoney {
	/**
	 * @属性说明：获取编号和名称的url
	 **/
	private static final String STOCK_URL = "http://quote.eastmoney.com/stocklist.html";
	/**
	 * @属性说明：日志
	 **/
	private static final Logger _log = Logger.getLogger(GetStockItemsFromEastmoney.class);
	/**
	 * @属性说明：url编码
	 **/
	private static final String URL_CODE = "gbk";
	/**
	 * @属性说明：正则表达式匹配寻找id/code/name
	 **/
	private static final String REG_PATTERN = "eastmoney.com/(.*?).html\">(.*?)\\((.*?)\\)";
	/**
	 * @属性说明：匹配到的内容
	 **/
	private static final String MATCH_WORDS = "http://quote.eastmoney.com/";
	/**
	 * @属性说明：点号
	 **/
	private static final String DOT = ".";
	
	public static void main(String[] args) {
		try {
			initDataToDataBase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			_log.error("获取基础数据失败！", e);
		}
	}
    public static void initDataToDataBase() throws SQLException{
    	Connection conn = null;
		PreparedStatement ps = null;
		StringBuffer sqlPrefix = new StringBuffer("insert into STOCK_ITEMS(stock_id,stock_code,stock_name,stock_code_url) values(?,?,?,?)");
		try {
			// // 获得链接
			conn = OracleUnit.getConnection();
			OracleUnit.execute("delete from STOCK_ITEMS");
			ps = conn.prepareStatement(sqlPrefix.toString());
			List<StockItems> list = getAllStackCodes();
			for(StockItems si : list){
				ps.setString(1, si.getStock_id());
				ps.setString(2, si.getStock_code());
				ps.setString(3, si.getStock_name());
				ps.setString(4, si.getStock_code_url());
				ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
		} catch (Exception e) {
			_log.error("入库失败！", e);
			conn.rollback();
		} finally {
			if (ps != null)
				ps.close();
			OracleUnit.closeConnection();
		}
    	
    }  
    /**
     *   @生成时间： 2017-4-28 下午02:54:47
     *   @方法说明： 获取所有的初始化数据
     *   @参数：
     *   @返回值： 
     *   @异常：
     **/
    private static List<StockItems> getAllStackCodes() {
		URL url = null;
		String line = null;
		InputStream is = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		URLConnection connection = null;
		// 正则表达式拆分出Id,Code,Name,拆分出三个
		Pattern p = Pattern.compile(REG_PATTERN);
		List<StockItems> listStockItems = new ArrayList<StockItems>();
		try {
			String stockId;
			url = new URL(STOCK_URL);
			connection = url.openConnection();
			connection.setConnectTimeout(30000);
			is = connection.getInputStream();
			isr = new InputStreamReader(is, URL_CODE);
			br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				if (line.contains(MATCH_WORDS)) {
					//line匹配内容为 <li><a target="_blank" href="http://quote.eastmoney.com/sz300651.html">金陵体育(300651)</a></li>
					Matcher m = p.matcher(line);
					while (m.find()) {
						StockItems si = new StockItems();
						stockId = m.group(1);
						si.setStock_id(stockId);
						si.setStock_name(m.group(2));
						si.setStock_code(m.group(3));
						if(stockId.startsWith("sz")){
							si.setStock_code_url(stockId.substring(2) + DOT + "sz");
						}else if(stockId.startsWith("sh")){
							si.setStock_code_url(stockId.substring(2) + DOT + "ss");
						}else{
							si.setStock_code_url(stockId.substring(2) + DOT + "ss");
						}
						listStockItems.add(si);
					}
				}
			}
		} catch (Exception e) {
			_log.error("获取日志失败", e);
		}finally{
				try {
					if(is != null)
						is.close();
					if(br != null)
						br.close();
					if(isr != null)
						isr.close();
				} catch (IOException e) {
					_log.error("关闭网络连接失败！", e);
				}
		}
		return listStockItems;
	}  
}
