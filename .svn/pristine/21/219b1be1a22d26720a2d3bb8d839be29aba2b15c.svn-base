package com.yyy.dailycode.enjoycoding.createexcel.cellstyle;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *   @类名： ExcelFont
 *   @描述： excel字体类
 *   @作者： 杨文胜
 *   @生成时间： 2014-5-26 下午06:29:58
 *   @修改人：
 *   @修改时间：  
 **/
public class ExcelFont {
	/**
	 * @属性说明：默认字体
	 **/
	private static final String DEFAULT_FONT_NAME = "宋体";
	/**
	 * @属性说明：默认字体大小
	 **/
	private static final int DEFAULT_FONT_SIZE = 10;
	/**
	 *   @生成时间： 2014-5-26 下午06:31:07
	 *   @方法说明： 获取字体格式
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static HSSFFont font_style(HSSFWorkbook workbook,boolean isBold){
		HSSFFont font = workbook.createFont();
		font.setFontName(DEFAULT_FONT_NAME);//设置字体格式，例如宋体
		font.setFontHeightInPoints((short) DEFAULT_FONT_SIZE);//设置字体大小
		if(isBold)
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		return font;
	}
}
