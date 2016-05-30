package com.yyy.dailycode.flex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * @author win young
 * 
 * @创建时间:2012-7-31 下午02:53:00
 * 
 * @version 1
 * 
 * @类说明：
 */

public class InstrumentPanel extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 处理post请求
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		System.out.println("** Servlet doPost处理 ...") ;
		String sql = "select '123' id,'123' name from dual";
		ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");//数据库配置文件
		String driver = bundle.getString("JDBC.Driver");
	    String url = bundle.getString("JDBC.ConnectionURL");
	    String userName = bundle.getString("JDBC.Username");
	    String password = bundle.getString("JDBC.Password");
	    Connection conn=null;
	    ResultSet rs =null;
	    java.sql.PreparedStatement pst=null;
	    JSONArray json=null;
    	try {
			Class.forName(driver);
    		conn=DriverManager.getConnection(url,userName,password);
    		try {
    			pst=conn.prepareStatement(sql);
    			rs=pst.executeQuery();
    			ResultSetMetaData rsmd = rs.getMetaData();//取数据库的列名 我觉得名比1，2，3..更好用   
    		    int numberOfColumns = rsmd.getColumnCount();
    		    List list = new ArrayList();
    			while(rs.next()){
    				Map<String,Object> map = new HashMap<String,Object>();
    				for(int i=1;i<=numberOfColumns;i++){
    					map.put(rsmd.getColumnName(i), rs.getObject(i));
    				}
    				list.add(map);
    			}
    			json = JSONArray.fromObject(list);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
//    			CommonUtil.debug(e.getMessage());
    		}
    	} catch (Exception e1) {
    		// TODO Auto-generated catch block
//    		CommonUtil.debug(e1.getMessage());
		}
    	finally{
			if(null!=pst)
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					CommonUtil.debug(e.getMessage());
				}
			if(null!=conn)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					CommonUtil.debug(e.getMessage());
				}
		}
		PrintWriter  out = resp.getWriter();
		out.print(json);
	}

	// 处理post请求
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		System.out.println("** Servlet doGet处理 ...") ;
	}
}
