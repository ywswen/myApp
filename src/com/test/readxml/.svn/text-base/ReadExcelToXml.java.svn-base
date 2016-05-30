package com.test.readxml;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import filenet.vw.base.logging.Logger;


public class ReadExcelToXml{
	private static final Logger _log = Logger.getLogger(ReadExcelToXml.class);
	private static final String EXCEL_PATH = "resources/excel/interface.xls";
//	private static final String XMLPATH = "src/resources/excel/interface.xml";
//	private HashSet<String> []set = new HashSet [10];
	/**
	 * @des: read excel columns ,exchange to XML format
	 */
	@Test
	public void excelToXml(){
		Workbook wb = null;
		try {
			String filePath = ReadExcelToXml.class.getResource(EXCEL_PATH).getPath();
			wb = Workbook.getWorkbook(new File(filePath));
			Sheet sheet = wb.getSheet(3);
			int rows = sheet.getRows();
			for (int i = 5; i < rows; i++) {
				Cell cell = sheet.getCell(4, i);
				String contents = cell.getContents();
				if(StringUtils.isNotEmpty(contents)){
					_log.debug("contents " + contents);
					String []nodeNames = contents.split("/");
					for(int j=0;j<nodeNames.length;j++){
//						set[j].add(nodeNames[j]);
					}
				}
			}
		} catch (Exception e) {
			_log.error("read file fail", e);
		} finally {
			if(null != wb){
				wb.close();
			}
		}
	}
	public void createXml(){
//		Document doc = DocumentHelper.createDocument();
		int size  = 10;
		for (int i = 0; i < size; i++) {
			
		}
	}
	public static void main(String[] args) {
//		TreeList list = new TreeList();
	}
}
