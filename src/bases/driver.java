package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import tools.Cmd;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by lixuecheng on 2016/6/16.
 * <p/>
 * driver 相关
 */
public class driver {
    private  WebDriver webDriver;
private  static Map<Long,driver> mm =new HashMap<Long,driver>();
    private driver(String ... aa) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//设置驱动的位置
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
      capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
        capabilities.setBrowserName("chrome");
    ChromeOptions options = new ChromeOptions();
      options.addArguments("--test-type");

      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        if (aa.length>0) {
            webDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
        }else{webDriver=new ChromeDriver(capabilities);
        }

    }


    public   static WebDriver get_driver(Long a){

    return mm.get(a).webDriver;
    }
/*
url:网站连接,islocal 只要填写就调用远程服务，以后要改的，现在暂时这样
 */
    public  static   void  connect(String url,String ...islocal){
           long a= Thread.currentThread().getId();
        driver d= null;
        try {
            d = new driver(islocal);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        mm.put(a,d);
        if(url.contains("http")){
            d.webDriver.get(url);

        }else {
            d.webDriver.get("http://" + url);

        }
    }
    static  Thread t1;
    static Thread t2;
    static Cmd c1;
    static   Cmd c2;
public  static  void start() throws InterruptedException {
    String a1="java -jar lib/selenium-server-standalone-2.46.0.jar -port 4444 -role hub  -maxSession 50";
    String a2="java -jar lib/selenium-server-standalone-2.46.0.jar   -Dwebdriver.chrome.driver=\"D:/teste/driver/chromedriver.exe\" " +
            "-role node  -hub http://localhost:4444/grid/register  -browser browserName=chrome,maxInstances=5 -maxSession 50 ";


     c1=new Cmd(a1);
     c2=new Cmd(a2);
     t1=new Thread(c1);
    t1.start();
    Thread.sleep(3000);
     t2=new Thread(c2);
    t2.start();
}
    public static void close(){
        while (true){
            //TODO
        //    if (m.che()) {
                //  System.out.println(m.che());
                t1.interrupt();
                t2.interrupt();
                c1.des();
                c2.des();
                break;
       //     }
        }
    }
}
