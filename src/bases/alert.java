package bases;

import org.openqa.selenium.Alert;

/**
 * Created by lixuecheng on 2016/6/16.
 * 提示框相关
 *
 */
public class alert {
    private Alert alert= driver.get_driver(Thread.currentThread().getId()).switchTo().alert();
/*
* 同意或确认
* */
    public void accept(){
        alert.accept();
    }
/*
* 取消
*
* */
    public void dismiss(){
        alert.dismiss();
    }
/*
* 获得文本内容
* */
    public String getText(){
       return alert.getText();
    }


}
