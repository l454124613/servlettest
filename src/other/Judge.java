package other;

import tools.Regular;

/**
 * Created by lixuecheng on 2016/6/23.
 */
public class Judge {
    public  static  boolean isContainChinese(String pa){
        return Regular.count(pa,"[\\u4e00-\\u9fa5]")>0?true:false;
    }
}
