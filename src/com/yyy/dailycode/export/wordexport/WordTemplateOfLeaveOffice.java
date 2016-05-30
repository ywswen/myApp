package com.yyy.dailycode.export.wordexport;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

/**
 *   @类名： WordTemplateOfLeaveOffice
 *   @描述： 离职人员工资变动模板生成
 *   @作者： 杨文胜
 *   @生成时间： 2014-5-20 上午09:54:17
 *   @修改人：
 *   @修改时间：  
 **/
public class WordTemplateOfLeaveOffice {
	private static final Logger log = Logger.getLogger(WordTemplateOfLeaveOffice.class);
	/**
	 *   @生成时间： 2014-5-20 上午09:56:48
	 *   @方法说明： 生成模板
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@Test
	public void createTemplate(){
		try {
			Document document = new Document(PageSize.A4);
			File file = new File("c:\\YWS.DOC");
			if (!file.exists()) {
				file.createNewFile();
			}
			RtfWriter2.getInstance(document, new FileOutputStream(file));
			document.open();
			Paragraph p = new Paragraph("出口合同", new Font(Font.NORMAL, 18,
					Font.BOLDITALIC, new Color(0, 0, 0)));
			document.add(p);
			Table table = new Table(3);
			table.setBorderWidth(1);
			table.setBorderColor(Color.black);
			for(int i=0;i<ExceptionID.exceptionIds.length;i++){
				table.addCell(ExceptionID.exceptionIds[i][0]);
				table.addCell(ExceptionID.exceptionIds[i][1]);
				table.addCell(ExceptionID.exceptionIds[i][2]);
			}
			document.add(table);
			document.close();
		} catch (Exception e) {
			log.error("生成word模板失败", e);
		}
	}
}
