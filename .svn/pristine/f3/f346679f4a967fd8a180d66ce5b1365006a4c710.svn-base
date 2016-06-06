package com.yyy.projectcode.cetc.xxcj.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;


/**
 * @author Administrator
 * @description excel 操作，列转行
 */
public class ExcelOper {
	private static final Logger log = Logger.getLogger(ExcelOper.class);
	private static String filePath = "D:\\人员基本信息列.xls";
	private static String desPath = "D:\\数据.xls";
	
	/**
	 * @date 2014-7-24 13:06:25
	 * @description 测试读取文件转化成列
	 */
	@Test
	public void testExchangeExcelColumn(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			HSSFWorkbook hssWorkbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = hssWorkbook.getSheetAt(0);
			int lenth = sheet.getLastRowNum();
			String[] contents = new String[lenth + 1];
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				HSSFRow hssRow = sheet.getRow(i);
				if (hssRow == null) {
					continue;
				}
				HSSFCell cell = hssRow.getCell(0);
				String cellValue = cell.getStringCellValue();
				contents[i] = cellValue;
//				System.out.println(cellValue);
			}
			createExcel(contents);
		} catch (FileNotFoundException e) {
			System.out.println(e);
			log.error("文件未找到！", e);
		} catch (IOException e) {
			System.out.println(e);
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
			HSSFWorkbook hssWorkbook = new HSSFWorkbook();
			HSSFSheet sheet = hssWorkbook.createSheet();
			HSSFRow headRow = sheet.createRow(0);
			for (int i = 0; i < contents.length; i++) {
				HSSFCell headCell = headRow.createCell(i);
				headCell.setCellValue(contents[i]);
			}
			for (int i = 1; i < 1000; i++) {
				HSSFRow bodyRow = sheet.createRow(i);
				for (int j = 0; j < contents.length; j++) {
					HSSFCell headCell = bodyRow.createCell(j);
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
}
