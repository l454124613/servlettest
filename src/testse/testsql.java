package testse;



import java.util.List;
import java.util.Map;

import static tools.DataBase.*;

/**
 * Created by lixuecheng on 2016/6/30.
 */
public class testsql {
    public static void main(String[] args) throws Exception {
      //  List<Map<String, Object>> l3=new ArrayList<>();
        //distinct
//        String sql=" select distinct [ResumeId] from [CIICSH.RP20160612].[dbo].T_Resume";
//        String sql1="select distinct [JobseekerNo] as ResumeId from [SHDAT9103JOBDB].[dbo].[JobSeekerBasic]  where (OtherPhone!='' and OtherPhone is not null) " +
//                " or (Phone!='' and Phone is not null)" +
//                "  or (Email!='' and Email is not null)" +
//                "   or (CellPhone!='' and CellPhone is not null) ";
        //--------
//                String sql=" select top 2 [ResumeId] from [CIICSH.RP20160612].[dbo].T_Resume";
//        String sql1="select top 2 [JobseekerNo] as ResumeId from [SHDAT9103JOBDB].[dbo].[JobSeekerBasic]  where (OtherPhone!='' and OtherPhone is not null) " +
//                " or (Phone!='' and Phone is not null)" +
//                "  or (Email!='' and Email is not null)" +
//                "   or (CellPhone!='' and CellPhone is not null) ";


        //---------
        String sql="SELECT  [JobseekerNo]  as ResumeId\n" +
                " from [SHDAT9103JOBDB].[dbo].[JobSeekerBasic] \n" +
                " where ((OtherPhone!='' and OtherPhone is not null) \n" +
                "  or (Phone!='' and Phone is not null)\n" +
                "   or (Email!='' and Email is not null)\n" +
                "   or (CellPhone!='' and CellPhone is not null)) \n" +
                "  and (TrueName_En is null or TrueName_En='') \n" +
                "  and (TrueName_Jap is null or TrueName_Jap='')\n" +
                "   and (TrueName is null or TrueName='')";
        String sql1="select  [ResumeId] from [CIICSH.RP20160612].[dbo].[T_Resume] where name is null or name=''";
//
       List<Map<String, Object>> l = select(sql,1);
        System.out.println(l.size());
        List<Map<String, Object>> l2 = select(sql1);
        System.out.println(l2.size());
//l2chang
//        List l=new ArrayList();
//        List l2=new ArrayList();
//        for (int i = 0; i <99999 ; i++) {
//            l.add(i);
//
//        }
//        for (int i = 0; i <100000 ; i++) {
//            l2.add(i);
//
//        }

        //调整
        if(l2.size()>=l.size()){}else{
            List l3=l2;
            l2=l;
            l=l3;

        }



        //比较
        for (int j = 0; j <l.size() ; j++) {
          //  Object a=m.get("ResumeId");
if(j%10000==0){
    System.out.println("10");
}
            for (int k = 0; k <l2.size() ; ) {

                if(l.get(j).equals(l2.get(k))){
                    l2.remove(k);
                    break;
                }else{
                    k++;
                }

            }


        }
        System.out.println(l2);
    }
}
