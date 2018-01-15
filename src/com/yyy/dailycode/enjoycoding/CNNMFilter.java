package com.yyy.dailycode.enjoycoding;

import java.util.HashMap;
import java.util.Map;

public class CNNMFilter {
	private static final Character[] CN_NUMERIC = { '一', '二', '三', '四', '五', '六', '七', '八', '九', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖', '十',
			'百', '千', '拾', '佰', '仟', '万', '亿', '○', 'Ｏ', '零' };

	private static Map<Character, Double> cnNumeric = null;
	static {
		cnNumeric = new HashMap<Character, Double>();
		for (int j = 0; j < 9; j++)
			cnNumeric.put(CN_NUMERIC[j], new Double(j+1));
		for (int j = 9; j < 18; j++)
			cnNumeric.put(CN_NUMERIC[j], new Double(j - 8));
		cnNumeric.put('分', 0.01);
		cnNumeric.put('角', 0.1);
		cnNumeric.put('元', 1.0);
		cnNumeric.put('两', 2.00);
		cnNumeric.put('十', 10.00);
		cnNumeric.put('拾', 10.00);
		cnNumeric.put('百', 100.00);
		cnNumeric.put('佰', 100.00);
		cnNumeric.put('千', 1000.00);
		cnNumeric.put('仟', 1000.00);
		cnNumeric.put('万', 10000.00);
		cnNumeric.put('亿', 100000000.00);
	}

	public static double isCNNumeric(char c) {
		Double i = cnNumeric.get(c);
		if (i == null)
			return 0;
		return i.doubleValue();
	}

	public static double cnNumericToArabic(String cnn, boolean flag) {

		cnn = cnn.trim();
		if (cnn.length() == 1)
			return isCNNumeric(cnn.charAt(0));

		if (flag)
			cnn = cnn.replace("萬", "万").replace('仟', '千').replace('佰', '百').replace('拾', '十').replace('零', ' ');
		int yi = -1, wan = -1, qian = -1, bai = -1, shi = -1, yuan = -1, jiao = -1, fen = -1;
		double val = 0;
		yi = cnn.lastIndexOf('亿');
		if (yi > -1) {
			val += cnNumericToArabic(cnn.substring(0, yi), false) * 100000000;
			if (yi < cnn.length() - 1)
				cnn = cnn.substring(yi + 1, cnn.length());
			else
				cnn = "";

			if (cnn.length() == 1) {
				double arbic = isCNNumeric(cnn.charAt(0));
				if (arbic <= 10)
					val += arbic * 10000000;
				cnn = "";
			}
		}

		wan = cnn.lastIndexOf('万');
		if (wan > -1) {
			val += cnNumericToArabic(cnn.substring(0, wan), false) * 10000;
			if (wan < cnn.length() - 1)
				cnn = cnn.substring(wan + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				double arbic = isCNNumeric(cnn.charAt(0));
				if (arbic <= 10)
					val += arbic * 1000;
				cnn = "";
			}
		}

		qian = cnn.lastIndexOf('千');
		if (qian > -1) {
			val += cnNumericToArabic(cnn.substring(0, qian), false) * 1000;
			if (qian < cnn.length() - 1)
				cnn = cnn.substring(qian + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				double arbic = isCNNumeric(cnn.charAt(0));
				if (arbic <= 10)
					val += arbic * 100;
				cnn = "";
			}
		}

		bai = cnn.lastIndexOf('百');
		if (bai > -1) {
			val += cnNumericToArabic(cnn.substring(0, bai), false) * 100;
			if (bai < cnn.length() - 1)
				cnn = cnn.substring(bai + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				double arbic = isCNNumeric(cnn.charAt(0));
				if (arbic <= 10)
					val += arbic * 10;
				cnn = "";
			}
		}
		
		shi = cnn.lastIndexOf('十');
		if (shi > -1) {
			val += cnNumericToArabic(cnn.substring(0, shi), false) * 10;
			if (shi < cnn.length() - 1)
				cnn = cnn.substring(shi + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				double arbic = isCNNumeric(cnn.charAt(0));
				if (arbic <= 10)
					val += arbic * 10;
				cnn = "";
			}
		}
		
		yuan = cnn.lastIndexOf('元');
		if (yuan > -1) {
			val += cnNumericToArabic(cnn.substring(0, yuan), false) * 1;
			if (yuan < cnn.length() - 1)
				cnn = cnn.substring(yuan + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				double arbic = isCNNumeric(cnn.charAt(0));
				if (arbic <= 10)
					val += arbic * 1;
				cnn = "";
			}
		}
		
		jiao = cnn.lastIndexOf('角');
		if (jiao > -1) {
			val += cnNumericToArabic(cnn.substring(0, jiao), false) * 0.1;
			if (jiao < cnn.length() - 1)
				cnn = cnn.substring(jiao + 1, cnn.length());
			else
				cnn = "";
			if (cnn.length() == 1) {
				double arbic = isCNNumeric(cnn.charAt(0));
				if (arbic <= 10)
					val += arbic * 0.1;
				cnn = "";
			}
		}

		fen = cnn.lastIndexOf('分');
		if (fen > -1) {
			if (fen == 0)
				val += 1 * 10;
			else
				val += cnNumericToArabic(cnn.substring(0, fen), false) * 0.01;
			if (fen < cnn.length() - 1)
				cnn = cnn.substring(fen + 1, cnn.length());
			else
				cnn = "";
		}

		cnn = cnn.trim();
		for (int j = 0; j < cnn.length(); j++)
			val += isCNNumeric(cnn.charAt(j)) * Math.pow(10, cnn.length() - j - 1);

		return val;
	}

	public static int qCNNumericToArabic(String cnn) {
		int val = 0;
		cnn = cnn.trim();
		for (int j = 0; j < cnn.length(); j++)
			val += isCNNumeric(cnn.charAt(j)) * Math.pow(10, cnn.length() - j - 1);
		return val;
	}

	public static void main(String[] args) {
		double val = 0;
		long s = System.nanoTime();
		val = cnNumericToArabic("叁佰贰拾伍元肆分", true);
		System.out.println(val);
		val = cnNumericToArabic("一九九八", true);
		System.out.println(val);
		long e = System.nanoTime();
		System.out.format("Done[" + val + "], cost: %.5fsec\n", ((float) (e - s)) / 1E9);
	}

}
