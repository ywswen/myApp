package com.yyy.dailycode.jbosscache;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		CacheManager cacheManager = CacheManager.getInstance();
		cacheManager.put("NAME", "cnName", "Shuai", false);
		cacheManager.put("NAME", "enName", "Tom", true);

		LOGGER.log(Level.INFO, cacheManager.get("NAME", "cnName").toString());
		LOGGER.log(Level.INFO, cacheManager.get("NAME", "enName").toString());
	}
}