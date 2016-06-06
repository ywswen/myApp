package com.yyy.dailycode.enjoycoding.comparetable.util;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 *   @类名： BeanMapUtil
 *   @描述： JavaBean和Map相互转换的工具类
 *   @作者： 杨文胜
 *   @生成时间： 2014-10-11 下午02:42:34
 *   @修改人：
 *   @修改时间：  
 **/
public class BeanMapUtil {
	private static final Logger _log = Logger.getLogger(BeanMapUtil.class);

	/**
	 *   @生成时间： 2012-12-15 下午02:27:27
	 *   @方法说明： 将Map转化为JavaBean
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@SuppressWarnings("unchecked")
	public static Object convertMap(Class type, Map map){
		Object obj = null;
		try{
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			obj = type.newInstance();
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (map.containsKey(propertyName)) {
					Object value = map.get(propertyName);
					Object[] args = new Object[1];
					if(null != value){
						if(value instanceof String){
							args[0] = ((String)value).trim();
						}else{
							args[0] = value;
						}
						descriptor.getWriteMethod().invoke(obj, args);
					}
				}
			}
		}catch(Exception ex){
			_log.error("Map转化为Bean【" + type.getName() + "】失败:", ex);
		}
		return obj;
	}
	
	/**
	 *   @生成时间： 2012-12-17 下午03:27:36
	 *   @方法说明： 将Map数组转化为对象数组
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@SuppressWarnings("unchecked")
	public static List<Object> convertMapForList(Class type, List<Map> listMap){
		List<Object> listObj = new ArrayList<Object>();
		for(Map m : listMap){
			listObj.add(convertMap(type, m));
		}
		return listObj;
	}

	/**
	 *   @生成时间： 2012-12-15 下午02:27:18
	 *   @方法说明： 将一个 JavaBean 对象转化为一个 Map
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@SuppressWarnings("unchecked")
	public static Map<String, Object> convertBean(Object bean){
		Map<String, Object> returnMap = null;
		try{
			returnMap = new HashMap<String, Object>();
			Class type = bean.getClass();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
	
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
		}catch(Exception ex){
			_log.error("Bean【" + bean.getClass().getName() + "】转化为Map失败：", ex);
		}
		return returnMap;
	}
}
