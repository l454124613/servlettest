package bases;

import org.openqa.selenium.By;

import java.util.Set;

/**
 * Created by lixuecheng on 2016/6/16.
 */
public class Switch {
    public  static  void defaultContent(){
        driver.get_driver(Thread.currentThread().getId()).switchTo().defaultContent();

    }

    public  static  void frame(By by){
        driver.get_driver(Thread.currentThread().getId()).switchTo().frame(element.find(by));

    }

    public  static  boolean window(String title_name){
       Set<String> s=driver.get_driver(Thread.currentThread().getId()).getWindowHandles();
       if (s.size()==1){
           return  false;
       }

String s1=driver.get_driver(Thread.currentThread().getId()).getWindowHandle();
        for(String sa:s){
            if(sa.equalsIgnoreCase(s1)){
                continue;
            }
           if( driver.get_driver(Thread.currentThread().getId()).switchTo().window(sa).getTitle().equals(title_name)){
               return  true;
           }
        }
        return  false;

    }

}
