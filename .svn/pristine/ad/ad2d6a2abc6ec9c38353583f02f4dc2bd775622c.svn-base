package com.yyy.dailycode.wyp.filerename;

import java.io.File;

import com.yyy.dailycode.log.SinoLogger;

/**
 *   @类名： FileRename
 *   @描述： 批量修改文件名
 *   @作者： 杨文胜
 *   @生成时间： 2014-1-10 下午04:53:12
 *   @修改人：
 *   @修改时间：  
 **/
public class FileRename {
	private static final SinoLogger log = SinoLogger.getLogger(FileRename.class);
	private static int fileNumber = 0;
	/**
	 *	 @生成时间： 2014-1-10 下午04:54:39
	 *	 @方法说明： 修改文件后缀名,
	 *				注意: 如果修改文件夹下的文件,修改了3个文件,第四个文件失败的话,前3个文件已经修改,没有做到事物控制
	 *	 @参数：	 filePath:文件路径;replaceSuffixName:文件修改后的后缀名,例如修改后的都是.jpg的文件
	 *	 @throws Exception 
	 *	 @返回值：
	 *	 @异常：
	 **/
	public static void replaceFileSuffixName(String filePath, String toSuffixName) throws Exception{
		File file = new File(filePath);
		if(!file.exists()){
			log.error("文件【" + filePath + "】不存在!");
			throw new Exception();
		}else if(file.isDirectory()){
			for(File childFile : file.listFiles()){
				replaceFileSuffixName(childFile.getAbsolutePath(), toSuffixName);
			}
		}else{
			String fileSuffixName = filePath.substring(filePath.lastIndexOf("."));
			String toFilePath = filePath.replaceFirst(fileSuffixName, toSuffixName);
			File fileOfModified = new File(toFilePath);
			boolean isFileRenameSuccess = file.renameTo(fileOfModified);
			if(!isFileRenameSuccess){
				log.error("文件名【" + filePath + "】修改失败!");
				throw new Exception();
			}
		}
	}
	/**
	 *	 @生成时间： 2014-1-10 下午04:54:39
	 *	 @方法说明： 修改文件名,按照数字排列文件名,例如有四个文件的话,就是1.suffixname,2.suffixname,3.suffixname,4.suffixname
	 *				注意: 如果修改文件夹下的文件,修改了3个文件,第四个文件失败的话,前3个文件已经修改,没有做到事物控制
	 *	 @参数：	 filePath:文件路径;replaceSuffixName:文件修改后的后缀名,例如修改后的都是.jpg的文件
	 *	 @throws Exception 
	 *	 @返回值：
	 *	 @异常：
	 **/
	public static void replaceFileName(String filePath) throws Exception{
		File file = new File(filePath);
		if(!file.exists()){
			log.error("文件【" + filePath + "】不存在!");
			throw new Exception();
		}else if(file.isDirectory()){
			for(File childFile : file.listFiles()){
				replaceFileName(childFile.getAbsolutePath());
			}
		}else{
			String fileName = file.getName();
			String fileSuffixName = fileName.substring(0, fileName.lastIndexOf("."));
			
			String toFilePath = filePath.replaceFirst(fileSuffixName, ++fileNumber + "");
			File fileOfModified = new File(toFilePath);
			boolean isFileRenameSuccess = file.renameTo(fileOfModified);
			if(!isFileRenameSuccess){
				log.error("文件名【" + filePath + "】修改失败!");
				throw new Exception();
			}
		}
	}
	public static void main(String[] args) {
//		//测试文件名修改
//		String filePath = "D:\\local\\驾驶人计时培训\\图片\\123.txt";
//		String toSuffixName = ".jpg";
//		try {
//			replaceFileSuffixName(filePath, toSuffixName);
//			log.info("文件【" + filePath + "】重命名为【" + toSuffixName + "】成功!");
//		} catch (Exception e) {
//			log.error("文件【" + filePath + "】重命名为【" + toSuffixName + "】失败!", e);
//		}
//		
//		//测试文件夹下所有文件名修改
		String fileDirPath = "D:\\local\\驾驶人计时培训\\图片";
//		try {
//			replaceFileSuffixName(fileDirPath, toSuffixName);
//			log.info("文件夹【" + fileDirPath + "】下所有文件重命名为【" + toSuffixName + "】成功!");
//		} catch (Exception e) {
//			log.error("文件夹【" + fileDirPath + "】下所有文件重命名为【" + toSuffixName + "】失败!", e);
//		}
		
		//测试文件夹下所有文件名修改
		try {
			replaceFileName(fileDirPath);
			log.info("文件夹【" + fileDirPath + "】下所有文件重命名成功!");
		} catch (Exception e) {
			log.error("文件夹【" + fileDirPath + "】下所有文件重命名失败!", e);
		}
	}
}
