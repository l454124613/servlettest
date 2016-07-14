package pageson;

import java.util.Map;

/**
 * Created by lixuecheng on 2016/6/22.
 */
public class eleson {
    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getSwitchto() {
        return switchto;
    }

    public void setSwitchto(Map<String, String> switchto) {
        this.switchto = switchto;
    }

    @Override
    public String toString() {
        return "eleson{" +
                "op='" + op + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", switchto=" + switchto +
                '}';
    }

    String op="";
    String type="";
    String value="";
    String name="";
    Map<String,String> switchto;

}

