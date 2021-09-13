import aenum.MyEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author linzy
 * @create 2021-03-06 20:55:53
 */
public class EnumTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("table.types", "默认情况下，JDBC 连接器只会从源数据库中检测类型为 TABLE 的表。 此配置允许提取表类型的命令分隔列表。 选项包括：\n" +
                "* TABLE\n" +
                "* VIEW\n" +
                "* SYSTEM TABLE\n" +
                "* GLOBAL TEMPORARY\n" +
                "* LOCAL TEMPORARY\n" +
                "* ALIAS\n" +
                "* SYNONYM\n" +
                "在大多数情况下，只有 TABLE 或 VIEW 才有意义。");
        map.forEach((k, v) ->{
            System.out.println("key: " + k + " value: " + v);
        });
    }

}
