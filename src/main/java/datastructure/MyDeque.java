package datastructure;

/**
 * @author linzy
 * @create 2021-03-06 14:19:54
 */
public class MyDeque<T> {
    public int maxSize = 8; // 默认队列容量为8
    public int size = 0; // 双端队列的长度
    public MyNode<T> first; // 首节点
    public MyNode<T> last; // 尾节点

    // 构造器
    public MyDeque() {

    }

    // 构造器
    public MyDeque(int maxSize) {
        this.maxSize = maxSize;
    }

    // 清空队列
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    // 在首部添加
    public void addToFront(T t) throws Exception {
        MyNode<T> node = new MyNode<T>();
        node.data = t;
        if (size == 0) {
            first = node;
            last = node;
            size++;
        } else if (size < maxSize) {
            node.setAfter(first);
            first.setBefore(node);
            first = node;
            size++;
        } else {
            throw new Exception("队列已满！");
        }
    }

    // 在尾部添加
    public void addToBack(T t) throws Exception {
        MyNode<T> node = new MyNode<T>();
        node.data = t;
        if (size == 0) {
            first = node;
            last = node;
            size++;
        } else if (size < maxSize) {
            node.setBefore(last);
            last.setAfter(node);
            last = node;
            size++;
        } else {
            throw new Exception("队列已满！");
        }
    }

    // 从首部删除
    public void removeFront() throws Exception {
        if (size == 0) {
            throw new Exception("队列为空");
        } else if (size == 1) {
            clear();
        } else {
            first = first.getAfter();
            first.setBefore(null);
            size--;
        }
    }

    // 从尾部删除
    public void removeBack() throws Exception {
        if (size == 0) {
            throw new Exception("队列为空");
        } else if (size == 1) {
            clear();
        } else {
            last = last.getBefore();
            last.setAfter(null);
            size--;
        }
    }

    // 获取首部元素
    public T getFront() {
        if (size == 0) {
            return null;
        } else {
            return first.data;
        }
    }

    // 获取尾部元素
    public T getBack() {
        if (size == 0) {
            return null;
        } else {
            return last.data;
        }
    }

    // 判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //判断是否队列已满
    public boolean isFull(){
        return size==maxSize;
    }

    //获取队列长度
    public int size(){
        return size;
    }

    // 输出队列全部内容
    public void displayAll() {
        if (size != 0) {
            MyNode<T> node = first;
            while (node != null) {
                node.display();
                node = node.getAfter();
            }
        }
    }
}