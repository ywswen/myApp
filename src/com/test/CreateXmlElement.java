package com.test;

import java.io.FileOutputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class CreateXmlElement {
	public void BuildXML() throws Exception {
		Element rootElement = new Element("MyInfo");// ���е�XMLԪ�ض��� Element
													// ��ʵ���Ԫ��Ҳ�����⣺��
		Document myDocument = new Document(rootElement);// �Ը�Ԫ����Ϊ����Document����һ��Documentֻ��һ���rootԪ�ء�
		rootElement.setAttribute("comment", "introduce myself");
		// ����������;JDOM����Ԫ������Ϊ content�����ݣ���ӵ���Ԫ������ȥ�ġ�
		Element intrductionElement = new Element("intrduction");
		rootElement.addContent("sasdfasdfasdf");
		rootElement.addContent(intrductionElement);
		Element nameElement = new Element("name");// ���� name Ԫ��
		nameElement.addContent("songyanwei");// ��songyanwei��Ϊcontent��ӵ�nameԪ��

		intrductionElement.addContent(nameElement);// ��nameԪ����Ϊcontent��ӵ���Ԫ��
		Element sexElement = new Element("sex");
		intrductionElement.addContent(sexElement);
		sexElement.addContent("male");
		Element contactElement = new Element("contact");
		intrductionElement.addContent(contactElement);
		contactElement.addContent("telephone");
		contactElement.addContent("87654321");
		Format format = Format.getCompactFormat();

		format.setEncoding("gb2312"); // ����xml�ļ����ַ�Ϊgb2312

		format.setIndent("    "); // ����xml�ļ������Ϊ4��ո�
		XMLOutputter XMLOut = new XMLOutputter(format);// ��Ԫ�غ��У�ÿһ��Ԫ�������ĸ�
		format.toString();
		System.out.println(format.toString());
		XMLOut.output(myDocument, new FileOutputStream("c://myinfor.xml"));
	}

	public static void main(String[] args) throws Exception	{

		CreateXmlElement w = new CreateXmlElement();

		System.out.println("Now we build an XML document .....");

		w.BuildXML();

		System.out.println("finished!");

	}
}
