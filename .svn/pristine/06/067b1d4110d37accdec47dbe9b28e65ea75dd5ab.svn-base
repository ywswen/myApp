package com.yyy.dailycode.listtotree.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;


import junit.framework.TestCase;

/**
 *   @类名： TestTree
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-1-6 上午09:30:19
 *   @修改人：
 *   @修改时间：  
 **/
public class TestTree extends TestCase{
	public void testPackageTree(){
		StringBuffer aa = new StringBuffer("aa");
		Integer  aaa=1;
		add(aa,aaa);
		List<TreeVO> list = new ArrayList<TreeVO>();
		this.packageList(list);
		StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>");
		Stack<TreeVO> stack = new Stack<TreeVO>();
		for(int i=0;i<list.size();i++){
			TreeVO vo = list.get(i);
			if(StringUtils.isEmpty(vo.getPSequence())){
				while(stack.size()>0){
					TreeVO temp = stack.pop();
					xml.append("</").append(temp.getName()).append(">");
				}
				xml.append("<").append(vo.getName()).append(">");
				stack.push(vo);
			}else{
				TreeVO temp = stack.pop();
				stack.push(temp);
				if(temp.getSequence().equals(vo.getPSequence())){
					xml.append("<").append(vo.getName()).append(">");
					stack.push(vo);
				}else{
					int size = stack.size();
					while(size-->0){
						temp = stack.pop();
						if(temp.getSequence().equals(vo.getPSequence())){
							xml.append("<").append(vo.getName()).append(">");
							stack.push(temp);
							stack.push(vo);
							break;
						}else{
							xml.append("</").append(temp.getName()).append(">");
						}
					}
				}
				
				
			}
		}
		while(stack.size()>0){
			TreeVO temp = stack.pop();
			xml.append("</").append(temp.getName()).append(">");
		}
		xml.append("</root>");
		System.out.println(xml);
	}
	public void packageList(List<TreeVO> list){
		TreeVO vo = new TreeVO();
		vo.setName("一级1");
		vo.setSequence("0001");
		vo.setPSequence("");
		list.add(vo);
		TreeVO vo11 = new TreeVO();
		vo11.setName("二级11");
		vo11.setSequence("00010001");
		vo11.setPSequence("0001");
		list.add(vo11);
		TreeVO vo111 = new TreeVO();
		vo111.setName("三级111");
		vo111.setSequence("000100010001");
		vo111.setPSequence("00010001");
		list.add(vo111);
		TreeVO vo112 = new TreeVO();
		vo112.setName("三级112");
		vo112.setSequence("000100010002");
		vo112.setPSequence("00010001");
		list.add(vo112);
		TreeVO vo12 = new TreeVO();
		vo12.setName("二级12");
		vo12.setSequence("00010002");
		vo12.setPSequence("0001");
		list.add(vo12);
		TreeVO vo121 = new TreeVO();
		vo121.setName("三级121");
		vo121.setSequence("000100020001");
		vo121.setPSequence("00010002");
		list.add(vo121);
		TreeVO vo122 = new TreeVO();
		vo122.setName("三级122");
		vo122.setSequence("000100020002");
		vo122.setPSequence("00010002");
		list.add(vo122);
		TreeVO vo13 = new TreeVO();
		vo13.setName("二级13");
		vo13.setSequence("00010003");
		vo13.setPSequence("0001");
		list.add(vo13);
		TreeVO vo131 = new TreeVO();
		vo131.setName("三级131");
		vo131.setSequence("000100030001");
		vo131.setPSequence("00010003");
		list.add(vo131);
		TreeVO vo1311 = new TreeVO();
		vo1311.setName("四级1311");
		vo1311.setSequence("0001000300010001");
		vo1311.setPSequence("000100030001");
		list.add(vo1311);
		TreeVO vo1312 = new TreeVO();
		vo1312.setName("四级1312");
		vo1312.setSequence("0001000300010002");
		vo1312.setPSequence("000100030001");
		list.add(vo1312);
		TreeVO vo132 = new TreeVO();
		vo132.setName("三级132");
		vo132.setSequence("000100030002");
		vo132.setPSequence("00010003");
		list.add(vo132);
		TreeVO vo2 = new TreeVO();
		vo2.setName("一级2");
		vo2.setSequence("0002");
		vo2.setPSequence("");
		list.add(vo2);
		TreeVO vo21 = new TreeVO();
		vo21.setName("二级21");
		vo21.setSequence("00020001");
		vo21.setPSequence("0002");
		list.add(vo21);
		TreeVO vo22 = new TreeVO();
		vo22.setName("二级22");
		vo22.setSequence("00020002");
		vo22.setPSequence("0002");
		list.add(vo22);
		TreeVO vo221 = new TreeVO();
		vo221.setName("三级221");
		vo221.setSequence("000200020001");
		vo221.setPSequence("00020002");
		list.add(vo221);
		TreeVO vo222 = new TreeVO();
		vo222.setName("三级222");
		vo222.setSequence("000200020002");
		vo222.setPSequence("00020002");
		list.add(vo222);
		TreeVO vo2221 = new TreeVO();
		vo2221.setName("四级2221");
		vo2221.setSequence("0002000200020001");
		vo2221.setPSequence("000200020002");
		list.add(vo2221);
		TreeVO vo2222 = new TreeVO();
		vo2222.setName("四级2222");
		vo2222.setSequence("0002000200020002");
		vo2222.setPSequence("000200020002");
		list.add(vo2222);
		TreeVO vo23 = new TreeVO();
		vo23.setName("二级23");
		vo23.setSequence("00020003");
		vo23.setPSequence("0002");
		list.add(vo23);
	}
	public void add(StringBuffer aa,Integer sq){
		aa.append("12321");
		sq++;
	}
}

