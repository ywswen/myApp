package com.yyy.dailycode.wyp.character;


public class CharacterImpl {
	private static final String BLANK = "";
	public static String stringToAsciiStr(String content){
		if(content == null){
			return BLANK;
		}
		String result = new String();
		int length = content.length();
		for(int i=0;i<length;i++){
			char c = content.charAt(i);
			String b = Integer.toHexString(c);
			result = result + b;
		}
		return result;
	}
	public int charToAscii(char c){
		return (int)c;
	}
	public char asciiToChar(int ascii){
		return (char) ascii;
	}
	public static void main(String[] args) {
		label2 :for(int i = 0;i<3;i++){
			for(int j = 0 ;j<15;j++){
				if(j == 10){
					continue label2;
				}
				System.out.println(j);
			}
		}
//		int i =0;
//		long time = System.currentTimeMillis();
//		while(i<1000000000){
//			i = i + 1;
//		}
//		System.out.println(System.currentTimeMillis() - time);
	}
}
