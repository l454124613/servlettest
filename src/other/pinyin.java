package other;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by lixuecheng on 2016/6/23.
 */
public class pinyin {
//    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
//
//        System.out.println(new testpinyin().aa("asna烧按时123"));
//    }
    public  String aa(String a) throws BadHanyuPinyinOutputFormatCombination {

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuffer sb=new StringBuffer();
        char[] a1=a.toCharArray();
        for (char a2:a1
             ) {
            if(Judge.isContainChinese(String.valueOf(a2)) ){
               String[] a3 = PinyinHelper.toHanyuPinyinStringArray(a2,format);
                sb.append(a3[0]);
            }else {
                sb.append(a2);
            }
        }


    return  sb.toString();}
}
