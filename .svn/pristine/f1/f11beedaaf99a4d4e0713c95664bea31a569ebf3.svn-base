package com.yyy.dailycode.webservicecxf.util;
import java.util.ResourceBundle;

import com.yyy.dailycode.log.SinoLogger;
/**
 *  @类名： ReadProperties
 *  @描述： 读取配置
 *  @作者： 杨文胜
 *  @生成时间： 2013-11-13 上午09:57:58
 *  @修改人：
 *  @修改时间：
 */
public class ReadProperties {
	private static final SinoLogger _log = SinoLogger.getLogger(ReadProperties.class);
	/**
	 * @属性说明：配置文件的位置
	 **/
	private static final String CONFIG_BUNDLE = "resources/webservices/webservices";
	/**
	 * @属性说明：配置资源
	 **/
	private static ResourceBundle configBundle;
	/**
	 *   @生成时间： 2013-11-13 上午10:06:34
	 *   @方法说明： 获取配置文件中的值
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getProp(String key){
		try {
			if(null == configBundle){
				configBundle = ResourceBundle.getBundle(CONFIG_BUNDLE);
			}
			return configBundle.getString(key);
		} catch (Exception e) {
			_log.error("获取配置文件中的配置项错误", e);
		}
		return null;
	} 
	public static void main(String[] args) {
		System.out.println(getProp("webservice_compress_sign"));
	}
}
