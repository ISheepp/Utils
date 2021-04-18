package lxf.clazzTest;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * @author linzy
 * @create 2021-01-15 11:21:41
 */
public class ClazzTest {
    
    @Test
    public void testStringJoiner(){
        String[] names = {"Bob", "Alice", "Grace"};
        String join = String.join(", ", names);
        System.err.println(join);
    }

    public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }
    static String buildSelectSql(String table, String[] fields) {
        // TODO:
        StringJoiner joiner = new StringJoiner(", ", "SELECT ", " FROM " + table);
        for (String field : fields) {
            joiner.add(field);
        }
        return joiner.toString();
    }
    
}
