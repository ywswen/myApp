package com.yyy.dailycode.getLineCount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 *   @类名： StatisticsLineNumber
 *   @描述： 统计代码行数
 *   @作者： 杨文胜
 *   @生成时间： 2013-2-21 下午02:19:55
 *   @修改人：
 *   @修改时间：  
 **/
public class StatisticsLineNumber extends TestCase{
	private List<File> filesList = new ArrayList<File>();
	int lineNumber = 0;
	FileReader fr = null;
    BufferedReader br = null;
    static List<String> affix = new ArrayList<String>();
    
    public StatisticsLineNumber(){
    	affix.add(".java");
    	affix.add(".css");
    	affix.add(".xml");
    	affix.add(".js");
    	affix.add(".jsp");
    	affix.add(".css");
    }
	/**
	 *   @生成时间： 2013-2-21 下午02:42:25
	 *   @方法说明： 获取行数
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void getFileList(String filePath){
		File file = new File(filePath);
		if(file.isDirectory()){
			File temps[] = file.listFiles(new FileTypeFileter());
			for(File fs : temps){
				if(fs.isFile())
					filesList.add(fs);
				else
					getFileList(fs.getAbsolutePath());
			}
		}else{
			filesList.add(file);
		}
	}
    /**
     *   @生成时间： 2013-2-21 下午02:39:13
     *   @方法说明： 读取非空白行
     *   @参数：
     *   @返回值： 
     *   @异常：
     **/
    public void readLinePerFile() {
		try {
			for (File s : filesList) {
				int old = lineNumber;
				if (s.isDirectory()) {
					continue;
				}
				fr = new FileReader(s);
				br = new BufferedReader(fr);
				String i = "";
				while ((i = br.readLine()) != null) {
					if (validate(i))
						lineNumber++;
				}
				System.out.print(s.getName());
				System.out.println("\t\t有" + (lineNumber - old) + "行");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (Exception e) {
				}
			}
		}
	}
    /**
     *   @生成时间： 2013-2-21 下午02:38:09
     *   @方法说明： 验证行数是否有效
     *   @参数：
     *   @返回值： 
     *   @异常：
     **/
    public boolean validate(String i) {
        if (i.trim().length() == 0) {
            return false;
        } else {
            return true;
        }
    }
    class FileTypeFileter implements FileFilter{
		public boolean accept(File pathname) {
			String fileName = pathname.getName();
			if(pathname.isDirectory() && !fileName.endsWith("svn")){
    			return true;
    		}else if(pathname.isFile()){
    			if(fileName.indexOf(".") > 0){
    				String tmpaffix = fileName.substring(fileName.lastIndexOf("."));
    				if(StatisticsLineNumber.affix.contains(tmpaffix))
    					return true;
    				else
    					return false;
    			}else{
    				return false;
    			}
    		}else{
		    	return false;
		    }
		}
    }
    public void testGetLineNumber(){
    	String filePath="D:\\Workbench\\sinodata\\workspace\\myeclipse\\SinoImage2.0";
//    	String filePath="D:\\Workbench\\sinodata\\workspace\\sinoimage2.1\\SinoImage2.1.0\\src";
    	this.getFileList(filePath);
    	readLinePerFile();
    	System.out.println(this.lineNumber);
    }
}
