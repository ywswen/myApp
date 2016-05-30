package com.test;
import java.util.Hashtable;

public class TestLock {

	@SuppressWarnings("unchecked")
	private Hashtable map = new Hashtable();

	public TestLock() {
		Thread t1 = new Thread() {
			@SuppressWarnings("unchecked")
			public void run() {
				for (int i = 0; i < 5000000; i++) {
					map.put(new Integer(i), i);
				}
				System.out.println("t1 over");
			}
		};

		Thread t2 = new Thread() {
			@SuppressWarnings("unchecked")
			public void run() {
				for (int i = 0; i < 5000000; i++) {
					map.put(new Integer(i), i);
				}

				System.out.println("t2 over");
			}
		};

		t1.start();
		t2.start();

	}

	public static void main(String[] args) {
		new TestLock();
	}
}
