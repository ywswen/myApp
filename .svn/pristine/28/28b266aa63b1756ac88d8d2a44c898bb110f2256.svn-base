package com.yyy.design.designModel6.prototype.greatestage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Monkey implements Cloneable ,Serializable {
	/**
	 * @属性说明：
	 **/
	private static final long serialVersionUID = -1804965119448996192L;
	// 身高
	private int height;
	// 体重
	private int weight;
	// 生日
	private Date birthDate;
	// 金箍棒
	private GoldRingedStaff staff;

	/**
	 * 构造函数
	 */
	public Monkey() {
		this.birthDate = new Date();
		this.staff = new GoldRingedStaff();
	}

	/**
	 * 克隆方法
	 */
	@SuppressWarnings("finally")
	public Object clone() {
		Monkey temp = null;
		try {
			temp = (Monkey) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return temp;
		}
	}

	/**
	 * @深度拷贝
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {
		// 将对象写入流里面
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		// 从流中取回来
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public GoldRingedStaff getStaff() {
		return staff;
	}

	public void setStaff(GoldRingedStaff staff) {
		this.staff = staff;
	}

}