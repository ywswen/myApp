package com.yyy.dailycode.db.loadproperties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 *   @类名： LoadProperties
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2014-3-28 下午06:34:13
 *   @修改人：
 *   @修改时间：  
 **/
public class LoadProperties {
	private static final Logger logger = Logger.getLogger(LoadProperties.class);
	/**
	 * @属性说明: interface的路径
	 */
	private static final String DBPATH = "resources.dbconfig.db";
	private static ResourceBundle resouceBundle = null;
	public static ResourceBundle getResourceBundle(){
		if(resouceBundle == null){
			initLoadLog4JProperties();
		}
		return resouceBundle;
	}
	private static void initLoadLog4JProperties(){
		resouceBundle = ResourceBundle.getBundle(DBPATH);
	}
	/**
	 *   @生成时间： 2014-3-28 下午06:34:23
	 *   @方法说明： 根据key获取值
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getValue(String key){
		String value = null;
		try{
			value = getResourceBundle().getString(key);
		}catch (Exception e) {
			logger.error("获取配置文件值失败!", e);
		}
		return value;
	}
	/**
	 *   @生成时间： 2014-3-28 下午06:34:43
	 *   @方法说明： 设置properties文件的key和value
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void setValue(String key, String value){
		Properties prop = new Properties();  
		OutputStream fos = null;
		try {
			String filePath = this.getClass().getResource("/cn/sforce/kqinterface/config/interfaceconfig.properties").getPath();
			InputStream ins = new FileInputStream(filePath);
			prop.load(ins);
			fos = new FileOutputStream(filePath);  
			 //修改sessionId
			prop.setProperty(key, value);
	        prop.store(fos,"");  
		} catch (Exception e) {
			logger.error("设置文件值session.properties【key】:" + key + "【value】:" + value + "失败！");
		} finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					logger.error("关闭文件流失败！");
				}
			}
		} 
	}
}
