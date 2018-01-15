package com.yyy.dailycode.enjoycoding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *   @类名： MoneyUtil
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2016-11-19 上午10:07:14
 *   @修改人：
 *   @修改时间：  
 **/
public class MoneyUtil {
	/**
	 * @属性说明：校验结l果
	 **/
	private static boolean RESULT = true;
	/**
	 * @属性说明：错误信息
	 **/
	private static String ERROR_MESSAGE = "";
	/**
	 * @属性说明：正则校验表达式,金额大写字符集，只能包含如下字符
	 **/
	private static String WORD_REGEXP_PATTERN = "^[壹,贰,貳,叁,肆,伍,陆,陸,柒,捌,玖,拾,佰,仟,万,萬,亿,億,元,角,分,零,整,正,圆,圓,人,民,币,幣]+$";
	
	/**
	 * @属性说明：中文大写金额数字到“元”为止的，在“元”之后，应写“整”（或“正”）字，在“角”之后可以不写“整”（或“正”）字。
	 * 			  大写金额数字有“分”的，“分”后面不写“整”（或“正”）字。
	 * 
	 * 			1、中文大写金额到“元”为止的，在“元”之后，应写“整”（或“正”）字。例如：壹拾元整。壹拾元（错误）
	 *			2、中文大写金额到“角”之后可以不写“整”（或“正”）字。例如：壹拾元柒角、壹拾元柒角整、壹拾元柒角正。
	 *			3、中文大写金额有“分”的，“分”后面不写“整”（或“正”）字。例如：壹拾元柒角捌分、壹拾元柒角捌分整（错误）、壹拾元柒角捌分正（错误）
	 *
	 **/
	private static String ZHENG_REGEXP_PATTERN = ".+(元|圆|圓|分整)$";
	/**
	 * @属性说明：替换符，如果有人民币幣,空格,￥,替换为空
	 **/
	private static String REPLACE_REGEXP_PATTERN = "[人民币幣\\s￥]";
	
	/**
	 *   @生成时间： 2016-11-19 上午10:18:48
	 *   @方法说明： 校验传入的大写金额格式是否正确
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static boolean validateRules(String chineseMoney){
		//校验是否超出金额大写字符集
		boolean writingCriterion = validateWord(chineseMoney);
		
		if(writingCriterion){
			//金额大写以元、角、分为止的，分别符合对应的填写规范
			writingCriterion = validateZheng(chineseMoney);
		}
		if(writingCriterion){
			//金额中间有0时，金额大写填写应符合对应的填写规范
			writingCriterion = validateZero(chineseMoney);
		}
		return RESULT;
	}
	
	/**
	 *   @生成时间： 2016-11-19 下午03:03:12
	 *   @方法说明： 校验超出金额大写字符集
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static boolean validateWord(String chineseMoney){
		RESULT =  validateRules(chineseMoney, WORD_REGEXP_PATTERN);
        if(!RESULT){
        	ERROR_MESSAGE = "超出金额大写字符集";
        }
		return RESULT;
	}
	
	/**
	 *   @生成时间： 2016-11-19 下午03:03:24
	 *   @方法说明： 校验金额大写以元、角、分为止的，分别符合对应的填写规范
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static boolean validateZheng(String chineseMoney){
		RESULT =  validateRules(chineseMoney, ZHENG_REGEXP_PATTERN);
		if(!RESULT){
			ERROR_MESSAGE = "金额大写以元、角、分为止的，分别符合对应的填写规范";
		}
		return RESULT;
	}
	
	/**
	 *   @生成时间： 2016-11-19 下午03:03:47
	 *   @方法说明： 校验金额中间有0时，金额大写填写应符合对应的填写规范
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static boolean validateZero(String chineseMoney){
		RESULT =  validateRules(chineseMoney, ZHENG_REGEXP_PATTERN);
		if(!RESULT){
			ERROR_MESSAGE = "金额中间有0时，金额大写填写应符合对应的填写规范";
		}
		return RESULT;
	}
	
	/**
	 *   @生成时间： 2016-11-19 下午02:49:39
	 *   @方法说明： 根据正则表达式校验字符串
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static boolean validateRules(String str, String regexpPattern){
		Pattern pattern = Pattern.compile(regexpPattern);
		Matcher match = pattern.matcher(str);                
		return match.matches();
	}
	
	/**
	 *   @生成时间： 2016-11-19 上午11:18:26
	 *   @方法说明： 替换无用的符合要求的中文字符
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String replaceWords(String chineseMoney){
		chineseMoney =  chineseMoney.replaceAll(REPLACE_REGEXP_PATTERN, "");
		return chineseMoney;
	}
	
	/**
	 *   @生成时间： 2016-11-19 上午10:23:08
	 *   @方法说明： 测试方法
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void main(String[] args) {
		String chineseMoney = "壹拾万柒仟五十元零伍角叁分整";
		chineseMoney = replaceWords(chineseMoney);
		System.out.println(chineseMoney);
		System.out.println(validateRules(chineseMoney));
		System.out.println(CNNMFilter.cnNumericToArabic(chineseMoney, true));
//		System.out.println("\u58F9-\u8D30-\u53C1-\u8086-\u4F0D-\u9646-\u67D2-\u634C-\u7396-\u62FE-\u4F70-\u4EDF-\u4E07-\u4EBF-\u5143-\u89D2-\u5206-\u96F6-\u6574-\u6B63-\u5706-\u8CB3-\u9678-\u5104-\u842C-\u5713");
		System.out.println(RESULT);
		System.out.println(ERROR_MESSAGE);
	}
}
