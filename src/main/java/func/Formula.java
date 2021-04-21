package func;

/**
 * @author linzy
 * @create 2021-04-21 10:32:58
 */
@FunctionalInterface
public interface Formula {
    // 计算
    double calculate(int a);

    // 求平方根
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}