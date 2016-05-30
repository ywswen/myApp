package com.yyy.dailycode.listtotree.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yyy.dailycode.listtotree.test.TreeVO;


/**
 *   @类名： ComparatorTreeList
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-12-23 下午07:39:10
 *   @修改人：
 *   @修改时间：  
 **/
@SuppressWarnings("unchecked")
public class ComparatorTreeVOList implements Comparator{

	public int compare(Object o1, Object o2) {
		TreeVO vo1 = (TreeVO)o1;
		TreeVO vo2 = (TreeVO)o2;
		return vo1.getSequence().compareTo(vo2.getSequence());
	}
	public static void main(String[] args) {
		List <TreeVO> returnList = new ArrayList<TreeVO>();
		ComparatorTreeVOList compare = new ComparatorTreeVOList();
		Collections.sort(returnList, compare);
	}
}

