/**
 * 
 */
package com.yyy.dailycode.wyp.HTML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author w397090770
 * Create Data: 2012-7-18
 * Email: wyphao.2007@163.com
 * 
 * 版权所有，翻版不究，但是在修改本程序的时候务必加上这些注释。谢谢
 * 仅用于学习交流之用，
 */
public class SaveAsTXT {
	public void html2txt(File file, String str, String title){
		
		//去掉<script>(.*?)</script>
		//str = str.replaceAll("<[Ss][Cc][Rr][Ii][Pp][Tt].*?>.*?<[/]?[Ss][Cc][Rr][Ii][Pp][Tt]>", "####");
		//str = str.replaceAll("<\\b(\\w+)[\\s\\w>\"/\'=:;.]+</\\1>", "####");
		str = str.replaceAll("<\\b(\\w+)[\\s\\w>\"/'=&:_;.]+</\\1>", "####");
		//去掉<br/>
		str = str.replaceAll("<[\\s]*[Bb][Rr][\\s]*[/]?[\\s]*>", System.getProperty("line.separator"));
		//<p>也是换行
		str = str.replaceAll("<[\\s]*[/]*[Pp].*?>", System.getProperty("line.separator"));
		//替换所以的HTML标签
		str = str.replaceAll("<[\\s]*[/]?[a-zA-Z]*.*?>", "");
		
		//替换空格,两个&nbsp;说明是一个大空格，一个&nbsp;说明是一个小的空格
		str = str.replaceAll("&nbsp;&nbsp;", "　");
		str = str.replaceAll("&nbsp;", " ");
		//替换> <号
		str = str.replaceAll(">", ">");
		str = str.replaceAll("<", "<");
		//替换& 
		str = str.replaceAll("&", "&");
		//半方大的空白
		str = str.replaceAll(" ", "　");
		//全方大的空白
		str = str.replaceAll(" ", "　");
		//双引号
		str = str.replaceAll("\"", "\"");
		//版权
		str = str.replaceAll("©", "");
		//已注册商标
		str = str.replaceAll("©", "");
		//乘号
		str = str.replaceAll("×", "×");
		//除号
		str = str.replaceAll("÷", "÷");
		//加号
		str = str.replaceAll("\\+", "+");
		//不知道为什么CSDN格字是被替换掉了，不管了，我也替换
		str = str.replaceAll("格", "格");
		
		//保存文件		
		File saveFileName = new File(file.getAbsolutePath() + File.separator + title + ".txt");
		if(!saveFileName.exists()){			//只有文件不存在才保存
			try {
				saveFileName.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
			}
			
			BufferedWriter bw = null;
			try {	//开始保存了
				bw = new BufferedWriter(new FileWriter(saveFileName.getAbsolutePath(), false));
				bw.write(str);
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}