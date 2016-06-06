package com.yyy.dailycode.wyp.HTML;
/**
 * @author win young
 *
 * @创建时间:2012-7-26 下午02:32:47
 *
 * @version 1
 *
 * @类说明：
 */

/**
 * 
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
//import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.RtfWriter2;

/**
 * @author w397090770
 * Create Data: 2012-7-18
 * Email: wyphao.2007@163.com
 * 
 * 版权所有，翻版不究，但是在修改本程序的时候务必加上这些注释。谢谢
 * 仅用于学习交流之用
 */
public class SaveAsDOC {
	@SuppressWarnings("unchecked")
	public  void getDoc(File file, String contents, String title) throws Exception {
		//file是保存文件的文件夹路径，contests是前面处理好的网页源码，title是帖子的标题，用于标记生成的文件名		
		File saveFileName = new File(file.getAbsoluteFile() + File.separator + title + ".doc");
		if(!saveFileName.exists()){
			saveFileName.createNewFile();
		}else{		//和以前处理txt文件一样，如果先前这个文件已经存在，我们就不打算再去生成doc文件了，直接返回
			return;
		}
		// 设置纸张大小
		Document document = new Document(PageSize.A4);
		// 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
		RtfWriter2.getInstance(document,new FileOutputStream(saveFileName));
		document.open();
		// 设置中文字体
		//BaseFont bfChinese = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		// 正文字体风格
		//Font contextFont = new Font(bfChinese, 12, Font.NORMAL);
		
		// 添加页眉
		HeaderFooter header = new HeaderFooter(new Phrase(title), false);
		header.setAlignment(Rectangle.ALIGN_CENTER);
		document.setHeader(header);
		// 添加页脚
		/*HeaderFooter footer = new HeaderFooter(new Phrase(), false);
		footer.setAlignment(Rectangle.ALIGN_CENTER);
		document.setFooter(footer);*/
		
		
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(Element.ALIGN_LEFT);
		paragraph.setFirstLineIndent(20);

		StyleSheet ss = new StyleSheet();
		// 添加网页里面的东西   
        List<Element>htmlList = HTMLWorker.parseToList(new StringReader(contents),ss);  
        for (int i = 0; i < htmlList.size(); i++) {  
            Element e = htmlList.get(i);  
            paragraph.add(e);  
        }  
  
        document.add(paragraph);  
        document.close(); 
	}
}
