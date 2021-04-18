package annotation;

/**
 * 编写泛型
 * @author linzy
 * @create 2021-01-20 15:53:23
 */

// 泛型类型<T>不能用于静态方法
public class Pair<T> {

    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public boolean same (T t) {
        return this == t;
    }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}
