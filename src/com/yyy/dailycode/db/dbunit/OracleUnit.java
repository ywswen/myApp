package com.yyy.dailycode.db.dbunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.yyy.dailycode.db.loadproperties.LoadProperties;

/**
 *   @类名： OracleUnit
 *   @描述： oracle数据库连接
 *   @作者： 杨文胜
 *   @生成时间： 2014-3-28 下午06:26:08
 *   @修改人：
 *   @修改时间：  
 **/
public class OracleUnit {
	public static Logger log = Logger.getLogger(OracleUnit.class.getName());
	private final static String ORACLE_URL = LoadProperties.getValue("oracle_url");
	private final static String ORACLE_USER = LoadProperties.getValue("oracle_user");
	private final static String ORACLE_PWD = LoadProperties.getValue("oracle_pwd");
	private  static Connection con=null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		try {
			if(con == null || con.isClosed()){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				con=DriverManager.getConnection(ORACLE_URL,ORACLE_USER,ORACLE_PWD);
				stmt = con.createStatement();
			}
		} catch (Exception e) {
			log.error("获取数据库连接失败", e);
		}
		return con;
	}
	/**
	 * 关闭数据库链接
	 */
	public static void closeConnection(){
		try {
			if(rs != null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			log.error("关闭数据库链接失败", e);
		}
	}
	/**
	 * 执行查询语句
	 */
	public static ResultSet query(String sql){
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			log.error("执行查询语句失败", e);
		}
		return rs;
	}
	/**
	 * 执行更新语句
	 */
	public static void execute(String sql){
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			log.error("执行更新语句失败", e);
		}
	}
}
