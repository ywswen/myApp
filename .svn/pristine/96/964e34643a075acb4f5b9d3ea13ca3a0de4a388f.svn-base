package com.yyy.dailycode.enjoycoding.pinyin;


/**
 *   @类名： ConverToPinyin
 *   @描述： 中文转化为拼音依赖的jar为pinyin4j-2.5.0.jar
 *   @作者： 杨文胜
 *   @生成时间： 2014-8-29 11:43:39
 *   @修改人：
 *   @修改时间：  
 **/
public class ConverToPinyin
{

  public static String getQuanPin(String columnNameCh) {

      String s = "";
      if(columnNameCh == null){
          return s;
      }
       for (int i = 0; i < columnNameCh.length(); i++) {
          String temp = columnNameCh.substring(i, i+1);
          if(temp.equals(" ") || temp.equals("(") || temp.equals(")") || temp.equals("（") || temp.equals("）") || temp.equals("、") || temp.equals("”") || temp.equals("“") || temp.equals("-")|| temp.equals("：")|| temp.equals("，")|| temp.equals("；")||temp.equals("")||temp.equals("？")||temp.equals("★")|| temp.equals("　")) {
            continue;
          }
          s += HzToPyUtil.toPinyin(temp);
        }

      return s;
  }

  public static String getFirstCharacter(String columnNameCh) {
     if(columnNameCh==null){
        return "";
     }
     String s = "";
     for (int i = 0; i < columnNameCh.length(); i++) {
        String temp = columnNameCh.substring(i, i+1);

        if(temp=="" || temp.equals(" ") || temp.equals("(") || temp.equals(")") || temp.equals("（") || temp.equals("）") || temp.equals("、") || temp.equals("”") || temp.equals("“") || temp.equals("-")|| temp.equals("：")|| temp.equals("，")|| temp.equals("；")||temp.equals("")||temp.equals("？")||temp.equals("★")|| temp.equals("　")) {
          continue;
        }
        String s1 = HzToPyUtil.toPinyin(temp);
        if(s1.length() > 0){
        s += s1.substring(0, 1).toUpperCase();
        }
      }
      return s;
  }
  public static void main(String[] args) {
	System.out.println(getQuanPin(""));
}
}

