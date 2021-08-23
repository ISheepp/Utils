package zkTest;

/**
 * @author 林子洋靓
 * @create 2021-06-02 15:53:13
 */
public class Sheep<T> {

    private T name;

    // 方法前标明<F>则表示这个方法中的F不与类中的F冲突
    public <F> F getLzyTest(F t) {
        return t;
    }
}
