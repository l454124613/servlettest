package bases;

import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by lixuecheng on 2016/6/16.
 * js相关
 */
public class js {
    void executeScript(String Script){
        JavascriptExecutor d= (JavascriptExecutor)   driver.get_driver(Thread.currentThread().getId());
        d.executeScript(Script);

    }


}
