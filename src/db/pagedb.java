package db;

import tools.DataBase;

import java.util.List;
import java.util.Map;

/**
 * Created by lixuecheng on 2016/7/18.
 */
public class pagedb {
    /**
     *
     * @param pid
     * @param a  xxx=aaa
     * @return
     * @throws Exception
     */
    public static int uppage(String pid,String... a) throws Exception {
        String a1="";
        if(a.length>0){
            for (String a2:a){
                a1=a1+","+a2;
            }

        }else{return 0;}
        String sql="";
        if(pid.split(",").length>1){
sql="update page set  "+a1.substring(1)+" where pid in ( "+pid+")";
        }else{
       sql="update page set  "+a1.substring(1)+" where pid= "+pid;
        }
      return   DataBase.update(sql,2);

    }

    /**
     *
     *
     * @param a xxx=xxx
     * @return
     * @throws Exception
     */
    public static int inpage(String... a) throws Exception {
        String a1="";
        String a3="";
        if(a.length>0){
            for (String a2:a){
                a1=a1+","+a2.split("=")[0];
                a3=a3+","+a2.split("=")[1];
            }

        }else{return 0;}
    String sql="insert into page ("+a1.substring(1)+") values ("+a3.substring(1)+")";
      //  System.out.println(sql);
        return  DataBase.update(sql,2);

}

    /**
     *
     * @param a
     * @return
     * @throws Exception
     */
    public  static List<Map<String, Object>> sepgaeall(String...a) throws Exception {
        String a1="";
        if(a.length>0){
            for (String a2:a){
                a1=a1+","+a2;
            }

        }else{return null;}
    String sql="select "+a1.substring(1)+" from page where isused=0";
     //   System.out.println(sql);
        return DataBase.select(sql,2);

    }

    /**
     *
     * @param pid
     * @param a
     * @return
     * @throws Exception
     */
    public  static Map<String, Object> sepgae(String pid,String...a) throws Exception {
        String a1="";
        if(a.length>0){
            for (String a2:a){
                a1=a1+","+a2;
            }

        }else{return null;}
        String sql="select "+a1.substring(1)+"from page where isused=0 and pid="+pid;
        return DataBase.select(sql,2).get(0);

    }

}
