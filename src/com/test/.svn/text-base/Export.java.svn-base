package com.test;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zkoss.web.servlet.http.HttpServlet;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

/**
 * @author win young
 * 
 * @创建时间:2012-7-27 下午12:53:16
 * 
 * @version 1
 * 
 * @类说明：
 */

public class Export extends HttpServlet {
	public Export() {
		// TODO Auto-generated constructor stub
	System.out.println("innit servlet Export");
	}
	private static final long serialVersionUID = 1L;
	// 初始化
	public void init(ServletConfig config) throws ServletException
	{
//		try {
//			export();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("** Servlet 初始化 ...") ;
		
	}
	// 表示处理get请求
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException
	{
		System.out.println("** Servlet doGet处理 ...") ;
		try {
			exportWord(req,resp);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 处理post请求
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException
	{
		System.out.println("** Servlet doPost处理 ...") ;
		try {
			exportWord(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file = new File("");
		PrintWriter out = resp.getWriter() ;
		out.println("<HTML>") ;
		out.println("<HEAD>") ;
		out.println("<TITLE>THE FIRST SERVLET</TITLE>") ;
		out.println("</HEAD>") ;
		out.println("<BODY>") ;
		out.println("<H1>Hello World!!!</H1>") ;
		out.println("</BODY>") ;
		out.println("</HTML>") ;
		out.println(file) ;
		out.close() ;
		
	}
	public void exportWord(HttpServletRequest req,HttpServletResponse response) throws Exception{
		String path = "c:\\yws\\YWS.DOC";
		//path是指欲下载的文件的路径。
		File file = new File(path);
		// 取得文件名。
		String filename = file.getName();
		// 取得文件的后缀名。
//		String ext = filename.substring(filename.lastIndexOf(".") + 1)
//				.toUpperCase();

		// 以流的形式下载文件。
		InputStream fis = new BufferedInputStream(new FileInputStream(path));
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		// 清空response
		response.reset();
//		 设置response的Header
		response.addHeader("Content-Disposition", "attachment;filename="
				+ new String(filename.getBytes()));
		response.addHeader("Content-Length", "" + file.length());
//		 URL u = new URL("file:///" + path);
//	            response.setContentType(u.openConnection().getContentType());
//	            response.setHeader("Content-Disposition", "inline; filename=" + file.getName());

		OutputStream toClient = new BufferedOutputStream(response
				.getOutputStream());
		response.setContentType("application/octet-stream");
		toClient.write(buffer);
		toClient.flush();
		toClient.close();
	}
	// 销毁
	public void destroy()
	{
		System.out.println("** Servlet 销毁 ...") ;
	}

	/**
	 * 
	 */
	public void export() throws DocumentException, Exception {
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
		Cell cell = new Cell("表头");// 单元格
		cell.setHeader(true);
		cell.setColspan(3);// 设置表格为三列
		cell.setRowspan(3);// 设置表格为三行
		table.addCell(cell);
		table.endHeaders();// 表头结束

		// 表格的主体
		cell = new Cell("Example cell 2");
		cell.setRowspan(2);// 当前单元格占两行,纵向跨度
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
