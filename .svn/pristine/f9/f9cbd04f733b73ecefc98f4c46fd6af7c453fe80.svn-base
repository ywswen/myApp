package com.yyy.dailycode.enjoycoding.createexcel;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yyy.dailycode.enjoycoding.createexcel.cellstyle.ExcelCellStyle;
import com.yyy.dailycode.enjoycoding.createexcel.util.ExcelUtil;

/**
 *   @类名： ExcelExport
 *   @描述： 导出excel文件，需要的jar包括
 *   @作者： 杨文胜
 *   @生成时间： 2014-5-26 上午09:10:16
 *   @修改人：
 *   @修改时间：  
 **/
public class ExcelExport {
	@org.junit.Test
	 public void testCreate()throws Exception{
		 HSSFWorkbook workbook = new HSSFWorkbook();
	     HSSFSheet sheet = ExcelUtil.creatSheet(workbook, "sheet1");
	     ExcelUtil.region(sheet, 0, 2, 0, 32);
	     HSSFRow row = sheet.createRow(0);
	     HSSFCellStyle titleStyle = ExcelCellStyle.titleStyle(workbook);
	     ExcelUtil.setCellValueOfString(workbook, row, titleStyle, "杨文胜", 0);
	     HSSFRow row1 = sheet.createRow(5);
	     ExcelUtil.setCellValueOfString(workbook, row1, null, "仰望", 0);
	     String filePath = "c:\\aa.xls";
        workbook.write(new FileOutputStream(filePath));
        System.out.println("导出excel成功");
	 }
}
