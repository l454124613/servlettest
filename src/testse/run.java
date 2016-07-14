package testse;

import bases.base;
import bases.driver;
import page_info.baidu_page;

/**
 * Created by lixuecheng on 2016/6/16.
 */
public class run implements Runnable {
    public static  void main(String[] args) throws InterruptedException {
   // baidu_page.connect();
        driver.connect("www.baidu.com");
       base .setMaxScreen();
        baidu_page.in().sendkeys("niahoa按时");
       // baidu_page.baidu();

       // baidu_page.quit();
      //  System.out.println(baidu_page.baidu().isEnabled());
       baidu_page.baidu().click();
        baidu_page2.link().click();
      //  System.out.println("ok");
        Thread.sleep(3000);
        baidu_page2.quit();
}

    @Override
    public void run() {

      //  baidu_page.connect();
        baidu_page.in().sendkeys("niahoa按时");
        baidu_page.baidu();
        baidu_page.quit();
        System.out.println("ok");
     //   murun.num++;
    }
}
