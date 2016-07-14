package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by lixuecheng on 2016/6/16.
 * 按钮相关
 */
public class button extends Widget {
    WebElement ele;

    public button(By by, String...t) {
        super(t);
        ele = element.find(by);
        if(isframe()){
            switchDefaultContent();
        }
    }

    public void click() {
        ele.click();
        if (istitle()){
            switchToWin();
        }
    }

    public boolean isEnabled() {
        return ele.isEnabled();
    }


}
