package com.yyy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *   @类名： SimpleDateUtil
 *   @作者： 杨文胜
 *   @生成时间： 2011-12-1 下午06:26:23
 *   @修改人：
 *   @修改时间： 
 *   @描述： 与日期相关的的函数
 **/
public class DateFormatTools {
	// 日期格式
	public static String RULE_DATE_DAUFLAT = "yyyy-MM-dd";
	public static String FIRST_DAY_MONTH_DAUFLAT = "yyyy-MM-01";
	private static String NO_SPLIT_SIGN_DATE = "yyyyMMdd";
	private static String NO_SPLIT_SIGN_DATE_TIME = "yyyyMMddHHmmssSSS";
	private static String NO_SPLIT_SIGN_MONTH = "yyyyMM";
	private static String RULE_TIME_DAUFLAT = "HH:mm:ss";
	private static String NO_SPLIT_SIGN_TIME = "HHmmss";
	private static String DATE_AND_TIME_STR = "yyyy-MM-dd HH:mm:ss";
	private static String DATE_AND_TIME_STR_NO_SPLIT = "yyyyMMddHHmmss";
	
	/**
	 *   @生成时间： 2011-12-1 下午06:26:32
	 *   @方法说明： 获取yyyyMMddHHmmss格式字符串
	 *   @参数： 
	 *   @返回值： 
	 *   @异常：
	 *
	 */
	public static String getDateTimeStr(){
		DateFormat sf = new SimpleDateFormat(DATE_AND_TIME_STR_NO_SPLIT);
		return sf.format(new Date());
	}
	/**
	 *   @生成时间： 2011-12-1 下午06:26:32
	 *   @方法说明： 字符串转化为日期对象
	 *   @参数： 日期字符串
	 *   @返回值： 
	 *   @异常：
	 *
	 */
	public static Calendar getDate(String str) throws ParseException{
		DateFormat sf = new SimpleDateFormat(RULE_DATE_DAUFLAT);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sf.parse(str));
		return cal;
	}
	
	/**
	 *   @生成时间： 2014-7-29 上午11:43:59
	 *   @方法说明： 将当前日期转化为时间，精确到毫秒
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getDateTimeStrNoSplit(){
		DateFormat sf = new SimpleDateFormat(NO_SPLIT_SIGN_DATE_TIME);
		return sf.format(new Date());
	}
	/**
	 *   @生成时间： 2011-12-1 下午06:26:59
	 *   @方法说明： 将当前日期转化为
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getCurrentDateStr(){
		DateFormat sf = new SimpleDateFormat(NO_SPLIT_SIGN_DATE);
		return sf.format(new Date());
	}
	/**
	 *   @生成时间： 2011-12-1 下午06:26:59
	 *   @方法说明： 将当前日期转化为
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getCurrentDateStrDefault(){
		DateFormat sf = new SimpleDateFormat(RULE_DATE_DAUFLAT);
		return sf.format(new Date());
	}
	
	/**
	 *   @生成时间： 2011-12-1 下午06:27:12
	 *   @方法说明： 获取系统当前时间，格式 hh:MM:ss
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getTime(){
		DateFormat sf = new SimpleDateFormat(RULE_TIME_DAUFLAT);
		return sf.format(new Date());
	}
	
	/**
	 *   @生成时间： 2013-7-3 下午06:07:46
	 *   @方法说明： 获取系统当前时间，格式 HHmmss
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getCurrentTimeStr(){
		DateFormat sf = new SimpleDateFormat(NO_SPLIT_SIGN_TIME);
		return sf.format(new Date());
	}
	/**
	 *   @生成时间： 2012-2-28 上午10:54:48
	 *   @方法说明： 获取num天以前的日期字符串
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getNDayString(int num){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, num);
		DateFormat sf = new SimpleDateFormat(NO_SPLIT_SIGN_DATE);
		return sf.format(cal.getTime());
	}
	
	/**
	 *   @生成时间： Sep 17, 2013 4:47:04 PM
	 *   @方法说明： 日期转换成字符串
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getDateString(Date date){
		DateFormat sf = new SimpleDateFormat(RULE_DATE_DAUFLAT);
		return sf.format(date);
	}
	/**
	 *   @生成时间： Sep 17, 2013 4:47:04 PM
	 *   @方法说明： 获取某日期的字符串,格式为yyyyMMdd
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getNoSignDateStr(Date date){
		DateFormat sf = new SimpleDateFormat(NO_SPLIT_SIGN_DATE);
		return sf.format(date);
	}
	
	/**
	 *   @生成时间： 2013-9-23 下午06:53:23
	 *   @方法说明： 日期包括时间
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getDateTimeString(Date date){
		DateFormat sf = new SimpleDateFormat(DATE_AND_TIME_STR);
		return sf.format(date);
	}
	/**
	 *   @生成时间： 2014-1-6 下午04:44:56
	 *   @方法说明： 获取下一个周六的日期
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getSaturDayDateStr(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return getNoSignDateStr(calendar.getTime());
	}
	/**
	 *   @生成时间： 2014-5-9 下午04:24:07
	 *   @方法说明： 获取yyyyMM月的n个月之后的月
	 *   @参数：   
	 *   @返回值：   字符串：yyyyMM
	 *   @异常：
	 **/
	public static String getNMonthStr(String dateStr, int n){
		try {
			SimpleDateFormat sf = new SimpleDateFormat(NO_SPLIT_SIGN_MONTH);
			Calendar cal = Calendar.getInstance();
			cal.setTime(sf.parse(dateStr));
			cal.add(Calendar.MONTH, n);
			return sf.format(cal.getTime());
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 *   @生成时间： 2014-5-9 下午04:24:07
	 *   @方法说明： 获取当前时间的每月1日
	 *   @参数：   
	 *   @返回值：   字符串：yyyy年MM月dd日
	 *   @异常：
	 **/
	public static String getFirstDayOfCurrentMonthStr(){
		SimpleDateFormat sf = new SimpleDateFormat(FIRST_DAY_MONTH_DAUFLAT);
		return sf.format(new Date());
	}
	/**
	 *   @生成时间： 2014-9-12 下午05:20:00
	 *   @方法说明： 根据传入的毫秒获取XX年XX天XX小时XX分钟XX秒XX毫秒格式的字符串
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getStrByTimeMillis(long timeMillis){
		long year = timeMillis / (1000 * 60 * 60 * 24 * 365);
		long day = timeMillis % (1000 * 60 * 60 * 24 * 365);
		day = day / (1000 * 60 * 60 * 24);
		long hour = timeMillis % (1000 * 60 * 60 * 24);
		hour = hour / (1000 * 60 * 60);
		long minute = timeMillis % (1000 * 60 * 60);
		minute = minute / (1000 * 60);
		long second = timeMillis % (1000 * 60);
		second = second / (1000);
		long millis = timeMillis % 1000;
		StringBuffer sb = new StringBuffer();
		if (year > 0)
			sb.append(year).append("年");
		if (day > 0)
			sb.append(day).append("天");
		if (hour > 0)
			sb.append(hour).append("小时");
		if (minute > 0)
			sb.append(minute).append("分钟");
		if (second > 0)
			sb.append(second).append("秒");
		if (millis > 0)
			sb.append(millis).append("毫秒");
		return sb.toString();
	}
}
