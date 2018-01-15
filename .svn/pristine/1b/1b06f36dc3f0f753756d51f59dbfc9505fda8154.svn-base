package com.yyy.dailycode.stock.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.yyy.dailycode.db.dbunit.OracleUnit;
import com.yyy.dailycode.stock.getstockdata.diffchannel.unuse.GetStockHisDataYahoo;

/**
 *   @类名： NewStockOpen
 *   @描述： 新股开板提示
 *   @作者： 杨文胜
 *   @生成时间： 2017-5-1 下午06:06:13
 *   @修改人：
 *   @修改时间：  
 **/
public class NewStockOpen {
	private static final Logger _log = Logger.getLogger(NewStockOpen.class);
	/**
	 *   @生成时间： 2017-5-1 下午06:07:17
	 *   @方法说明： 新股开板提示
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void newStockOpen(){
		try {
			int count = 0;
			Connection conn = null;
			PreparedStatement ps = null;
			StringBuffer sqlPrefix = new StringBuffer("insert into stock_data_csv(stock_code,date1,open,high,low,close,volume,adjclose) values(?,?,?,?,?,?,?,?)");
			try {
//				// 获得链接
				conn = OracleUnit.getConnection();
				ps = conn.prepareStatement(sqlPrefix.toString());
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
		} finally {
		}
	}
}
