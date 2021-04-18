package juc.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author linzy
 * @create 2021-03-03 22:58:55
 * 现有5个用户，筛选
 * 1. ID必须是偶数
 * 2. 年龄必须大于23随
 * 3. 用户名转为大写字母
 * 4. 用户名字母倒序
 * 5. 只输出一个用户
 */
public class StreamTest {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(6, "e", 25);
        // 集合，存储
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        // 计算交给Stream
        list.stream().filter(user -> user.getId() % 2 == 0)
                .filter(user -> user.getAge() > 23)
                .map(user -> user.getName().toUpperCase())
                .sorted(Comparator.reverseOrder()) // 倒序
                .limit(1)
                .forEach(System.out::println);
    }

}
