import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class JsonUtil {

    public static String getJson(Object object) {

        ObjectMapper mapper = new ObjectMapper();
        //关闭时间戳功能
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 指定日期格式为SimpleDateFormat
        mapper.setDateFormat(sdf);
        Date date = new Date();

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return null;

    }

}
