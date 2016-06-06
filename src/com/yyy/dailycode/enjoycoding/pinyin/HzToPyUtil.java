package com.yyy.dailycode.enjoycoding.pinyin;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class HzToPyUtil {
  public static String toPinyin(String input) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c <= 255) {
        sb.append(c);
      } else {
        String pinyin = null;
        try {
          HanyuPinyinOutputFormat PINYIN_FORMAT = new HanyuPinyinOutputFormat();
          PINYIN_FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
          PINYIN_FORMAT.setVCharType(HanyuPinyinVCharType.WITH_V);

          String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, PINYIN_FORMAT);
          pinyin = pinyinArray[0];
        } catch (BadHanyuPinyinOutputFormatCombination e) {
        } catch (NullPointerException e) {
          // 如果是日文，可能抛出该异常
        }
        if (pinyin != null) {
          sb.append(pinyin);
        }
      }
    }
    return sb.toString();
  }
}
