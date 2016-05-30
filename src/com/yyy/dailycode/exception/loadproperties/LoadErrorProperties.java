package com.yyy.dailycode.exception.loadproperties;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @date 2014-7-25 17:22:32
 * @author yangws
 *
 */
public class LoadErrorProperties {
	private static final Logger log = Logger.getLogger(LoadErrorProperties.class);
	private static final String ERROR_FILE_PATH = "/resources/message/error.properties";
	private static Properties instance;
	private static Properties getInstance(){
		if(null == instance){
			loadProperties();
		}
		return instance;
	}
	private static void loadProperties(){
		instance = new Properties();
		InputStream inStream = LoadErrorProperties.class.getResourceAsStream(ERROR_FILE_PATH);
		try {
			instance.load(inStream);
		} catch (IOException e) {
			log.error("加载配置文件【" + ERROR_FILE_PATH + "】失败!", e);
		}
	}
	/**
	 * 根据key获取配置文件的value值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return getInstance().getProperty(key);
	}
	/**
	 * 根据key获取配置文件key值集合
	 * @param key
	 * @return
	 */
	public static Set<Map.Entry <Object,Object>> entrySet(){
		return getInstance().entrySet();
	}
	/**
	 * 根据key获取配置文件键值对集合
	 * @param key
	 * @return
	 */
	public static Enumeration<?> elements(){
		return getInstance().elements();
	}
	/**
	 * 根据key获取配置文件的value值,带参数获取
	 * @param key
	 * @return
	 */
	public static String getValue(String key,  Object[] params){
		return MessageFormat.format(getInstance().getProperty(key), params);
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println(LoadErrorProperties.getValue("error_001"));
		Hashtable<String, String> elements = (Hashtable<String, String>) LoadErrorProperties.elements();
		for(String key : elements.keySet()){
			System.out.println(key);
			System.out.println(elements.get(key));
		}
		System.out.println(LoadErrorProperties.elements());
	}
}
