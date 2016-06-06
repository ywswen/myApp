package com.test;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

public class Y {
	public static void main(String[] args) throws IOException, DocumentException {
		Document document = new Document(PageSize.A4);
		File file = new File("c:\\yws\\YWS.DOC");
		if (file.exists()) {
			file.createNewFile();
		}
		RtfWriter2.getInstance(document, new FileOutputStream(file));
		document.open();
		Paragraph p = new Paragraph("出口合同", new Font(Font.NORMAL, 18,
				Font.BOLDITALIC, new Color(0, 0, 0)));
		
		p.setAlignment(1);
		document.add(p);
		  Table table = new Table(4);    
		    document.add(new Paragraph("生成表格"));    
		    table.setBorderWidth(1);    
		    table.setBorderColor(Color.BLACK);    
		    table.setPadding(0);    
		    table.setSpacing(0);    
		        
		    /*   
		     * 添加表头的元素   
		     */   
		    Cell cell = new Cell("表头");//单元格     
		    cell.setHeader(true);    
		    cell.setColspan(3);//设置表格为三列     
		    cell.setRowspan(3);//设置表格为三行     
		    table.addCell(cell);    
		    table.endHeaders();// 表头结束     
		   
		    // 表格的主体     
		    cell = new Cell("Example cell 2");    
		    cell.setRowspan(2);//当前单元格占两行,纵向跨度     
		    table.addCell(cell);    
		    table.addCell("1,1");    
		    table.addCell("1,2");    
		    table.addCell("1,3");    
		    table.addCell("1,4");    
		    table.addCell("1,5");    
		    table.addCell(new Paragraph("用java生成的表格1"));    
		    table.addCell(new Paragraph("用java生成的表格2"));    
		    table.addCell(new Paragraph("用java生成的表格3"));    
		    table.addCell(new Paragraph("用java生成的表格4"));    
		    Paragraph paragraph = new Paragraph("用java生成word文件");
		    paragraph.setFirstLineIndent(20);
		    document.add(paragraph);    
		    document.add(table);    
		    document.close(); 
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));
	}
}