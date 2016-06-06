package com.yyy.dailycode.wyp.imgvalidatecode;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class ImagePreProcessAppointment {

	public static int isWhite(int colorInt) {
		Color color = new Color(colorInt);
		if (color.getRed() + color.getGreen() + color.getBlue() > 306) {
			return 1;
		}
		return 0;
	}

	public static int isBlack(int colorInt) {
		Color color = new Color(colorInt);
		if (color.getRed() + color.getGreen() + color.getBlue() <= 306) {
			return 1;
		}
		return 0;
	}

	public static BufferedImage removeBackgroud(String picFile)
			throws Exception {
		BufferedImage img = ImageIO.read(new File(picFile));
		int width = img.getWidth();
		int height = img.getHeight();
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				if (isWhite(img.getRGB(x, y)) == 1) {
					img.setRGB(x, y, Color.WHITE.getRGB());
				} else {
					img.setRGB(x, y, Color.BLACK.getRGB());
				}
			}
		}
		ImageIO.write(img, "JPG", new File("yyy//"+picFile+".jpg"));
		return img;
	}

	public static List<BufferedImage> splitImage(BufferedImage img, Map<String, BufferedImage> map)
			throws Exception {
		List<BufferedImage> subImgs = new ArrayList<BufferedImage>();
		ImageIO.write(img.getSubimage(5, 6, 14, 15), "JPG", new File("yyy//B.jpg"));
		ImageIO.write(img.getSubimage(20, 6, 11, 15), "JPG", new File("yyy//6.jpg"));
		ImageIO.write(img.getSubimage(32, 6, 15, 15), "JPG", new File("yyy//H.jpg"));
		ImageIO.write(img.getSubimage(48, 6, 20, 15), "JPG", new File("yyy//M.jpg"));
		subImgs.add(img.getSubimage(5, 6, 14, 15));
		subImgs.add(img.getSubimage(20, 6, 11, 15));
		subImgs.add(img.getSubimage(32, 6, 15, 15));
		subImgs.add(img.getSubimage(48, 6, 20, 15));
//		subImgs.add(img.getSubimage(10, 6, 8, 10));
//		subImgs.add(img.getSubimage(19, 6, 8, 10));
//		subImgs.add(img.getSubimage(28, 6, 8, 10));
//		subImgs.add(img.getSubimage(37, 6, 8, 10));
		return subImgs;
	}

	public static Map<String, BufferedImage> loadTrainData() throws Exception {
		Map<String, BufferedImage> map = new TreeMap<String, BufferedImage>();
		File dir = new File("train2");
		File[] files = dir.listFiles();
		for (File file : files) {
			map.put( file.getName().charAt(0) + "", ImageIO.read(file));
		}
		return map;
	}

	public static String getSingleCharOcr(BufferedImage img,
			Map<String, BufferedImage> map, int x3) {
		String result = "";
		int width = img.getWidth();
		int height = img.getHeight();
		int min = width * height;
		for (String key : map.keySet()) {
//			System.out.println(key);
			key = WordInfo.wordSort.get(key);
//			int intArray = WordInfo.wordPixel.get(key)[0];
//			if(x3 != intArray){
//				continue;
//			}
//			System.out.println(key);
			BufferedImage bi = map.get(key);
			int count = 0;
			Label1: for (int x = 0; x < width; ++x) {
				for (int y = 0; y < height; ++y) {
					try{
						if (isWhite(img.getRGB(x, y)) != isWhite(bi.getRGB(x, y))) {
							count++;
							if (count >= min)
								break Label1;
						}
					}catch (Exception e) {
						break Label1;
					}
				}
			}
//			System.out.println("key" + key + " count:" + count + " min" + min);
			if (count < min) {
				min = count;
				result = key;
			}
		}
		return result;
	}

	public static String getAllOcr(String file) throws Exception {
		BufferedImage img = removeBackgroud(file);
		Map<String, BufferedImage> map = loadTrainData();
		String result = "";
		String character = "0";
		int x1 = 5;
		int x2 = 6;
		int x3 = 0;
		int x4 = 0;
		int x5 = 1;
		for(int i=0;i<4;i++){
			int offSet = WordInfo.wordPixel.get(character)[0];
			x1 = offSet + x1 + x5;
			Label3:for(String key : map.keySet()){
				key = WordInfo.wordSort.get(key);
				character = key;
				Integer[] intArray = WordInfo.wordPixel.get(key);
				x3 = intArray[0];
				x4 = intArray[1];
//				System.out.println(x1 +","+ x2 +","+ x3 +","+ x4);
				BufferedImage bi;
				try{
					bi = img.getSubimage(x1, x2, x3, x4);
				}catch (Exception e) {
					continue;
				}
				String word = getSingleCharOcr(bi, map, x3);
//				System.out.println("word" + word);
				if(!"".equals(word)){
					ImageIO.write(img.getSubimage(x1, x2, x3, x4), "JPG", new File("yyy//test//" + i + ".jpg"));
					System.out.println(x1 +","+ x2 +","+ x3 +","+ x4);
					character = word;
					result += word;
					break Label3;
				}
			}
		}
//		List<BufferedImage> listImg = splitImage(img, map);
//		for (BufferedImage bi : listImg) {
//			result += getSingleCharOcr(bi, map);
//		}
		ImageIO.write(img, "JPG", new File("result//"+result+".jpg"));
		return result;
	}

	public static void downloadImage() {
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(
				"http://www.puke888.com/authimg.php");
		for (int i = 0; i < 30; i++) {
			try {
				// 执行getMethod
				int statusCode = httpClient.executeMethod(getMethod);
				if (statusCode != HttpStatus.SC_OK) {
					System.err.println("Method failed: "
							+ getMethod.getStatusLine());
				}
				// 读取内容
				String picName = "img//" + i + ".jpg";
				InputStream inputStream = getMethod.getResponseBodyAsStream();
				OutputStream outStream = new FileOutputStream(picName);
				IOUtils.copy(inputStream, outStream);
				outStream.close();
				System.out.println("OK!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 释放连接
				getMethod.releaseConnection();
			}
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		for (int i = 30; i < 31; ++i) {
			String text = getAllOcr("img//" + i + ".gif");
			System.out.println(i + ".jpg = " + text);
		}
	}
}
