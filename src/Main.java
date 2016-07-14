import bases.murun;
import tools.Cmd;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        String a1="java -jar lib/selenium-server-standalone-2.46.0.jar -port 4444 -role hub  -maxSession 50";
        String a2="java -jar lib/selenium-server-standalone-2.46.0.jar   -Dwebdriver.chrome.driver=\"D:/teste/driver/chromedriver.exe\" " +
                "-role node  -hub http://localhost:4444/grid/register  -browser browserName=chrome,maxInstances=5 -maxSession 50 ";


        Cmd c1=new Cmd(a1);
        Cmd c2=new Cmd(a2);
        Thread t1=new Thread(c1);
        t1.start();
        Thread.sleep(3000);
       Thread t2=new Thread(c2);
        t2.start();
        murun m= new murun();

        for (int i = 0; i <3 ; i++) {

            m.qu.add(String.valueOf(i));
        }
        Thread.sleep(3000);
        m.run();

//        for (int i = 0; i <10 ; i++) {
//            Thread.sleep(3000);
//            m.che();
//        }
        while (true){
            if (m.che()) {
              //  System.out.println(m.che());
                t1.interrupt();
                t2.interrupt();
                c1.des();
                c2.des();
                break;
            }
        }

    }





}
