package pageson;

import java.util.List;

/**
 * Created by lixuecheng on 2016/6/22.
 */
public class pageson {
    String name="";
    List<eleson> l=null;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "pageson{" +
                "name='" + name + '\'' +
                ", l=" + l +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<eleson> getL() {
        return l;
    }

    public void setL(List<eleson> l) {
        this.l = l;
    }
    public  void add(eleson e){
        l.add(e);
    }
}
