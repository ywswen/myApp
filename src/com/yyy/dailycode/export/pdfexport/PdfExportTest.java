package com.yyy.dailycode.export.pdfexport;

import java.io.FileOutputStream;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

/**
 *   @类名： PdfExportTest
 *   @描述： pdf导出需要的jar ： itextpdf-5.4.3.jar
 *   @作者： 杨文胜
 *   @生成时间： 2013-10-14 下午04:12:56
 *   @修改人：
 *   @修改时间：  
 **/
public class PdfExportTest extends TestCase{
	private static final Logger _log = Logger.getLogger(PdfExportTest.class);
	/**
	 *   @生成时间： 2013-10-14 下午04:15:12
	 *   @方法说明： 导出pdf测试
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void testExportPdf() throws Exception{
		_log.debug("pdf导出。。。。");
		String fontFilePath = PdfExportTest.class.getResource("/").getPath() + "resources/cm/simhei.ttf";
		BaseFont bsFont = BaseFont.createFont(fontFilePath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font chFont = new Font(bsFont, 12, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
		Font tbFont = new Font(bsFont, 12, Font.NORMAL, BaseColor.BLACK);
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("c:\\tem1.pdf"));
		document.open();
		document.addTitle("yws");
		for(int i=0;i<5;i++){
			//章
			Chapter chapter = new Chapter(new Paragraph("00001",chFont), i);
			Image image = Image.getInstance("C:\\temp\\DSC00625..jpg");
			chapter.add(image);
			Section metadataSection = chapter.addSection(new Paragraph("元数据", chFont));
			metadataSection.setNumberDepth(0);
			metadataSection.setNumberDepth(0);// 章节是否带序号 设值=1 表示带序号  1.章节一；1.1小节一...，设值=0表示不带序号
			metadataSection.setBookmarkTitle("元数据");
			metadataSection.setIndentation(10);
			metadataSection.setIndentationLeft(10);
			metadataSection.setBookmarkOpen(false);
			metadataSection.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);
			metadataSection.add(new Paragraph(" "));
			PdfPTable pdfMetaTb = new PdfPTable(3);
			pdfMetaTb.setWidthPercentage(100);
			pdfMetaTb.setHorizontalAlignment(Element.ALIGN_LEFT);
			pdfMetaTb.addCell(new Phrase("元数据名称", tbFont));
			pdfMetaTb.addCell(new Phrase("元数据值", tbFont));
			pdfMetaTb.addCell(new Phrase("元数据描述", tbFont));
			for(int j=0;j<3;j++){
				pdfMetaTb.addCell(new Phrase("11", tbFont));
				pdfMetaTb.addCell(new Phrase("11", tbFont));
				pdfMetaTb.addCell(new Phrase("11", tbFont));
			}
			metadataSection.add(pdfMetaTb);
			
			
			LineSeparator line = new LineSeparator(1, 100, new BaseColor(204, 204, 204), Element.ALIGN_CENTER, -2);
			Paragraph p_line = new Paragraph("分割线");
			p_line.add(line);
			chapter.add(p_line);
			
			document.add(chapter);
		}
		document.close();
		_log.debug("pdf导出成功！");
	}
}

