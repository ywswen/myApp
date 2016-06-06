package com.yyy.design.designModel6.prototype.loginprototype;


import java.util.HashMap;
import java.util.Map;

import com.yyy.design.designModel6.prototype.loginprototype.ProtoType;

/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-25 下午04:54:55
 * 
 * @类说明 ：原型管理器角色保持一个聚集，作为对所有原型对象的登记，这个角色提供必要的方法，供外界增加新的原型对象和取得已经登记过的原型对象。
 */
public class PrototypeManager {
	/**
	 * 用来记录原型的编号和原型实例的对应关系
	 */
	private static Map<String, ProtoType> map = new HashMap<String, ProtoType>();

	/**
	 * 私有化构造方法，避免外部创建实例
	 */
	private PrototypeManager() {
	}

	/**
	 * 向原型管理器里面添加或是修改某个原型注册
	 * 
	 * @param prototypeId
	 *            原型编号
	 * @param prototype
	 *            原型实例
	 */
	public synchronized static void setPrototype(String prototypeId, ProtoType prototype) {
		map.put(prototypeId, prototype);
	}

	/**
	 * 从原型管理器里面删除某个原型注册
	 * 
	 * @param prototypeId
	 *            原型编号
	 */
	public synchronized static void removePrototype(String prototypeId) {
		map.remove(prototypeId);
	}

	/**
	 * 获取某个原型编号对应的原型实例
	 * 
	 * @param prototypeId
	 *            原型编号
	 * @return 原型编号对应的原型实例
	 * @throws Exception
	 *             如果原型编号对应的实例不存在，则抛出异常
	 */
	public synchronized static ProtoType getPrototype(String prototypeId) throws Exception {
		ProtoType prototype = map.get(prototypeId);
		if (prototype == null) {
			throw new Exception("您希望获取的原型还没有注册或已被销毁");
		}
		return prototype;
	}
}
