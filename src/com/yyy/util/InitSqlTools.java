package com.yyy.util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;



public class InitSqlTools {
	/**
	 * @属性说明：文件目录
	 **/
	private static final String FILE_PATH="D:\\aa.xlsx";
	/**
	 * @属性说明：生成sql的路径
	 **/
	private static final String DESTINATION_PATH = "d:\\init.sql";
	private static final Logger log = Logger.getLogger(InitSqlTools.class);
	private static FileWriter fw;
	private static BufferedWriter br;
	static{
		try {
			fw = new FileWriter(DESTINATION_PATH);
			br = new BufferedWriter(fw);
		} catch (IOException e) {
			log.error("文件未找到！", e);
		}
	}
	/**
	 * @date 2014-7-24 13:06:25
	 * @description 测试读取文件转化成列
	 */
	@Test
	public void testExchangeExcelColumn(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILE_PATH);
			Workbook hssWorkbook = null;
			String fileName = FILE_PATH.toLowerCase();
			if(fileName.endsWith(".xls")){
				hssWorkbook =  new HSSFWorkbook(fis);
			} else if(fileName.endsWith(".xlsx")){
				hssWorkbook =  new XSSFWorkbook(fis);
			}
			Sheet sheet = hssWorkbook.getSheetAt(0);
			String tableId = UUIDFactoryUtil.generateUUID();
			
			//拼接com_cfg_field表的插入数据
			writeString("--com_cfg_field表的插入数据");
			StringBuffer insertPrefixSql = new StringBuffer();
			insertPrefixSql.append("insert into com_cfg_field (id, tableid, fieldname, colname, fieldpct, show, px, condition) values (sys_guid(), '");
			insertPrefixSql.append(tableId).append("','");
			Row firstRow = sheet.getRow(0);
			Row secondRow = sheet.getRow(1);
			int cellNum = firstRow.getLastCellNum();
			for(int i=1;i<cellNum;i++){
				StringBuffer com_cfg_field = new StringBuffer(insertPrefixSql.toString());
				Cell firstRowCell = firstRow.getCell(i);
				Cell secondRowCell = secondRow.getCell(i);
				String firstRowCellValue = getCellValue(firstRowCell);
				String secondRowCellValue = getCellValue(secondRowCell);
				com_cfg_field.append(secondRowCellValue).append("','");
				com_cfg_field.append(firstRowCellValue).append("', '10', '0', '1");
				com_cfg_field.append(String.format("%03d", i));
				com_cfg_field.append("', '');");
				writeString(com_cfg_field.toString());
			}
			
			//拼接com_cfg_table表的插入数据
			writeString("--com_cfg_table表的插入数据");
			//数据库表
			String tableName = getCellValue(sheet.getRow(2).getCell(1));
			//数据库表名称
			String sheetName = getCellValue(sheet.getRow(3).getCell(1));
			StringBuffer com_cfg_table = new StringBuffer();
			com_cfg_table.append("insert into com_cfg_table(id, tablename, sheetname)values ('");
			com_cfg_table.append(tableId).append("','");
			com_cfg_table.append(tableName).append("','");
			com_cfg_table.append(sheetName).append("');");
			writeString(com_cfg_table.toString());
			
			//拼接com_cfg_cjgxb表的插入数据
			writeString("--com_cfg_cjgxb表的插入数据");
			//单位编码
			String dwcode = getCellValue(sheet.getRow(4).getCell(1));
			//单位名称
			String dwname = getCellValue(sheet.getRow(5).getCell(1));
			//单位父编码（在com_dict表中）
			String dwpcode = getCellValue(sheet.getRow(6).getCell(1));
			//类型编码
			String lxcode = getCellValue(sheet.getRow(7).getCell(1));
			//类型名称
			String lxname = getCellValue(sheet.getRow(8).getCell(1));
			//类型父编码（在com_dict表中）
			String lxpcode = getCellValue(sheet.getRow(9).getCell(1));
			//com_cfg_cjgxb的id主键
			String com_cfg_cjgxb_id = UUIDFactoryUtil.generateUUID();
			StringBuffer com_cfg_cjgxb = new StringBuffer();
			com_cfg_cjgxb.append("insert into com_cfg_cjgxb(id, lxcode, dwcode, tableid)values ('");
			com_cfg_cjgxb.append(com_cfg_cjgxb_id).append("','");
			com_cfg_cjgxb.append(lxcode).append("','");
			com_cfg_cjgxb.append(dwcode).append("','");
			com_cfg_cjgxb.append(tableId).append("');");
			writeString(com_cfg_cjgxb.toString());
			
			//拼接com_dict表的单位插入数据
			writeString("--com_dict表的单位插入数据");
			//com_dict的id主键
			String com_dict_dwid = UUIDFactoryUtil.generateUUID();
			StringBuffer com_dict_dw = new StringBuffer();
			com_dict_dw.append("merge into com_dict t ");
			com_dict_dw.append("using (select '").append(com_dict_dwid).append("' id,");
			com_dict_dw.append("			   '").append(dwname).append("' name,");
			com_dict_dw.append("			   '").append(dwcode).append("' code,");
			com_dict_dw.append("			   '").append(dwpcode).append("' pcode");
			com_dict_dw.append("		from dual) t2 ");
			com_dict_dw.append("on (t.code = t2.code) ");
			com_dict_dw.append("when not matched then ");
			com_dict_dw.append("  insert (id, name, code, pcode, status, px) values (t2.id,t2.name, t2.code, t2.pcode, '1', t2.code);");
			writeString(com_dict_dw.toString());
			
			//拼接com_dict表的类型插入数据
			writeString("--com_dict表的类型插入数据");
			//com_dict的id主键
			String com_dict_lxid = UUIDFactoryUtil.generateUUID();
			StringBuffer com_dict_lx = new StringBuffer();
			com_dict_lx.append("merge into com_dict t ");
			com_dict_lx.append("using (select '").append(com_dict_lxid).append("' id,");
			com_dict_lx.append("			   '").append(lxname).append("' name,");
			com_dict_lx.append("			   '").append(lxcode).append("' code,");
			com_dict_lx.append("			   '").append(lxpcode).append("' pcode");
			com_dict_lx.append("		from dual) t2 ");
			com_dict_lx.append("on (t.code = t2.code) ");
			com_dict_lx.append("when not matched then ");
			com_dict_lx.append("  insert (id, name, code, pcode, status, px) values (t2.id,t2.name, t2.code, t2.pcode, '1', t2.code);");
			writeString(com_dict_lx.toString());
			
			
			//--删除com_cfg_field插入的数据
			writeString("--删除com_cfg_field插入的数据");
			StringBuffer delete_com_cfg_field = new StringBuffer();
			delete_com_cfg_field.append("-- delete from com_cfg_field where tableid='").append(tableId).append("';");
			writeString(delete_com_cfg_field.toString());
			
			//--删除com_cfg_table插入的数据
			writeString("--删除com_cfg_table插入的数据");
			StringBuffer delete_com_cfg_table = new StringBuffer();
			delete_com_cfg_table.append("-- delete from com_cfg_table where id='").append(tableId).append("';");
			writeString(delete_com_cfg_table.toString());
			
			//--删除com_cfg_cjgxb插入的数据
			writeString("--删除com_cfg_cjgxb插入的数据");
			StringBuffer delete_com_cfg_cjgxb = new StringBuffer();
			delete_com_cfg_cjgxb.append("-- delete from com_cfg_cjgxb where id='").append(com_cfg_cjgxb_id).append("';");
			writeString(delete_com_cfg_cjgxb.toString());
			
			//--删除com_dict插入单位的数据
			writeString("--删除com_dict插入单位的数据");
			StringBuffer delete_com_dict_dw = new StringBuffer();
			delete_com_dict_dw.append("-- delete from com_dict where id='").append(com_dict_dwid).append("';");
			writeString(delete_com_dict_dw.toString());
			
			//--删除com_dict插入类型的数据
			writeString("--删除com_dict插入类型的数据");
			StringBuffer delete_com_dict_lx = new StringBuffer();
			delete_com_dict_lx.append("-- delete from com_dict where id='").append(com_dict_lxid).append("';");
			writeString(delete_com_dict_lx.toString());
			
			br.close();
		} catch (FileNotFoundException e) {
			log.error("文件未找到！", e);
		} catch (IOException e) {
			log.error("读取excel文件失败！", e);
		}
	}
	/**
	 *   @生成时间： Aug 6, 2014 4:30:23 PM
	 *   @方法说明： 书写一行数据
	 *   @参数：
	 *   @返回值： 
	 * @throws IOException 
	 *   @异常：
	 **/
	public void writeString(String lineStr) throws IOException{
		br.write(lineStr);
		br.write("\r\n");
	}
	public String getCellValue(Cell cell){
		String cellValue = "";
		if(cell == null){
			return cellValue;
		}
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cellValue = cell.getStringCellValue();
		return cellValue;
	}
}
