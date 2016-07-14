package pageson;


import pageson.pageson;
import tools.Text;

import java.io.IOException;

import java.util.*;

/**
 * Created by lixuecheng on 2016/6/22.
 */
public class tjson {
    public   List<pageson> getpageinfo(String file) throws IOException {
      //  long t1=System.currentTimeMillis();
        List<String> a=Text.from(file);  //"data/json.txt"
        StringBuffer s=new StringBuffer();
        for (String c:a
             ) {
        s.append(c);
        }
        String  w=s.toString().replace(" ","").replace("\t","").replace("：",":").replace("，",",");//.replace("[","{").replace("]","}").replace("【","{").replace("】","}")
       // System.out.println(w);
      //  long t2=System.currentTimeMillis();
        char[] ca= w.toCharArray();
        StringBuffer s1=new StringBuffer();
        int ceng=0;
        List<pageson> lp=new ArrayList<>();
        String c0="";
        String c="";
        String c2="";
        for (int i = 0; i < ca.length; i++) {
           if(ca[i]==':'){
               if (ceng==0){
                   lp.add(new pageson());
               }
               else  if(ceng==1){
                   if (s1.toString().equalsIgnoreCase("name")){
                   c0=s1.toString();

                   }
                   else    if (s1.toString().equalsIgnoreCase("element")){
                     //  lp.get(lp.size()-1).add(new eleson());
                       lp.get(lp.size()-1).setL(new ArrayList<eleson>());

                   }
               }
               else  if(ceng==2){
                     if(s1.toString().equalsIgnoreCase("button")||
                        s1.toString().equalsIgnoreCase("input")||
                        s1.toString().equalsIgnoreCase("chioce")||
                        s1.toString().equalsIgnoreCase("select")||
                             s1.toString().equalsIgnoreCase("text")||
                        s1.toString().equalsIgnoreCase("upload")){
                    lp.get(lp.size()-1).add(new eleson());
                    lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).setOp(s1.toString());

                }


               } else   if(ceng==3){
                   if(s1.toString().equalsIgnoreCase("switch")){
                       lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).setSwitchto(new HashMap<String, String>());
                   }else {
                       c=s1.toString();
                   }

               }
               else if(ceng==4){
                   c2=s1.toString();

               }
               s1.setLength(0);
           }

            else if(ca[i]=='{'){
    ceng++;


}
           else   if (ca[i]==','){

if(ceng==0){


}
else if (ceng==1){
                    if(c0.equalsIgnoreCase("name")){
                        lp.get(lp.size()-1).setName(s1.toString());

                    }
                }
else      if (ceng==2){}
else      if(ceng==3){
                    if(c.equalsIgnoreCase("type")){
                        lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).setType(s1.toString());
                    }
                    if(c.equalsIgnoreCase("value")){
                        lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).setValue(s1.toString());
                    }
                    if(c.equalsIgnoreCase("name")){
                        lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).setName(s1.toString());
                    }
                }
else     if (ceng==4){

                    lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).getSwitchto().put(c2,s1.toString());
                }

                s1.setLength(0);
            }

           else    if(ca[i]=='}'){
                if (s1.toString().length()>0){
                    if(ceng==0){


                    }
                    else   if (ceng==1){
                        if(c0.equalsIgnoreCase("name")){
                            lp.get(lp.size()-1).setName(s1.toString());

                        }
                    }
                    else if (ceng==2){}
                    else  if(ceng==3){
                        if(c.equalsIgnoreCase("type")){
                            lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).setType(s1.toString());
                        }
                        else   if(c.equalsIgnoreCase("value")){
                            lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).setValue(s1.toString());
                        }
                        else  if(c.equalsIgnoreCase("name")){
                            lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).setName(s1.toString());
                        }
                    }
                    else if (ceng==4){
                        lp.get(lp.size()-1).getL().get(lp.get(lp.size()-1).getL().size()-1).getSwitchto().put(c2,s1.toString());
                    }

                    s1.setLength(0);
                    ceng--;
                }else {
                    ceng--;
                }
            }else{
               s1.append(ca[i]);
           }
        }





   return lp; }


    }


