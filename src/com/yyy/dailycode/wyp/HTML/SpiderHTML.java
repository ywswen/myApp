package com.yyy.dailycode.wyp.HTML;
/**
 * @author win young

 *
 * @创建时间:2012-7-25 上午09:58:51
 *
 * @version 1
 *
 * @类说明：
 * 版权所有，翻版不究，但是在修改本程序的时候务必加上这些注释。谢谢 
 * 仅用于学习交流之用
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.yyy.dailycode.wyp.utils.BlogReturnStatus;
import com.yyy.dailycode.wyp.utils.Pair;
public class SpiderHTML {
	// 定义一个logger
	//static Logger logger = Logger.getLogger(SpiderHTML.class.getName());
	//用户，用来生成保存爬取到文件的文件夹
	public static String userName = "yws";
	//保存路径
	public static String pathText = "c:";
	public SpiderHTML() {
		// 加载log4j.properties配置文件
		//PropertyConfigurator.configure("log4j.properties");
	}
	
	/**
	 * 抓取页面返回的几个状态
	 * */
	/**
	 *网页抓取方法
	 * 
	 * @param urlString
	 *            要抓取的url地址
	 * @param charset
	 *            网页编码方式
	 * @param timeout
	 *            超时时间
	 * @param type
	 * 			  获取网页的格式 0 网页 1 图片
	 * @param userName
	 *            博客用户的名称
	 * @return 抓取的网页内容和读取网页的返回状态
	 * @throws IOException
	 *             抓取异常
	 */
	public static Pair<String, BlogReturnStatus> GetWebContent(String urlString, final String charset,
			int timeout, int type) throws IOException {
		if (urlString == null || urlString.length() == 0) {
			return null;
		}

		//System.out.println("***********************" + urlString);
		//String imgAbsolutePath = null;
		BlogReturnStatus blogReturnStatus = null;
		urlString = (urlString.startsWith("http://") || urlString
				.startsWith("https://")) ? urlString : ("http://" + urlString)
				.intern();
		URL url = new URL(urlString);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		// 只接受text/html类型，当然也可以接受图片,pdf,*/*任意，就是tomcat/conf/web里面定义那些
		conn.setRequestProperty("Accept", "text/html");
		// 设置超时为timeout毫秒
		conn.setConnectTimeout(timeout);
		try {
			// 如果失败
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				//logger.warn("Connection failed! URL: [" + urlString + "]");
				blogReturnStatus = BlogReturnStatus.TIME_OUT;
				return new Pair<String, BlogReturnStatus>(null, blogReturnStatus);
			}
		} catch (IOException e) {
			// e.printStackTrace();
			//logger.error(e.toString() + " URL: [" + urlString + "]");
			blogReturnStatus = BlogReturnStatus.FAILURE;
			return new Pair<String, BlogReturnStatus>(null, blogReturnStatus);
		}
		//logger.info("Start reading [" + urlString + "]");
		// 打开输入流
		InputStream input = conn.getInputStream();
		// 设置流读取函数，并设置字符集为charset
		BufferedReader reader = new BufferedReader(new InputStreamReader(input,
				charset));

		String line = null;
		// 用来存储读取到的网页
		StringBuffer sb = new StringBuffer();
		
		switch(type){
		case 0:
			// 直到读去网页源码结束
			while ((line = reader.readLine()) != null) {
				sb.append(line).append(System.getProperty("line.separator"));
			}
			break;
		case 1:
			sb.append(processImg(input, urlString));
			break;
		default:
			System.err.println("Unsupport File Type!");
			//logger.error("Unsupport File Type!");
			return null;
		}
		
		
		
		//logger.info("End reading [" + urlString + "]");
		// 关闭读对象
		if (reader != null) {
			reader.close();
		}
		if (conn != null) {
			conn.disconnect();
		}
		blogReturnStatus = BlogReturnStatus.OK;
		//System.out.println(sb);
		return new Pair<String, BlogReturnStatus>(sb.toString(), blogReturnStatus);

	}
	
	/**
	 * @param str 获取到的网页文件
	 * 
	 *  本函数用来保存图片到对应用户的img文件夹下面
	 */
	private static String  processImg(InputStream is, String urlString){
		String dirs = pathText + File.separator + userName + File.separator + "img" + File.separator;
		File file = new File(dirs);
		//目录不存在，创建它
		if(!file.exists()){
			file.mkdirs();
		}
		
		//得到图片的名称和格式
		String imgNameAndType = urlString.substring(urlString.lastIndexOf("/") + 1);
		
		file = new File(dirs + imgNameAndType);
		//文件不存在，则创建
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//logger.error("Create " + imgNameAndType + "Failure!");
				e.printStackTrace();
				return dirs + imgNameAndType;
			}
			
			//logger.info("Starting Save: [" + imgNameAndType + "]");
			OutputStream os = null;
			try {
				os = new FileOutputStream(file);
				int bytes = -1;
				while((bytes = is.read()) != -1){
					os.write(bytes);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					is.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//logger.info("End Save: [" + imgNameAndType + "]");
		}else{
			//logger.info("The file [ "+ imgNameAndType +"] is exist!");
		}
		
		
		return dirs + imgNameAndType;
	}
	/**
	 * 类测试函数
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("12");
//		Pair<String, BlogReturnStatus>pair  = GetWebContent("http://avatar.csdn.net/A/C/C/3_w397090770.jpg", "utf-8", 50000, 1);
		Pair<String, BlogReturnStatus>pair  = GetWebContent("http://www.baidu.com", "gb2312", 50000, 0);
		SaveAsDOC doc =  new SaveAsDOC();
		File file = new File("C:\\yws\\img");
		doc.getDoc(file, pair.name, "getDoc");
		System.out.println(pair.getSecond());
	}
}