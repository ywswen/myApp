package com.yyy.dailycode.enjoycoding;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 *   @类名： IDCard
 *   @描述： 身份证类
 *   @作者： 杨文胜
 *   @生成时间： 2014-4-24 下午05:12:44
 *   @修改人：
 *   @修改时间：  
 **/
public class IDCard {
	private static final Logger log = Logger.getLogger(IDCard.class);
	/**
	 * @属性说明：性别：男
	 **/
	private static final String MALE_SEX = "男"; 
	/**
	 * @属性说明：性别：女
	 **/
	private static final String FEMALE_SEX = "女";
	/**
	 * @属性说明：出生日期
	 **/
	private Date birthDay;
	/**
	 * @属性说明：籍贯
	 **/
	private String nativePlace;
	/**
	 * @属性说明：校验码
	 **/
	private String[] wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
	/**
	 * @属性说明：身份证最后一位
	 **/
	private String[] code = {"1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2"};
	/**
	 * @属性说明：身份证号码
	 **/
	private String idCardNo;
	
	/**
	 *   @生成时间： 2014-4-24 下午05:19:28
	 *   @方法说明： 根据传入文件路径和身份证个数，输出${num}个身份证号码到指定文件中
	 *   @参数：    filePath：文件路径，num：文件个数
	 *   @返回值：  是否成功的boolean值
	 *   @异常：    IOException
	 **/
	public boolean getIDCard(String filePath, int num) throws IOException{
		File file = new File(filePath);
		if(!file.exists()){
			boolean fileCreateResult = file.createNewFile();
		}
		return true;
	}
	/**
	 *   @生成时间： 2014-4-24 下午05:27:20
	 *   @方法说明： 校验身份证号码是否有效
	 *   @参数：    idCardNo：身份证号码
	 *   @返回值：  是否有有效的标识
	 *   @异常：
	 **/
	public void verifyIDCard(String idCardNo){
		
	}
}
