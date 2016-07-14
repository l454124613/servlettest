package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by lixuecheng on 2016/6/16.
 * 元素相关
 */
public class element {

   static WebElement find(By by){

     //  System.out.println(new  driver().get_driver());
      return driver.get_driver(Thread.currentThread().getId()).findElement(by);

    }


}
