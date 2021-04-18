package datastructure;

/**
 * @author linzy
 * @create 2021-03-01 15:22:48
 * 一直到 (队尾下标 + 1) % 数组长度 = 队头下标 时，代表此队列真的已经满了。
 * 需要注意的是，队尾指针指向的位置永远空出 1 位，所以队列最大容量比数组长度小 1。
 */
public class MyQueue {
    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity){
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element 入队的元素
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满！");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     */
    public int deQueue() throws Exception {
        if(rear == front){
            throw new Exception("队列已空！");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void output(){
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(6);
        myQueue.enQueue(3);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(8);
        myQueue.enQueue(1);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(2);
        myQueue.enQueue(4);
        myQueue.enQueue(9);
        myQueue.output();
    }

}
