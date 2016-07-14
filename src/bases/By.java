package bases;



/**
 * Created by lixuecheng on 2016/6/23.
 */
public class By {

   private static org.openqa.selenium.By by=null;

    public By(String se,String v) {
        switch (se){
            case "id":by= org.openqa.selenium.By.id(v);break;
            case "className":by= org.openqa.selenium.By.className(v);break;
            case "cssSelector":by= org.openqa.selenium.By.cssSelector(v);break;
            case "linkText":by= org.openqa.selenium.By.linkText(v);break;
            case "name":by= org.openqa.selenium.By.name(v);break;
            case "tagName":by= org.openqa.selenium.By.tagName(v);break;
            case "partialLinkText":by= org.openqa.selenium.By.partialLinkText(v);break;
            case "xpath":by= org.openqa.selenium.By.xpath(v);break;

        }
    }

    public  static org.openqa.selenium.By getBy(String se,String v) {
        new By(se,v);
        return by;
    }
}
