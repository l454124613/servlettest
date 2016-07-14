package bases;



/**
 * Created by lixuecheng on 2016/6/20.
 */
public   class page {
/*
关闭浏览器，结束用这个
 */
    public static void quit(){
        base.quit();
    }
/*
关闭当前页面
 */
    public static void close(){
        base.close();
    }



    /**
     *页面刷新
     */
    public  static void refresh(){
        base.navigation().refresh();
    }

    /**
     *页面前进
     */
    public  static  void forward(){

        base.navigation().forward();
    }

    /**
     * 页面后退
     */
     public static  void back(){
         base.navigation().back();
     }

    /**
     * 获取页面
     * @param clazz
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static <T> T get_page(Class<T> clazz) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

            return  clazz.newInstance();

    }

}
