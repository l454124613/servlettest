package bases;

import org.openqa.selenium.interactions.Actions;

/**
 * Created by lixuecheng on 2016/6/16.
 */
public class keyboard {
    Actions actions =new Actions(driver.get_driver(Thread.currentThread().getId()));
/*
*
*  * Actions 中的 sendKeys(keysToSend) 对于修饰键 (Modifier Keys) 的调用并不会释放，也就是说当调用 actions.sendKeys(Keys.ALT); actions.sendKeys(Keys.CONTROL); action.sendKeys(Keys.SHIFT); 的时候，相当于调用 actions.keyDown(keysToSend)，而如果在现实的应用中想要模拟按下并且释放这些修饰键，应该再调用 action.sendKeys(keys.NULL) 来完成这个动作。

* */
      void sendkeys(String keys){
        actions.sendKeys(keys);
    }

}
