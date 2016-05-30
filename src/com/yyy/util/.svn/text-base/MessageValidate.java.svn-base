package com.yyy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *   @类名： MessageValidate
 *   @描述： 消息验证类
 *   @作者： 杨文胜
 *   @生成时间： 2013-2-1 上午11:01:00
 *   @修改人：
 *   @修改时间：  
 **/
public class MessageValidate {
	/**
	 *   @生成时间： 2013-2-1 上午11:02:21
	 *   @方法说明： IP地址验证
	 *   @参数：     source：待验证的字符串
	 *   @返回值：   如果是符合格式的字符串,返回:true ,否则为:false 
	 *   @异常：
	 **/
	public boolean isIP(String source) {
		String num = "(25[0-5]|2[0-4]//d|[0-1]//d{2}|[1-9]?//d)";
		String regex = "^" + num + "//." + num + "//." + num + "//." + num + "$";
		return match(regex, source);
	}
	/**
	 *   @生成时间： 2013-2-1 上午11:08:13
	 *   @方法说明： 验证输入汉字
	 *   @参数：     source：待验证的字符串
	 *   @返回值：   如果是符合格式的字符串,返回:true ,否则为:false 
	 *   @异常：
	 **/
	public boolean IsChinese(String str) {
		String regex = "^[/u4e00-/u9fa5],{0,}$";
		return match(regex, str);
	}
	/**
	 *   @生成时间： 2013-2-1 上午11:09:38
	 *   @方法说明： 验证输入数字
	 *   @参数：     source：待验证的字符串
	 *   @返回值：   如果是符合格式的字符串,返回:true ,否则为:false 	
	 *   @异常：
	 **/
	public boolean IsNumber(String str) {
		String regex = "^[0-9]*$";
		return match(regex, str);
	}
	/**
	 *   @生成时间： 2013-2-1 上午11:09:38
	 *   @方法说明： 是否包含数字
	 *   @参数：     source：待验证的字符串
	 *   @返回值：   如果是符合格式的字符串,返回:true ,否则为:false 	
	 *   @异常：
	 **/
	public boolean IsContainsNumber(String str) {
		String regex = ".*\\d.*";
		return match(regex, str);
	}
	/**
	 *   @生成时间： 2013-2-1 上午11:09:38
	 *   @方法说明： 验证非特殊字符
	 *   @参数：     source：待验证的字符串
	 *   @返回值：   如果是符合格式的字符串,返回:true ,否则为:false 	
	 *   @异常：
	 **/
	public boolean isSafewords(String str) {
		String regex = "[^%$&'\\*\"]{1,}";
		return match(regex, str);
	}
	/**
	 *   @生成时间： 2013-2-1 上午11:25:57
	 *   @方法说明： 长度验证
	 *   @参数：     resource：待验证的字符串，length：长度
	 *   @返回值：   如果是符合格式的字符串,返回:true ,否则为:false 	
	 *   @异常：
	 **/
	public boolean isLength(String resource,int length){
		resource = resource.trim();
		if(null == resource || "".equals(resource) || length !=resource.length()){
			return false;
		}else{
			return true;
		}
	}
	/**
	 *   @生成时间： 2013-2-1 上午11:06:48
	 *   @方法说明： 
	 *   @参数：    regex:正则表达式字符串，resource:待验证的字符串
	 *   @返回值： 如果resource 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 *   @异常：
	 **/
	private static boolean match(String regex, String resource){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(resource);
		return matcher.matches();
	}
}

