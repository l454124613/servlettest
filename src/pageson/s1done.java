package pageson;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import db.elementdb;
import db.pagedb;
import tools.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lixuecheng on 2016/7/18.
 */
public class s1done {
    public static  String aa="";

   // root.put("isok", res);
    public static ObjectNode s1(String type,String method,String name,String pid,String path) throws Exception {
        JsonNodeFactory factory = new JsonNodeFactory(false);


        ObjectNode root = factory.objectNode();
        DataBase.con_path=path;
        if(type.equalsIgnoreCase("page")){
            if (method.equalsIgnoreCase("add")){
               int i= pagedb.inpage("pid="+pid,"name='"+name+"'");
                root.put("isok", i>0);
               return root;

            }else if (method.equalsIgnoreCase("minus")){
                int i=   pagedb.uppage(pid,"isused=1");
                root.put("isok", i>0);
                return root;
            }else if (method.equalsIgnoreCase("re")){
              //  System.out.println(name);
                int i=  pagedb.uppage(pid,"name='"+name+"'");
                root.put("isok", i>0);
                return root;
            }else if(method.equalsIgnoreCase("get")){
                List<Map<String, Object>> l= pagedb.sepgaeall("pid","name");

                List<ObjectNode> l2=new ArrayList<>();
                for(Map<String, Object> m:l){
                        l2.add(factory.objectNode());
                    l2.get(l2.size()-1).put("pid",String.valueOf(m.get("pid")));
                    l2.get(l2.size()-1).put("name",String.valueOf(m.get("name")));
                }
                root.put("isok",l2.size()>0);
                ObjectNode o2=factory.objectNode();
                for (int i = 0; i <l2.size() ; i++) {
                    o2.put(String.valueOf(i),l2.get(i));

                }
                root.put("node",o2);
            return  root;

            }else{
                root.put("isok", false);
                return root;

            }


        }else if(type.equalsIgnoreCase("element")){
            if (method.equalsIgnoreCase("go")){
                List<Map<String, Object>> l= elementdb.seelementall(pid,"pid","eid","type","value","button","buttonvalue","isswitch");
                List<ObjectNode> l2=new ArrayList<>();
                for(Map<String, Object> m:l){
                    l2.add(factory.objectNode());
                l2.get(l2.size()-1).put("pid",String.valueOf(m.get("pid")));
                l2.get(l2.size()-1).put("eid",String.valueOf(m.get("eid")));
                l2.get(l2.size()-1).put("type",String.valueOf(m.get("type")));
                l2.get(l2.size()-1).put("value",String.valueOf(m.get("value")));
                l2.get(l2.size()-1).put("button",String.valueOf(m.get("button")));
                l2.get(l2.size()-1).put("buttonvalue",String.valueOf(m.get("buttonvalue")));
                    l2.get(l2.size()-1).put("isswitch",String.valueOf(m.get("isswitch")));
            }
                root.put("isok",l2.size()>0);
                ObjectNode o2=factory.objectNode();
                for (int i = 0; i <l2.size() ; i++) {
                    o2.put(String.valueOf(i),l2.get(i));

                }
                root.put("node",o2);
                return  root;
            }
            else  if (method.equalsIgnoreCase("add")){

               int i= elementdb.inelement(pid,name);
                root.put("isok", i>0);
                return root;
            } if (method.equalsIgnoreCase("minus")){
                int i=elementdb.upelement(pid,"isused=1");
                root.put("isok",i==1);
                return root;
            } if (method.equalsIgnoreCase("re")){
                Map<String, Object> m=  elementdb.seelement(pid,"button,type,value,buttonvalue,isswitch,fw,stype1,svalue1,fwn,stype2,svalue2");
                ObjectNode o2=factory.objectNode();
                root.put("isok",m.size()>0);
                for(Map.Entry<String, Object> entry:m.entrySet()){
                    o2.put(entry.getKey(),String.valueOf(entry.getValue()));

                }
                root.put("node",o2);
                return root;
            } if (method.equalsIgnoreCase("re2")){
                //TODO
                String n2="";
                String[] n1=name.replace("，",",").split(",");
                for (String a:n1
                        ) {
                    //   System.out.println(a);
                    try {
                        n2=n2+",'" + a.split(":")[0]+"'='" + a.split(":")[1]+"'";
                    } catch (ArrayIndexOutOfBoundsException e) {
                       // n2=n2+",'" +""+"'";
                    }
                }

                int i=    elementdb.upelement(pid,n2);
                root.put("isok",i==1);
                return  root;
            }
        }

        root.put("isok", false);
        return root;
    }
}
