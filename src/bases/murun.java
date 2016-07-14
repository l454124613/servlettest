package bases;

import testse.run;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lixuecheng on 2016/6/16.
 */
public class murun {
    boolean ch=true;
   public LinkedList<String>  qu=new LinkedList<>();
  public   int ssk=15;
   /// public  static  int num=0;
    ExecutorService threadPool = Executors.newCachedThreadPool();
    public boolean che(){
    return   threadPool.isTerminated();

    }
    public void run() throws InterruptedException {


        while (qu.size()>0){
           int a= ((ThreadPoolExecutor)threadPool).getActiveCount();

if (a<ssk){
    qu.poll();
ch=false;
    threadPool.execute(

//            new Runnable(){
//
//        @Override
//        public void run() {
//
//        }
//    }


            new run()
    );
}else{
//{  System.out.print("虚拟机内存总量:");
//    System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);//totalMemory()获取java虚拟机中的内存总量
//    System.out.print("虚拟机空闲内存量:");
//    System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);//freeMemory()获取java虚拟机中的空闲内存量
//    System.out.print("虚拟机使用最大内存量:");
//    System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);//maxMemory()获取java虚拟机试图使用的最大内存量


    Thread.sleep(500);
}


        }

        threadPool.shutdown();
      //  System.out.println("num:"+num);
    }
}
