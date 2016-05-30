package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BugFreetest {
	public static void main(String args[]){
    	String drive="sun.jdbc.odbc.JdbcOdbcDriver";
    	String url="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=d:/1.mdb";
    	try{    		
    		Class.forName(drive);
    		Connection conn=DriverManager.getConnection(url);
    		System.out.println("Connection successful");
    		String query="select *from users";
    		PreparedStatement st=conn.prepareStatement(query);
    		ResultSet s=st.executeQuery();
    		while(s.next()){
    			String name=s.getString("username");
    			String pass=s.getString("password");
    			String sta=s.getString("status");
    			System.out.println(name+": "+pass+": "+sta);
    		}
    
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }
}
