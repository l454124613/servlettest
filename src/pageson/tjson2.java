package pageson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by lixuecheng on 2016/7/15.
 */
public class tjson2 {
    public static String   aa(Object p) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(outputFormat);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
       return mapper.writeValueAsString(p);



    }

    public static void main(String[] args) throws IOException {
       // new tjson2().aa();
        System.out.println("11");
    }
}
