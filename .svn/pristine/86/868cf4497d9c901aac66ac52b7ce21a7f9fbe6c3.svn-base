package com.yyy.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 *   @类名： FileSplit
 *   @描述： 将大文件拆分成小文件
 *   @作者： 杨文胜
 *   @生成时间： 2014-8-14 下午05:06:49
 *   @修改人：
 *   @修改时间：  
 **/
public class FileSplit {
	private static final Logger log = Logger.getLogger(FileSplit.class);
	/**
	 * @属性说明：文件连接下划线
	 **/
	private static String FILE_NAME_FIX = "_";
	/**
	 * @属性说明：切割每个文件的行数默认为100000
	 **/
	private static int SPLIT_FILE_LINE = 100000;
	/**
	 * @属性说明：用户目录
	 **/
	private static String USER_DIR = System.getProperty("user.dir");
	/**
	 * @属性说明：换行符
	 **/
	private static final String NEXT_LINE = System.getProperty("line.separator");
	/**
	 *   @生成时间： 2014-9-15 下午12:01:20
	 *   @方法说明： 拆分文件，每100万行一个文件，拆分后的文件名称为oldFileName_YYYYMMDD_000i，将csv的第一行文件拷贝每个文件中
	 *   @参数：		filePath：传入文件路径，savePath：切割后存储文件路径
	 *   @返回值： 
	 *   @异常：IOException 
	 **/
	public static List<String> splitCsvFile(String filePath, String savePath, String fileType) throws IOException {
		int fileLine = 0;
		int smallFileCount = 1;
		BufferedWriter bw = null;
		String fileContent = null;
		//第一行CSV的内容
		String firstLineContent = null;
		File bigFile = new File(filePath);
		List<String> splitFiles = new ArrayList<String>();
		try {
			String fileName = bigFile.getName();
			int dotIndex = fileName.lastIndexOf(".");
			if(null == savePath && "" == savePath){
				fileType = fileName.substring(dotIndex);
			}
			String fileSimpleName = fileName.substring(0, dotIndex);
			String splitFilePath = null;
			if(null == savePath && "" == savePath){
				splitFilePath = savePath + File.separator + fileSimpleName;
			}else{
				splitFilePath = bigFile.getParent() + File.separator + fileSimpleName;
			}
			File file = new File(splitFilePath);
			if(!file.exists()){
				file.mkdir();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(bigFile), GetFileCharset.getFilecharset(bigFile)));
			String smallFilePrefix = splitFilePath + File.separator + fileSimpleName + FILE_NAME_FIX + DateFormatTools.getCurrentDateStr();
			String smallFile = smallFilePrefix + FILE_NAME_FIX + String.format("%04d", smallFileCount) + fileType;
			bw = new BufferedWriter(new FileWriter(smallFile));
			splitFiles.add(smallFile);
			//写入第一行
			firstLineContent = br.readLine();
			bw.write(firstLineContent);
			bw.write(NEXT_LINE);
			while((fileContent = br.readLine()) != null){
				if(fileLine % SPLIT_FILE_LINE == 0 && fileLine != 0){
					bw.flush();
					bw.close();
					smallFileCount ++;
					log.debug("分割文件【" + smallFile + "】成功！");
					smallFile = smallFilePrefix + FILE_NAME_FIX + String.format("%04d", smallFileCount) + fileType;
					bw = new BufferedWriter(new FileWriter(smallFile));
					bw.write(firstLineContent);
					bw.write(NEXT_LINE);
					splitFiles.add(smallFile);
				}
				bw.write(fileContent);
				bw.write(NEXT_LINE);
				fileLine++;
			}
			bw.flush();
			log.debug("分割文件【" + smallFile + "】成功！");
		} catch (FileNotFoundException e) {
			log.error("文件不存在！", e);
			throw e;
		} catch (IOException e) {
			log.error("文件读取失败！",e);
			throw e;
		} finally{
			if(null != bw)
				bw.close();
		}
		return splitFiles;
	}
	/**
	 *   @生成时间： 2014-8-14 下午05:08:10
	 *   @方法说明： 拆分文件，每100万行一个文件，拆分后的文件名称为oldFileName_YYYYMMDD_000i
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void splitFile(String filePath) {
		File bigFile = new File(filePath);
		int fileLine = 0;
		int smallFileCount = 1;
		BufferedWriter bw = null;
		String fileContent = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(bigFile), GetFileCharset.getFilecharset(bigFile)));
			String fileName = bigFile.getName();
			int dotIndex = fileName.lastIndexOf(".");
			String fileType = fileName.substring(dotIndex);
			String fileSimpleName = fileName.substring(0, dotIndex);
			String splitFilePath = bigFile.getParent() + File.separator + fileSimpleName;
			File file = new File(splitFilePath);
			if(!file.exists()){
				file.mkdir();
			}
			String smallFilePrefix = splitFilePath + File.separator + fileSimpleName + FILE_NAME_FIX + DateFormatTools.getCurrentDateStr();
			String smallFile = smallFilePrefix + FILE_NAME_FIX + String.format("%04d", smallFileCount) + fileType;
			bw = new BufferedWriter(new FileWriter(smallFile));
			while((fileContent = br.readLine()) != null){
				if(fileLine % SPLIT_FILE_LINE == 0 && fileLine != 0){
					smallFileCount ++;
					bw.flush();
					bw.close();
					smallFile = smallFilePrefix + FILE_NAME_FIX + String.format("%04d", smallFileCount) + fileType;
					bw = new BufferedWriter(new FileWriter(smallFile));
					System.out.println("分割文件【" + smallFile + "】成功！");
				}
				bw.write(fileContent);
				bw.write(NEXT_LINE);
				fileLine++;
			}
			bw.flush();
			bw.close();
			System.out.println("分割文件【" + smallFile + "】成功！");
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("文件读取失败！");
		}
	}
	/**
	 *   @生成时间： 2014-9-12 下午04:40:27
	 *   @方法说明： 获取工程目录下的所有文件，不包括run.bat执行文件
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static List<File> getFileList(){
		File file = new File(USER_DIR);
		File[] childrenFiles = file.listFiles();
		List<File> listFiles = new ArrayList<File>();
		for(File fileChild  : childrenFiles){
			String fileSimpleName = fileChild.getName().split("\\.")[0];
			//去掉执行文件
			if(!"".equals(fileSimpleName) && !fileSimpleName.contains("run") && fileChild.isFile()){
				listFiles.add(fileChild);
			}
		}
		return listFiles;
	}
	/**
	 *   @生成时间： 2014-9-12 下午04:45:36
	 *   @方法说明： 分割所有文件
	 *   @参数：
	 *   @返回值：   isOper：是否分割文件
	 *   @异常：
	 **/
	public static boolean splitFile(){
		boolean isOper = false;
		List<File> files = getFileList();
		for(File file : files){
			splitFile(file.getPath());
			isOper = true;
		}
		return isOper;
	}
	public static void main(String[] args) {
		//第一个参数是指分割行数
		if (args.length > 1 && args[0] != null) {
			SPLIT_FILE_LINE = Integer.parseInt(args[0]);
		}
		//第二个参数是指分割目录
		if (args.length > 2 && args[1] != null) {
			USER_DIR = args[1];
		}
		USER_DIR = "D:\\test\\新建文件夹\\德邦北京.csv";
		long startTime = System.currentTimeMillis();
		@SuppressWarnings("unused")
		List<String>list = null;
		 try {
			list = splitCsvFile(USER_DIR, "", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		FileOper.deleteListFile(list);
		long endTime = System.currentTimeMillis();
//		if(isOper){
			System.out.println("分割所用时间为【" + DateFormatTools.getStrByTimeMillis(endTime - startTime) + "】");
//		}else{
//			System.out.println("文件夹【" + USER_DIR + "】中不存在可分割的文件");
//		}
	}
}

