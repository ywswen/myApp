package com.yyy.dailycode.wyp.imgvalidatecode;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileOperte {
	public static int isWhite(int colorInt){
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
	public static void fileWhite(String file) throws IOException{
		BufferedImage img = ImageIO.read(new File(file));
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println(Color.GREEN.getRGB());
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
//				if (isWhite(img.getRGB(i, j)) == 1) {
					img.setRGB(i, j, Color.RED.getRGB());
//				} else {
//					img.setRGB(i, j, Color.BLACK.getRGB());
//				}
			}
		}
		ImageIO.write(img, "JPG", new File("D:\\"+111+".jpg"));
	}
	public static void main(String[] args) {
		String file = "D:\\1.gif";
		try {
			fileWhite(file);
//			fileWhite("D:\\111.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("....");
	}
	
}
