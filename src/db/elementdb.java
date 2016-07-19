package db;

import tools.DataBase;

import java.util.List;
import java.util.Map;

/**
 * Created by lixuecheng on 2016/7/19.
 */
public class elementdb {
    public static  int inelement(String pid ,String name) throws Exception {
        String n2="";
        String[] n1=name.replace("，",",").split(",");
        for (String a:n1
             ) {
         //   System.out.println(a);
            try {
                n2=n2+",'" + a.split(":")[1]+"'";
            } catch (ArrayIndexOutOfBoundsException e) {
                n2=n2+",'" +""+"'";
            }
        }

        String sql="insert into element (pid,type,button,fw,stype1,fwn,stype2,value,buttonvalue,svalue1,svalue2,isswitch,eid) values ("+pid+n2+")";
      //  System.out.println(sql);
         return  DataBase.update(sql,2);

    }
    public static int upelement(String eid,String... a) throws Exception {

        String a1="";
        if(a.length>0){
            for (String a2:a){
                a1=a1+","+a2;
            }

        }else{return 0;}
        String sql="";


            sql="update element set  "+a1.substring(1)+" where eid= "+eid;

        return   DataBase.update(sql,2);
    }
    public static  Map<String, Object> seelement(String eid, String...a)   throws Exception{
        String a1="";
        if(a.length>0){
            for (String a2:a){
                a1=a1+","+a2;
            }

        }else{return null;}
        String sql="select "+a1.substring(1)+"from element where isused=0 and eid="+eid;
        return DataBase.select(sql,2).get(0);
    }
    public  static List<Map<String, Object>> seelementall(String pid,String...a) throws Exception {
        String a1="";
        if(a.length>0){
            for (String a2:a){
                a1=a1+","+a2;
            }

        }else{return null;}
        String sql="select "+a1.substring(1)+" from element where isused=0 and pid="+pid;
        //   System.out.println(sql);
        return DataBase.select(sql,2);

    }
}
