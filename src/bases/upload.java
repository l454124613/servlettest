package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by lixuecheng on 2016/6/16.
 */
public class upload  extends Widget{
    WebElement ele;
    public upload(By by,String... a) {
        super(a);ele = element.find(by);
        if(isframe()){
            switchDefaultContent();
        }
    }


    public void send(String file){
    ele.sendKeys(file);
    }
}
