package datastructure;

/**
 * @author linzy
 * @create 2021-03-06 14:53:06
 */
public class MyNode<T> {
    public MyNode<T> before;
    public MyNode<T> after;
    public T data;

    // 构造器
    public MyNode() {

    }

    // 构造器
    public MyNode(T t) {
        this.data = t;
    }

    public MyNode<T> getBefore() {
        return before;
    }

    public void setBefore(MyNode<T> before) {
        this.before = before;
    }

    public MyNode<T> getAfter() {
        return after;
    }

    public void setAfter(MyNode<T> after) {
        this.after = after;
    }

    public void display() {
        System.out.println(data + " ");
    }
}