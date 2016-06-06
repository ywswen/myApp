package com.yyy.dailycode.enjoycoding.createexcel.cellstyle;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelCellStyle {
	/**
	 *单元格文字加粗样式，格式为水平居中，垂直居中，字体加粗，无背景色
	 * @param workbook
	 * @param temp 1 为粗体
	 * @return
	 */
	public static HSSFCellStyle titleStyle(HSSFWorkbook workbook){
		HSSFCellStyle setBorder = workbook.createCellStyle();
		setBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		setBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		setBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		setBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		setBorder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直方向的对齐方式
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居
		HSSFFont font=ExcelFont.font_style(workbook,true);
    	font.setFontHeightInPoints((short) 16);//设置字体大小
    	setBorder.setFont(font);
		return setBorder;
	}
}
