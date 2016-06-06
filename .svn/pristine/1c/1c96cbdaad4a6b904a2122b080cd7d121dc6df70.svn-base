package com.yyy.dailycode.export.wordexport;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;
public class WordExport {
	public static void main(String[] args) {
		WordExport wordExport = new WordExport();
		try {
			wordExport.export();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void export() throws DocumentException, Exception {
		Document document = new Document(PageSize.A4);
		File file = new File("c:\\yws\\YWS.DOC");
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
	}
}
