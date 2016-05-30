package com.test;
import java.util.HashSet;

public class WrappedString {
	@SuppressWarnings("unused")
	private String s;

	public WrappedString(String s) {
		this.s = s;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		WrappedString ws1 = new WrappedString("aardvark");
		WrappedString ws2 = new WrappedString("aardvark");
		String s1 = new String("aardvark");
		String s2 = new String("aardvark");
		hs.add(ws1);
		hs.add(ws2);
		hs.add(s1);
		hs.add(s2);
		System.out.println(hs.size());
	}
}
