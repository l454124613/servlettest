package page_info;



import bases.button;
import bases.chioce;
import bases.input;
import bases.select;
import bases.text;
import bases.upload;
import org.openqa.selenium.By;


public    class baidu_page extends bases.page {

    public static   button baidu(){


      return   new button(By.id("su"));
    }
    public static   input in(){
        return  new input(By.id("kw"));
    }

}
