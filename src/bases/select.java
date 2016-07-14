package bases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by lixuecheng on 2016/6/16.
 */
public class select extends  Widget {
    WebElement ele;

    public select(By by, String... a) {
        super(a);
        ele = element.find(by);
        if(isframe()){
            switchDefaultContent();
        }
    }

    public boolean isEnabled() {
        return ele.isEnabled();
    }

    public  void chioce(int index){
        Select select=new Select(ele);
        select.selectByIndex(index);

    }
}
