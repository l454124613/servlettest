package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by lixuecheng on 2016/6/16.
 * 选择相关
 */
public class chioce extends  Widget{
    WebElement ele;
    public chioce(By by,String... a) {
        super(a);
        ele = element.find(by);
        if(isframe()){
            switchDefaultContent();
        }
    }
    public void click() {
        ele.click();
    }

    public boolean isEnabled() {
        return ele.isEnabled();
    }
    public boolean isSelected() {
        return ele.isSelected();
    }
}
