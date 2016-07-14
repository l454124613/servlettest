package tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;

public class Cmd  implements Runnable{
	static String charset="GBK";
private  String cmd="";

    public Cmd(String cmd) {
        this.cmd = cmd;
    }


    public static List<String> run(String cmd) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();  
        	List<String> l=new ArrayList<String>();
               Process p = rt.exec(cmd);  
               BufferedReader br = new BufferedReader(new InputStreamReader(p  
                             .getInputStream(),charset));  
               String msg = null;  
               while ((msg = br.readLine()) != null) {  
                      if(msg.length()>0){
                    	  l.add(msg);
                      }
               }
        p.waitFor();
               br.close();
			return l;  
          
 }

    @Override
    public void run() {
        running(cmd);
    }
    Process  p=null;
    boolean reend=true;
    public void des(){
        p.destroy();
        reend=false;
    }
    public   void running(String cmd){
        Runtime rt = Runtime.getRuntime();
     //   String command = "java -jar lib/selenium-server-standalone-2.46.0.jar -port 4444 -role hub  -maxSession 40";

        try {
            p  = rt.exec(cmd );
            //获取进程的标准输入流
            final InputStream is1 = p.getInputStream();
            //获取进城的错误流
            final InputStream is2 = p.getErrorStream();
            //启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
            new Thread() {
                public void run() {
                    BufferedReader br1 = null;
                    try {
                        br1 = new BufferedReader(new InputStreamReader(is1,charset));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        String line1 = null;
                        while ((line1 = br1.readLine()) != null&reend) {
                            if (line1 != null){

                                System.out.println("Y:"+line1);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            is1.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            new Thread() {
                public void  run() {
                    BufferedReader br2 = null;
                    try {
                        br2 = new BufferedReader(new InputStreamReader(is2,charset));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        String line2 = null ;
                        while ((line2 = br2.readLine()) !=  null &reend) {
                            if (line2 != null){
                                System.out.println("N:"+line2);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            is2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            while (true){
                Thread.sleep(1000);
             //   System.out.println(reend);
if(!reend){
                p.destroy();
break;}
            }
           // p.waitFor();

            System.out.println("end...");
        } catch (Exception e) {
            try{
                p.getErrorStream().close();
                p.getInputStream().close();
                p.getOutputStream().close();
            }
            catch(Exception ee){
                System.out.println(ee.getMessage());
            }
        }
    }
}
