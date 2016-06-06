package com.yyy.dailycode.wyp.parasehtml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import com.yyy.dailycode.wyp.parasehtml.loadproperties.HttpConfig;
import com.yyy.util.DateFomateTools;

/**
 *   @类名： GetFreeTicket
 *   @描述： 抓取页面内容,依赖的jar:jsoup-1.7.3.jar,log4j.jar,slf4j-api-1.5.8.jar,slf4j-log4j12-1.5.8.jar
 *   @作者： 杨文胜
 *   @生成时间： 2014-1-6 上午11:17:16
 *   @修改人：
 *   @修改时间：  
 **/
public class GetFreeTicket implements Runnable{
	private static final Logger log = Logger.getLogger(GetFreeTicket.class); 
	private static StringBuffer loginUrl = new StringBuffer(
			"http://114.242.121.99/login.aspx?txtUserName=371327198803142238&txtPassword=0314&BtnLogin=%E7%99%BB++%E5%BD%95&rcode=");
	private static int byteSum = 0;
	private static int byteRead = 0;
	private static final String FILE_PATH = System.getProperty("user.dir") + "/local.jsp";
	private static final String LOGIN_FILE_PATH = System.getProperty("user.dir") + "/login.jsp";
	private static final String SOUND_FILE_PATH = "/resources/soundfile/123.mid";
	private static final String URL_ADDRESS = HttpConfig.URL_ADDRESS;
	private static final String LOGIN_ADDRESS = HttpConfig.LOGIN_ADDRESS;
	private static String cookieId = null;
	private static boolean isFree = false;
	private static InputStream in = null;
	private static final String TABLE_ID = "tblMain";
	private static final String ATTRIBUTE = "yyrq";
	private static final String KEEP_COOKIE = "Set-Cookie";
	private static final String COOKIE = "Cookie";
	private static final String SPLIT_SEMICOLON = ";";
	private static final String __VIEWSTATE = "__VIEWSTATE";
	private static final String __EVENTVALIDATION = "__EVENTVALIDATION";
	private static final String TXTIMGCODE = "txtIMGCode";
	private static final String ENCODE_TYPE = "utf-8";
	private static final String SATURDAY_DATE = DateFomateTools.getSaturDayDateStr();
	private static final String CONTAIN_NUM = ".*\\d.*";
	private static final String SPLIT_AND = "&";
	private static final String SPLIT_EQUALS = "=";
	
	/**
	 *   @生成时间： 2014-1-6 上午11:17:59
	 *   @方法说明： 获取文件资源
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void getLoginFileResource(){
		try {
			getFileResource(URL_ADDRESS, LOGIN_FILE_PATH);
			org.jsoup.nodes.Document doc = Jsoup.parse(new File(LOGIN_FILE_PATH), null);
			org.jsoup.nodes.Element state = doc.getElementById(__VIEWSTATE);
			org.jsoup.nodes.Element validation = doc.getElementById(__EVENTVALIDATION);
			String stateValue = URLEncoder.encode(state.text(), ENCODE_TYPE);
			String validationValue = URLEncoder.encode(validation.text(), ENCODE_TYPE);
			log.info("__VIEWSTATE的值:" + stateValue);
			log.info("__EVENTVALIDATION的值:" + validationValue);
			loginUrl.append(SPLIT_AND).append(__VIEWSTATE).append(SPLIT_EQUALS).append(stateValue);
			loginUrl.append(SPLIT_AND).append(__EVENTVALIDATION).append(SPLIT_EQUALS).append(validationValue);
			loginUrl.append(SPLIT_AND).append(TXTIMGCODE).append(SPLIT_EQUALS).append(validationValue);
		} catch (Exception e) {
			log.error("URL创建失败", e);
		}
	}
	/**
	 *   @生成时间： 2014-1-6 上午11:17:59
	 *   @方法说明： 获取文件资源
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void getFileResource(String address, String filePath){
		URLConnection conn = null;
		FileOutputStream fos = null;
		try {
			URL url = new URL(address);
			try{
				conn = url.openConnection();
				conn.setRequestProperty(COOKIE, cookieId);
				in = conn.getInputStream();
				fos = new FileOutputStream(filePath);
				byte[] buffer = new byte[1024];
				while((byteRead = in.read(buffer)) != -1){
					byteSum = byteSum + byteRead;
					fos.write(buffer, 0, byteRead);
				}
			}catch (Exception e) {
				log.error("文件保存失败", e);
			}finally{
				if(null != fos)
					fos.close();
//				if(null != in)
//					in.close();
			}
			log.info("获取文件成功!");
		} catch (Exception e) {
			log.error("URL创建失败", e);
		}
	}
	/**
	 *   @生成时间： 2014-1-6 下午03:40:58
	 *   @方法说明： 获取登录的sessionId 
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void login(){
		URLConnection conn = null;
		try {
			URL url = new URL(LOGIN_ADDRESS);
			try{
				conn = url.openConnection();
				String sessionValue = conn.getHeaderField(KEEP_COOKIE);
				String[] sessionId = sessionValue.split(SPLIT_SEMICOLON);
				cookieId = sessionId[0];
			}catch (Exception e) {
				log.error("获取session失败", e);
			}
		} catch (Exception e) {
			log.error("URL创建失败", e);
		}
	}
	/**
	 *   @生成时间： 2014-1-6 下午04:49:05
	 *   @方法说明： 遍历获取节点
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void iteratorFree(){
		try {
			org.jsoup.nodes.Document doc = Jsoup.parse(new File(FILE_PATH), null);
			org.jsoup.nodes.Element root = doc.getElementById(TABLE_ID);
			Elements elements = root.getElementsByAttributeValue(ATTRIBUTE, SATURDAY_DATE);
			String text = elements.text();
			isFree = text.matches(CONTAIN_NUM);
			log.info("获取根节点名称:" + text);
		} catch (Exception e) {
			log.error("xml读取错误！", e);
		}
	}
	public static void play(){
		try{
//			long time = System.currentTimeMillis();
			InputStream is = GetFreeTicket.class.getResourceAsStream(SOUND_FILE_PATH);
			AudioStream as = new AudioStream(is);
			AudioPlayer.player.start(as);
//			System.out.println(System.currentTimeMillis() - time);
//			long time1 = System.currentTimeMillis();
//			File file = new File(fileName);
//			URL url = file.toURL();
//			AudioClip ac = Applet.newAudioClip(url);
//			ac.play();
//			System.out.println(System.currentTimeMillis() - time1);
		}catch (Exception e) {
			log.error("文件失败", e);
		}
	}

	public static void main(String[] args) {
//		testMultTime();
		Thread t = new Thread(new GetFreeTicket());
		t.start();
	}
	public void run() {
		login();
		while(!isFree){
			getFileResource(URL_ADDRESS, FILE_PATH);
			isFree = true;
			iteratorFree();
			try {
				if(!isFree){
					Thread.sleep(1000);
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		play();
	}
}
