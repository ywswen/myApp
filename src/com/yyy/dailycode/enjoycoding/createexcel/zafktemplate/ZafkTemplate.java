package com.yyy.dailycode.enjoycoding.createexcel.zafktemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import com.yyy.dailycode.enjoycoding.createexcel.cellstyle.ExcelCellStyle;
import com.yyy.dailycode.enjoycoding.createexcel.util.ExcelUtil;

/**
 *   @类名： ZafkTemplate
 *   @描述： 生成治安防控的模板
 *   @作者： 杨文胜
 *   @生成时间： 2014-10-20 上午09:59:28
 *   @修改人：
 *   @修改时间：  
 **/
public class ZafkTemplate {
	private static final Logger log = Logger.getLogger(ZafkTemplate.class);
	@Test
	public void testCreateExcel(){
		HSSFWorkbook workbook = new HSSFWorkbook();
		createSheet1(workbook);
		try {
			FileOutputStream fos = new FileOutputStream(new File("d:\\测试.xls"));
			workbook.write(fos);
			fos.close();
		}  catch (IOException e) {
			log.error("创建模板失败", e);
		}
	}
	/**
	 *   @生成时间： 2014-10-20 上午10:02:15
	 *   @方法说明： 创建巡检情况汇总表
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void createSheet1(HSSFWorkbook workbook){
		HSSFSheet sheet = ExcelUtil.creatSheet(workbook, "巡检情况汇总表");
		ExcelUtil.region(sheet, 0, 1, 0, 26);
		HSSFRow row = sheet.createRow(0);
	    HSSFCellStyle cell1Style = ExcelCellStyle.getCellStyles(workbook).get("cell1");
	    ExcelUtil.setCellValueOfString(workbook, row, cell1Style, "社防、基工项目组日常巡检表", 0);
	    
	    HSSFRow row2 = sheet.createRow(2);
	    HSSFCellStyle cell2Style = ExcelCellStyle.getCellStyles(workbook).get("cell2");
	    ExcelUtil.setCellValueOfString(workbook, row2, cell2Style, "系统名称", 0);
	    ExcelUtil.setCellValueOfString(workbook, row2, cell2Style, "服务器主机设备资源使用情况", 3);
	    ExcelUtil.setCellValueOfString(workbook, row2, cell2Style, "数据库表空间资源使用情况", 6);
	    ExcelUtil.setCellValueOfString(workbook, row2, cell2Style, "应用系统及重要模块运行情况", 9);
	    ExcelUtil.setCellValueOfString(workbook, row2, cell2Style, "服务器时钟同步情况", 12);
	    ExcelUtil.setCellValueOfString(workbook, row2, cell2Style, "服务器时钟同步情况", 15);
	    ExcelUtil.setCellValueOfString(workbook, row2, cell2Style, "服务器时钟同步情况", 22);
	    ExcelUtil.region(sheet, 2, 4, 0, 2);
	    ExcelUtil.region(sheet, 2, 4, 3, 5);
	    ExcelUtil.region(sheet, 2, 4, 6, 8);
	    ExcelUtil.region(sheet, 2, 4, 9, 11);
	    ExcelUtil.region(sheet, 2, 4, 12, 14);
	    ExcelUtil.region(sheet, 2, 4, 15, 21);
	    ExcelUtil.region(sheet, 2, 4, 22, 26);
	    
	    
	}
}
