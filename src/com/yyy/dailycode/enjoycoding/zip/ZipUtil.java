package com.yyy.dailycode.enjoycoding.zip;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import com.yyy.util.UUIDFactoryUtil;

/**
 *   @类名： ZipUtil
 *   @描述： Zip工具类
 *   @作者： 杨文胜
 *   @生成时间： 2014-8-13 下午02:52:09
 *   @修改人：
 *   @修改时间：  
 **/
public class ZipUtil {
	private static final Logger _log = Logger.getLogger(ZipUtil.class);
	/**
	 * @属性说明：斜杠
	 **/
	private static final String SLASH = "/";
	/**
	 * @生成时间： 2013-7-8 上午11:05:34
	 * @方法说明： 获取当前日期
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	public static String getDate() {
		Date d = Calendar.getInstance().getTime(); // 获取当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMHH"); // 设置日期输出格式
		return sdf.format(d);
	}

	/**
	 * @生成时间： 2012-04-01 上午11:05:34
	 * @方法说明： 将byte[]流存为本地文件文件
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	public static void saveBytesToLocal(byte[] bytes, String fileSavePath,
			String fileSaveName, String fileSaveType) {
		StringBuffer path = new StringBuffer(fileSavePath);
		path.append(fileSaveName);
		path.append(fileSaveType);
		try {
			FileOutputStream fos = new FileOutputStream(path.toString());
			fos.write(bytes, 0, bytes.length);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2012-04-01 by 洪巍 图片转为byte[]流
	 * 
	 * @param imagePath
	 *            图像地址
	 * @return
	 */
	public static byte[] file2Bytes(String imagePath) {
		File file = new File(imagePath);
		InputStream is;
		byte[] bytes = null;
		try {
			is = new FileInputStream(file);
			long length = file.length();
			bytes = new byte[(int) length];
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	/**
	 * @生成时间： 2013-8-15 下午05:11:21
	 * @方法说明：将file转byte[]
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	public static byte[] file2Bytes(File file) {
		InputStream is = null;
		byte[] retBy = null;
		try {
			is = new FileInputStream(file);
			long length = file.length();
			retBy = new byte[(int) length];
			int offset = 0;
			int numRead = 0;
			while (offset < retBy.length
					&& (numRead = is.read(retBy, offset, retBy.length - offset)) >= 0) {
				offset += numRead;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			safeCloseInputStream(is);
		}
		return retBy;
	}
	
	/**
	 *   @生成时间： 2014-8-13 下午02:51:39
	 *   @方法说明： 
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	private static void safeCloseOutputStream(OutputStream out){
		if(null != out){
			try {
				out.close();
			} catch (IOException e) {
				_log.error("关闭文件流失败！", e);
			}
		}
	}

	/**
	 *   @生成时间： 2014-8-13 下午02:51:39
	 *   @方法说明： 
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	private static void safeCloseInputStream(InputStream is){
		if(null != is){
			try {
				is.close();
			} catch (IOException e) {
				_log.error("关闭文件流失败！", e);
			}
		}
	}
	/**
	 * @生成时间： 2013-7-11 上午10:03:57
	 * @方法说明： 获取随机ID
	 * @参数：
	 * @返回值： String
	 * @异常：
	 */
	public static String getRandomId() {
		return (new SimpleDateFormat("yyyyMMddHH").format(Calendar
				.getInstance().getTime()) + UUID.randomUUID().toString()
				.substring(0, 8));
	}

	/**
	 * @生成时间： 2013-7-17 下午15:03:57
	 * @方法说明： 打印JVM内存信息mb
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	public static void runTimeLog_Mb() {
		_log.info("* 最大可用内存：" + (Runtime.getRuntime().maxMemory() >> 20));
		_log.info("* 当前JVM占用的内存总数： "
				+ (Runtime.getRuntime().totalMemory() >> 20));
		_log.info("* 当前JVM空闲内存：" + (Runtime.getRuntime().freeMemory() >> 20));
	}


	/**
	 * @生成时间： 2013-7-31 上午10:34:17
	 * @方法说明： 测试方法，保存对象到本地文本
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	public static void saveTextLogToLocal(String fileName, String savePath,
			Object obj) {
		StringBuffer filePath = new StringBuffer(savePath);
		filePath.append(fileName);
		filePath.append(".txt");
		try {
			FileWriter fw = new FileWriter(filePath.toString());
			fw.write(obj.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @将文本写入文件
	 * @param textStr
	 * @param fileName
	 * @param filePath
	 */
	public static void writeTextToLocal(String textStr, String filePath,
			String fileName) {
		_log.debug("--> run writeTextToLocal");
		File file = new File(filePath + fileName);
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.write(textStr);
			pw.flush();
		} catch (Exception e) {
			_log.error("--> exception in writeTextToLocal", e);
		} finally {
			safeCloseWriter(fw);
			safeCloseWriter(bw);
			safeCloseWriter(pw);
		}
	}
	
	/**
	 *   @生成时间： Aug 13, 2014 2:39:28 PM
	 *   @方法说明： 关闭写文件
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	private static void safeCloseWriter(Writer w){
		if(null != w){
			try {
				w.close();
			} catch (IOException e) {
				_log.error("关闭写文件失败！", e);
			}
		}
	}
	/**
	 * @生成时间： 将文本写入文件
	 * @方法说明：
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	public static void writeTextToLocal(String textStr, File file) {
		_log.debug("--> run writeTextToLocal");
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.write(textStr);
			pw.flush();
		} catch (Exception e) {
			_log.error("--> exception in writeTextToLocal", e);
		} finally {
			safeCloseWriter(fw);
			safeCloseWriter(bw);
			safeCloseWriter(pw);
		}
	}

	/**
	 * @生成时间： 2013-8-16 下午03:23:31
	 * @方法说明： byArray2InputStreamReader
	 * @参数：byte[]
	 * @返回值：InputStreamReader
	 * @异常：
	 */
	public static InputStreamReader byArray2InputStreamReader(byte[] byteArray) {
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		InputStreamReader isr = new InputStreamReader(bais);
		return isr;
	}
	
	/**
	 * @生成时间： 2014-8-13 17:29:26
	 * @方法说明： 解压文件,假如有多级目录，将多级目录下的文件按照压缩目录解压到文件目录
	 * @参数：     zipFile 压缩文件， savePath解压路径
	 * @返回值：   返回解压后的文件夹的文件全路径,不包括空的文件夹路径
	 * @异常：
	 */
	@SuppressWarnings("unchecked")
	public static List<String> unZipSameDirectory(File zipFile, String savePath) {
		int buffer = 2048;
		int count = -1;
		InputStream is = null;
		BufferedOutputStream bos = null;
		List<String> fileList = new ArrayList<String>();
		try {
			byte[] b = new byte[buffer];
			ZipFile zip = new ZipFile(zipFile);
			Enumeration<ZipEntry> enunm = zip.getEntries();
			while (enunm.hasMoreElements()) {
				ZipEntry zipEntry = enunm.nextElement();
				if(zipEntry.isDirectory()){
					String temp = zipEntry.getName();
					File fileDir = new File(savePath + temp);
					if (!fileDir.exists()) {
						fileDir.mkdir();
					}
				}
				if (zipEntry.getSize() > 0) {
					is = zip.getInputStream(zipEntry);
					String temp = zipEntry.getName();
					String[] fileDirs = temp.split(SLASH);
					String savePathEveryDir = savePath;
					for (int i = 0; i < fileDirs.length - 1; i++) {
						savePathEveryDir += fileDirs[i];
						File fileDir = new File(savePathEveryDir);
						if (!fileDir.exists()) {
							fileDir.mkdir();
							savePathEveryDir += File.separator;
						}else{
							savePathEveryDir += File.separator;
						}
					}
					int index = temp.lastIndexOf(SLASH);
					if (temp.lastIndexOf(SLASH) > -1)
						temp = temp.substring(index + 1);
					String childFileName = savePathEveryDir + temp;
					File newFile = new File(childFileName);
					newFile.createNewFile();
					FileOutputStream fos = new FileOutputStream(newFile);
					bos = new BufferedOutputStream(fos, buffer);
					while ((count = is.read(b, 0, buffer)) != -1) {
						bos.write(b, 0, count);
					}
					bos.flush();
					bos.close();
					fileList.add(childFileName);
				}
			}
		} catch (Exception e) {
			_log.error("解压文件失败！", e);
		} finally {
			safeCloseOutputStream(bos);
			safeCloseInputStream(is);
		}
		return fileList;
	}

	/**
	 * @生成时间： 2014-8-13 17:29:26
	 * @方法说明： 解压文件,假如有多级目录，将多级目录下的文件都解压到指定目录下
	 * @参数：     zipFile 压缩文件， savePath解压路径
	 * @返回值：   返回解压后的文件夹的文件全路径的
	 * @异常：
	 */
	@SuppressWarnings("unchecked")
	public static List<String> unZip(File zipFile, String savePath) {
		int buffer = 2048;
		int count = -1;
		InputStream is = null;
		BufferedOutputStream bos = null;
		List<String> fileList = new ArrayList<String>();
		try {
			byte[] b = new byte[buffer];
			ZipFile zip = new ZipFile(zipFile);
			Enumeration<ZipEntry> enunm = zip.getEntries();
			while (enunm.hasMoreElements()) {
				ZipEntry zipEntry = enunm.nextElement();
				if (zipEntry.isDirectory()) {
					continue;
				}
				if (zipEntry.getSize() > 0) {
					is = zip.getInputStream(zipEntry);
					String temp = zipEntry.getName();
					temp = UUIDFactoryUtil.generateUUID() + temp;
					int index = temp.lastIndexOf(SLASH);
					if (temp.lastIndexOf(SLASH) > -1)
						temp = UUIDFactoryUtil.generateUUID() + temp.substring(index + 1);
					String childFileName = savePath + temp;
					File newFile = new File(childFileName);
					newFile.createNewFile();
					FileOutputStream fos = new FileOutputStream(newFile);
					bos = new BufferedOutputStream(fos, buffer);
					while ((count = is.read(b, 0, buffer)) != -1) {
						bos.write(b, 0, count);
					}
					bos.flush();
					bos.close();
					fileList.add(childFileName);
				}
			}
		} catch (Exception e) {
			_log.error("解压文件失败！", e);
		} finally {
			safeCloseOutputStream(bos);
			safeCloseInputStream(is);
		}
		return fileList;
	}

	/**
	 * @生成时间： 2013-9-2 上午10:35:50
	 * @方法说明： 获取目录下指定类型的文件集合
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	public static List<String> getFileList(String dir, String fileType) {
		List<String> fileList = new ArrayList<String>();
		File file = new File(dir);
		File[] files = file.listFiles();
		if (file.isDirectory()) {
			for (File tempFile : files) {
				if (tempFile.getAbsolutePath().endsWith(fileType.toLowerCase())
						|| tempFile.getAbsolutePath().endsWith(
								fileType.toUpperCase()))
					fileList.add(tempFile.getAbsolutePath());
			}
		}
		return fileList;
	}

	/**
	 * @生成时间： 2013-9-5 下午02:02:47
	 * @方法说明： 获取某目录下所有文件的集合
	 * @参数：
	 * @返回值：
	 * @异常：
	 */
	public static List<String> getAllFileList(String dir) {
		List<String> fileList = new ArrayList<String>();
		File file = new File(dir);
		File[] files = file.listFiles();
		if (file.isDirectory()) {
			for (File tempFile : files) {
				fileList.add(tempFile.getAbsolutePath());
			}
		}
		return fileList;
	}

	/**
	 * @生成时间： 2013-9-5 下午02:58:26
	 * @方法说明： 删除目录
	 * @参数：folderPath 目录
	 * @返回值：
	 * @异常：
	 */
	public static void delAllFile(String folderPath) {
		File file = new File(folderPath);
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] fileList = (File[]) file.listFiles();
				for (int i = 0; i < fileList.length; i++) {
					String filePath = fileList[i].getPath();
					delAllFile(filePath);
				}
			}
			file.delete();
		}
	}

	public static void main(String[] args) {
		System.out.println(File.separator);
		long startTime = System.currentTimeMillis();
		String zipFilePath = "d:\\ExcelRead.zip";
		File zipFile = new File(zipFilePath);
		String savePath = "d:\\aa\\";
		System.out.println(ZipUtil.unZipSameDirectory(zipFile, savePath));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
