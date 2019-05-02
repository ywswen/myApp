package com.yyy.dailycode.jbosscache;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.cache.Cache;
import org.jboss.cache.DefaultCacheFactory;
import org.jboss.cache.Fqn;
import org.jboss.cache.Node;
import org.jboss.cache.config.Configuration;
import org.jboss.cache.config.Configuration.CacheMode;
import org.jboss.cache.util.CachePrinter;


/**
 *   @类名： CacheManager
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2018-11-8 下午03:57:33
 *   @修改人：
 *   @修改时间：  
 **/
public class CacheManager {

	
	private static final Logger LOGGER = Logger.getLogger(CacheManager.class.getName());

	private static CacheManager cacheManager = null;
	private static Cache<String, Serializable> cache = null;
	private static final String CONFIGURATION_FILE = "d:\\jboss-cache-config-single.xml";

	private static final String CLUSTER_NAME = "JBossCacheDemo";
	private static Node<String, Serializable> rootNode = null;
	private static final String NODE_NAME = "Node Name";
	private static final String LOCAL = "LOCAL";
	private static final String KEY = "Key";
	private static final String VALUE = "Value";
	private static final int MAX_RETRY_COUNT = 5;

	/**
	 * Creates a cache if it is not existing.
	 */
	private CacheManager() {
		if (cache == null) {
			cache = new DefaultCacheFactory<String, Serializable>().createCache(CONFIGURATION_FILE, false);

			initCache();
		}
	}

	/**
	 * Singleton for CacheManager
	 * 
	 * @return
	 */
	public static CacheManager getInstance() {
		if (cacheManager == null) {
			cacheManager = new CacheManager();
		}

		return cacheManager;
	}

	/**
	 * Creates a cache
	 */
	private void initCache() {
		Cache<String, Serializable> cache = getCache();
		Configuration configuration = cache.getConfiguration();

		configuration.setCacheMode(CacheMode.valueOf(LOCAL));
		configuration.setClusterName(CLUSTER_NAME);

		LOGGER.log(Level.INFO, "Created Cache with Name : {0} :: Mode :: {1} ", new Object[] { configuration.getClusterName(), configuration.getCacheMode() });

		cache.start();

		rootNode = cache.getRoot();
	}

	/**
	 * Gets the cache instance.
	 * 
	 * @return instance of cache.
	 */
	Cache<String, Serializable> getCache() {
		return cache;
	}

	/**
	 * Gets the value from the cache for the specified key.
	 * 
	 * @param qualifiedNodeName
	 *            the complete node name from which you want to fetch
	 *            the value for a given key
	 * @param key
	 *            the key
	 * @return the value associated for the key
	 */
	public Serializable get(String qualifiedNodeName, String key) {
		nullCheck(KEY, key);

		Node<String, Serializable> node = getNode(qualifiedNodeName);

		if (node == null) {
			return null;
		}

		return node.get(key);
	}

	/**
	 * Put key value pair in the cache.
	 * 
	 * @param qualifiedNodeName
	 *            the complete node name against which you want to put
	 *            the key-value pair
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 * @param overwrite
	 *            true if the value can be overwritten otherwise
	 *            false.
	 */
	public void put(String qualifiedNodeName, String key, Serializable value, boolean overwrite) {
		nullCheck(KEY, key);
		nullCheck(VALUE, value);
		nullCheck(NODE_NAME, qualifiedNodeName);

		put(qualifiedNodeName, key, value, 1, overwrite);
	}

	/**
	 * method to find out whether a node exists or not.
	 * 
	 * @param qualifiedNodeName
	 *            node name
	 * @return boolean indicating whether node exists or not.
	 */
	public boolean nodeExists(String qualifiedNodeName) {
		nullCheck(NODE_NAME, qualifiedNodeName);

		return rootNode.hasChild(Fqn.fromString(qualifiedNodeName));
	}

	/**
	 * Gets the node of specified name.
	 * 
	 * @param qualifiedNodeName
	 *            the fqn.
	 * @return the node.
	 */
	public Node<String, Serializable> getNode(String qualifiedNodeName) {
		return rootNode.getChild(Fqn.fromString(qualifiedNodeName));
	}

	/**
	 * Deletes the specified node
	 * 
	 * @param node
	 *            to be deleted
	 */
	public void removeNode(String qualifiedNodeName) {
		nullCheck(NODE_NAME, qualifiedNodeName);

		removeNode(qualifiedNodeName, 1);
	}

	/**
	 * Puts the value to the given qualifiedNodeName
	 * 
	 * @param qualifiedNodeName
	 * @param key
	 * @param value
	 * @param attemptNumber
	 * @param overwrite
	 */
	private void put(String qualifiedNodeName, String key, Serializable value, int attemptNumber, boolean overwrite) {
		try {
			Node<String, Serializable> node = getNode(qualifiedNodeName);

			if (node == null) {
				node = createNode(qualifiedNodeName);
			}

			if (overwrite) {
				node.put(key, value);
			} else {
				node.putIfAbsent(key, value);
			}
		} catch (RuntimeException runtimeException) {
			if (attemptNumber == MAX_RETRY_COUNT) {
				LOGGER.log(Level.SEVERE, "Exception occured while storing value: " + value + " with key: " + key + " at node " + qualifiedNodeName + " due to " + runtimeException.getMessage(), runtimeException);
				return;
			}

			LOGGER.log(Level.WARNING, "Retry [{0}] for storing value: {1} with key: {2} at node {3} due to {4}", new Object[] { attemptNumber, value, key, qualifiedNodeName, runtimeException.getMessage() });

			put(qualifiedNodeName, key, value, attemptNumber++, overwrite);
		}
	}

	/**
	 * Removes the node
	 * 
	 * @param qualifiedNodeName
	 * @param attemptNumber
	 */
	private void removeNode(String qualifiedNodeName, int attemptNumber) {
		nullCheck(NODE_NAME, qualifiedNodeName);

		try {
			rootNode.removeChild(Fqn.fromString(qualifiedNodeName));
		} catch (RuntimeException runtimeException) {
			if (attemptNumber == MAX_RETRY_COUNT) {
				LOGGER.log(Level.SEVERE, "Exception occured while removing node: " + qualifiedNodeName + " due to " + runtimeException.getMessage(), runtimeException);
				return;
			}

			LOGGER.log(Level.WARNING, "Retry [{0}] for removing node: {1} due to {2}", new Object[] { attemptNumber, qualifiedNodeName, runtimeException.getMessage() });

			removeNode(qualifiedNodeName, attemptNumber++);
		}
	}

	/**
	 * Creates a new node
	 * 
	 * @param qualifiedNodeName
	 * @return
	 */
	private Node<String, Serializable> createNode(String qualifiedNodeName) {
		return rootNode.addChild(Fqn.fromString(qualifiedNodeName));
	}

	/**
	 * Used to check if the node exists or not
	 * 
	 * @param msg
	 * @param obj
	 */
	private void nullCheck(String msg, Object obj) {
		if (obj == null || obj.toString().trim().length() == 0) {
			IllegalArgumentException e = new IllegalArgumentException(msg + " needs to be specified");

			LOGGER.log(Level.SEVERE, e.getMessage(), e);

			throw e;
		}
	}

	/**
	 * Reset the cache reference. SHOULD BE USED ONLY IN JUNITS.
	 */
	static void resetCache() {
		cache = null;
	}

	/**
	 * Prints the contents of the cache (nodes + data) to a string
	 * 
	 * @return a String representation of the cache
	 */
	public String printCacheDetails() {
		return CachePrinter.printCacheDetails(cache);
	}
}
