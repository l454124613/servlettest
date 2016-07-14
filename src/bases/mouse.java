package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by lixuecheng on 2016/6/16.
 */
public class mouse {
    WebElement ele;

    public void setEle2(WebElement ele2) {
        this.ele2 = ele2;
    }

    public void setEle(WebElement ele) {
        this.ele = ele;
    }

    WebElement ele2;
    Actions actions = new Actions(driver.get_driver(Thread.currentThread().getId()));

    public mouse() {
    }

    public mouse(By by) {
        ele = element.find(by);
    }

    public mouse(By by, By by2) {
        ele = element.find(by);
        ele2 = element.find(by2);
    }

    public void contextClick() {
        actions.doubleClick(ele);
    }

    public void dragAndDrop() {
        actions.clickAndHold(ele).moveToElement(ele2).perform();
        actions.release();

    }
    public  void clickAndHold(){
        actions.clickAndHold(ele);

    }

    public  void moveToElement(){
        actions.moveToElement(ele);

    }
public  void release(){
    actions.release();
}


}
