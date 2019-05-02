package com.yyy.dailycode.stock.getstockyjyb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.yyy.dailycode.db.dbunit.OracleUnit;
import com.yyy.dailycode.stock.vo.StockYjbb;

/**
 *   @类名： GetStockYjbb
 *   @描述： 业绩预报
 *   @作者： 杨文胜
 *   @生成时间： 2019-5-2 下午05:29:57
 *   @修改人：
 *   @修改时间：  
 **/
public class GetStockYjbb {
	/**
	 * @属性说明：获取编号和名称的url
	 **/
	private static final String STOCK_URL = "http://dcfm.eastmoney.com/em_mutisvcexpandinterface/api/js/get?type=YJBB20_YJBB&token=70f12f2f4f091e459a279469fe49eca5&st=latestnoticedate&sr=-1&p=%d&ps=50&filter=";
	private static final String parametes = "(securitytypecode in ('058001001','058001002'))(reportdate=^2019-03-31^)";
	/**
	 * @属性说明：日志
	 **/
	private static final Logger _log = Logger.getLogger(GetStockYjbb.class);
	/**
	 * @属性说明：批量导入的记录数
	 **/
	private static final int BATCH = 50;
	
	/**
	 * @属性说明：执行的插入sql
	 **/
	private static final String SQL_PREFIX = "insert into STOCK_YJJB(scode,sname,securitytype,trademarket,latestnoticedate,reportdate,basiceps,cutbasiceps,totaloperatereve,ystz,yshz,parentnetprofit,sjltz,sjlhz,roeweighted,bps,mgjyxjje,xsmll) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static void main(String[] args) {
		try {
			initDataToDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void initDataToDataBase() throws SQLException{
			getAllStackCodes();
    }  
    /**
     *   @生成时间： 2017-4-28 下午02:54:47
     *   @方法说明： 获取所有的初始化数据
     *   @参数：
     *   @返回值： 
     *   @异常：
     **/
	private static void getAllStackCodes() {
		URL url = null;
		InputStream is = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		try {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				//获得链接
				conn = OracleUnit.getConnection();
				ps = conn.prepareStatement(SQL_PREFIX);
				//分页去取所有的业绩报表数据，每页50条数据
				for(int i=1;i<1000;i++){
					String urlAll = String.format(STOCK_URL,i) + URLEncoder.encode(parametes,"utf-8");
					url = new URL(urlAll);
					System.out.println(urlAll);
					URLConnection urlcon = url.openConnection();
					urlcon.setConnectTimeout(30000);
					urlcon.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
					urlcon.getContentType();
					is = urlcon.getInputStream();
					isr = new InputStreamReader(is);
					br = new BufferedReader(isr);
					int count = 0;
					String jsonStr = br.readLine();
					//如果查询返回结果为空或者为hello world，则跳出循环
					if(jsonStr == null || jsonStr.length() < 15){
						break;
					} else {
						ArrayList<StockYjbb> sys = JSONArray.parseObject(jsonStr, new TypeReference<ArrayList<StockYjbb>>() {});
						for(StockYjbb sy : sys){
//							StockYjbb sy = (StockYjbb)it.next();
							if (count % BATCH == 0 && count != 0) {
								ps.executeBatch();
								ps.close();
								ps = conn.prepareStatement(SQL_PREFIX);
							}
							ps.setString(1, sy.getScode());
							ps.setString(2, sy.getSname());
							ps.setString(3, sy.getSecuritytype());
							ps.setString(4, sy.getTrademarket());
							ps.setString(5, sy.getLatestnoticedate());
							ps.setString(6, sy.getReportdate());
							ps.setString(7, sy.getBasiceps());
							ps.setString(8, sy.getCutbasiceps());
							ps.setString(9, sy.getTotaloperatereve());
							ps.setString(10, sy.getYstz());
							ps.setString(11, sy.getYshz());
							ps.setString(12, sy.getParentnetprofit());
							ps.setString(13, sy.getSjltz());
							ps.setString(14, sy.getSjlhz());
							ps.setString(15, sy.getRoeweighted());
							ps.setString(16, sy.getBps());
							ps.setString(17, sy.getMgjyxjje());
							ps.setString(18, sy.getXsmll());
							ps.addBatch();
						}
						count++;
					}
					ps.executeBatch();
					conn.commit();
				}
				_log.debug("股票业绩报表入库成功！");
			} catch (IOException e) {
				_log.error("网络连接IO失败", e);
			} catch (SQLException e) {
				_log.error("数据库sql错误", e);
				conn.rollback();
			} catch (Exception e) {
				_log.error("其他异常", e);
				conn.rollback();
			} finally {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			}
		} catch (Exception e) {
			_log.error("其他异常", e);
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
				_log.error("关闭网络连接流失败", e);
			}
		}
	}  
}
