package com.test;
import java.util.ResourceBundle;




public class ReadProperties {
	public static void readProperties(String CONFIG_BUNDLE){
	ResourceBundle configBundle = ResourceBundle.getBundle( CONFIG_BUNDLE );
    String uri = configBundle.getString( "ContentEngineURL" );
	String domainName = configBundle.getString( "DomainName" );
	String username = configBundle.getString( "UserName" ); 
	String password = configBundle.getString( "Password" ); 
	System.out.println("uri="+uri);
	System.out.println("domainName="+domainName);
	System.out.println("username="+username);
	System.out.println("password="+password);
	}
	public static void main(String[] args) {
		String CONFIG_BUNDLE="filenetconfig";
		readProperties(CONFIG_BUNDLE);
	}
}
