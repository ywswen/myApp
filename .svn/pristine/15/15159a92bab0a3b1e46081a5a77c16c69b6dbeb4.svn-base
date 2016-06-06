package com.yyy.dailycode.enjoycoding.comparetable.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.yyy.dailycode.enjoycoding.comparetable.db.loadproperties.LoadDBProperties;

/**
 *   @类名： OrabDB
 *   @描述： b库数据库连接
 *   @作者： 杨文胜
 *   @生成时间： 2014-10-13 上午11:42:20
 *   @修改人：
 *   @修改时间：  
 **/
public class OrabDB {
	private static final Logger log = Logger.getLogger(OrabDB.class);
	/**
	 * @属性说明：数据库连接驱动
	 **/
	private static final String DRIVER = LoadDBProperties.getValue("ORAB.JDBC.Driver");
	/**
	 * @属性说明：url
	 **/
	private static final String URL = LoadDBProperties.getValue("ORAB.JDBC.ConnectionURL");
	/**
	 * @属性说明：用户名
	 **/
	private static final String USERNAME = LoadDBProperties.getValue("ORAB.JDBC.Username");
	/**
	 * @属性说明：密码
	 **/
	private static final String PASSWORD = LoadDBProperties.getValue("ORAB.JDBC.Password");
	static Connection conn = null;
	/**
	 *   @生成时间： 2014-10-13 上午11:57:01
	 *   @方法说明： 获取数据库连接
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static Connection getConnection(){
		try {
			if(conn == null || conn.isClosed()){
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			}
		} catch (Exception e) {
			log.error("数据库连接失败！", e);
		}
		return conn;
	}
	@SuppressWarnings("unchecked")
	public static List<Map> queryForList(String sql){
		List<Map> retList = new ArrayList<Map>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			String[] allCols = getMetaColsName(rs.getMetaData());
			int colsNum = allCols.length;
			while(rs.next()){
				Map row = new HashMap();
				for(int i=0; i<colsNum; i++){
					row.put(allCols[i].toLowerCase(), rs.getObject(allCols[i]));
				};
				retList.add(row);
			}
		}catch(Exception ex){
			log.error("数据库信息查询失败：", ex);
			return null;
		}finally{
			if(null != rs){
				try {
					rs.close();
				} catch (SQLException e) {
					log.error("关闭结果集失败：", e);
				}
			}
			if(null != stmt){
				try {
					stmt.close();
				} catch (SQLException e) {
					log.error("关闭stmt失败：", e);
				}
			}
			if(null != conn)
				try {
					conn.close();
				} catch (SQLException e) {
					log.error("关闭数据库连接失败：", e);
				}
		}
		return retList;
	}
	/**
	 *   @生成时间： 2012-6-21 下午01:26:34
	 *   @方法说明： 获取数据表的列名
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	protected static String[] getMetaColsName(ResultSetMetaData meta) throws SQLException{
		int closCount = meta.getColumnCount();
		String[] colstr = new String[closCount];
		for(int i=0; i<closCount; i++){
			colstr[i] = meta.getColumnName(i+1);
		}
		return colstr;
	}
}
