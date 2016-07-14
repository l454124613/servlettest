package other;

import java.util.List;

/**
 * Created by lixuecheng on 2016/7/11.
 */
public class Compare {
    public static long jiange = 10000;

    public static List Listdo(List l1, List l2) {
        //调整
        if (l2.size() >= l1.size()) {
        } else {
            List l3 = l2;
            l2 = l1;
            l1 = l3;

        }
        //比较
        for (int j = 0; j < l1.size(); j++) {
            //  Object a=m.get("ResumeId");
            if (j % jiange == 0) {
                System.out.println("10");
            }
            for (int k = 0; k < l2.size(); ) {

                if (l1.get(j).equals(l2.get(k))) {
                    l2.remove(k);
                    break;
                } else {
                    k++;
                }

            }


        }
        // System.out.println(l2);
        return l2;
    }
}
