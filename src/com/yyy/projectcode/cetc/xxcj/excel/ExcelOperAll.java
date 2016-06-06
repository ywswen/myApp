package com.yyy.projectcode.cetc.xxcj.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.yyy.util.DateFormatTools;

/**
 *   @类名： ExcelOperAll
 *   @描述： 行转列，并填充测试数据，支持excel2003和excel2007
 *   		依赖的jar包括poi-3.10-FINAL-20140208.jar、
 *   		poi-ooxml-3.10-FINAL-20140208.jar、
 *   		poi-ooxml-schemas-3.10-FINAL-20140208.jar、
 *   		stax-api-1.0.1.jar、
 *  		xmlbeans-2.3.0.jar
 *   dom4j-1.6.1.jar
 *   @作者： 杨文胜
 *   @生成时间： Jul 29, 2014 3:00:59 PM
 *   @修改人：
 *   @修改时间：  
 **/
public class ExcelOperAll {
	private static final Logger log = Logger.getLogger(ExcelOper.class);
	private static String filePath = "D:\\人员基本信息列.xlsx";
	private static String desPath = "D:\\数据.xlsx";
	
	/**
	 * @date 2014-7-24 13:06:25
	 * @description 测试读取文件转化成列
	 */
	@Test
	public void testExchangeExcelColumn(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			Workbook hssWorkbook = null;
			String fileName = filePath.toLowerCase();
			if(fileName.endsWith(".xls")){
				hssWorkbook =  new HSSFWorkbook(fis);
			} else if(fileName.endsWith(".xlsx")){
				hssWorkbook =  new XSSFWorkbook(fis);
			}
			Sheet sheet = hssWorkbook.getSheetAt(0);
			int lenth = sheet.getLastRowNum();
			String[] contents = new String[lenth + 1];
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				Row hssRow = sheet.getRow(i);
				if (hssRow == null) {
					continue;
				}
				Cell cell = hssRow.getCell(0);
				String cellValue = getCellValue(cell);
				contents[i] = cellValue;
//				System.out.println(cellValue);
			}
			createExcel(contents);
		} catch (FileNotFoundException e) {
			log.error("文件未找到！", e);
		} catch (IOException e) {
			log.error("读取excel文件失败！", e);
		}
	}
	/**
	 * @param contents
	 * @date 2014-7-24 13:07:17
	 * @description 转化成列并填充数据
	 */
	public static void createExcel(String[] contents) {
		FileOutputStream fos = null;
		try {
			File file = new File(desPath);
			if (file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			Workbook hssWorkbook = null;
			String fileName = filePath.toLowerCase();
			if(fileName.endsWith(".xls")){
				hssWorkbook =  new HSSFWorkbook();
			} else if(fileName.endsWith(".xlsx")){
				hssWorkbook =  new XSSFWorkbook();
			}
			Sheet sheet = hssWorkbook.createSheet();
			Row headRow = sheet.createRow(0);
			for (int i = 0; i < contents.length; i++) {
				Cell headCell = headRow.createCell(i);
				headCell.setCellValue(contents[i]);
			}
			for (int i = 1; i < 60000; i++) {
				Row bodyRow = sheet.createRow(i);
				for (int j = 0; j < contents.length; j++) {
					Cell headCell = bodyRow.createCell(j);
					String value = contents[j].substring(0, 1) + String.format("%06d", i);
					headCell.setCellValue(value);
				}
			}
			hssWorkbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			log.error("文件未找到！", e);
		} catch (IOException e) {
			log.error("读取excel文件失败！", e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					log.error("关闭文件流失败", e);
				}
			}
		}
	}
	public String getCellValue(Cell cell){
		String cellValue = "";
		if(cell == null){
			return cellValue;
		}
		int cellType = cell.getCellType();
		switch(cellType){
			case Cell.CELL_TYPE_NUMERIC:
				if(HSSFDateUtil.isCellDateFormatted(cell)){
					cellValue = DateFormatTools.getDateTimeString(cell.getDateCellValue()) ;
				}else{
					cellValue = cell.getNumericCellValue() + "";
				}
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
		}
		return cellValue;
	}
}
