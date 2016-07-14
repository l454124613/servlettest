package bases;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixuecheng on 2016/6/16.
 * 页面基本数据
 */
public class base {
/*
页面操作
 */

    public  static WebDriver.Navigation navigation(){
       return driver.get_driver(Thread.currentThread().getId()).navigate();
    }
/*
* 设置等待元素超时时间
*
* */
    public static void setimplicitlyWait(int time) {
        driver.get_driver(Thread.currentThread().getId()).manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

    }
/*
* 设置页面页面加载超时时间
*
* */
    public static void setpageLoadTimeout(int time) {
        driver.get_driver(Thread.currentThread().getId()).manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);

    }
/*
* 设置全屏
* */
    public static void setMaxScreen() {
        driver.get_driver(Thread.currentThread().getId()).manage().window().maximize();


    }

    /*
  * 关闭当前窗口
  */
 public static void close(){
     try {
         driver.get_driver(Thread.currentThread().getId()).close();
     } catch (Exception e) {

     }

 }

    /*
 * 关闭所有窗口
 */
    public static void quit(){
        driver.get_driver(Thread.currentThread().getId()).quit();

    }

    /**
     * 输入js脚本
     * @param Script
     */
    public static  void  js(String Script){
        new js().executeScript(Script);
    }

    /**
     * 键盘操作
     * @param keys
     */
    public  static  void keyboard(String keys){
        new keyboard().sendkeys(keys);

    }

    public  static  mouse mouse(){
        return  new mouse();
    }

}
