package com.yyy.dailycode.db.access;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
public class AccessUnit {
	public static Logger log = Logger.getLogger(AccessUnit.class.getName());
	private final static String ACCESS_URL = LoadProperties.getValue("access_url");
	private final static String ACCESS_USER = LoadProperties.getValue("access_user");
	private final static String ACCESS_PWD = LoadProperties.getValue("access_pwd");
	private  static Connection con=null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		try {
			if(con == null){
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				con=DriverManager.getConnection(ACCESS_URL,ACCESS_USER,ACCESS_PWD);
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
	public static void main(String[] args) {
		try{
			
			String url = ACCESS_URL;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			  Properties prop = new Properties();    
			     prop.put("charSet", "gbk");    //解决中文乱码
			Connection conn = DriverManager.getConnection(url,prop);
			System.out.println(conn);
			Statement sta = conn.createStatement();
			//sta.executeUpdate("insert into yws(id,name) values('1133','哈哈')");
			ResultSet resu = sta.executeQuery("select * from CHECKEXACT");
			while(resu.next()){ 
				System.out.println(new String(resu.getBytes("name"),"gbk"));
			}
			System.out.println("exit");
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}

