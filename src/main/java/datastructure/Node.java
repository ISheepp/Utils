package datastructure;

import java.awt.*;

/**
 * @author linzy
 * @create 2021-03-01 14:45:03
 */
public class Node {

    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node() {}

    // 头节点
    private Node head;
    // 尾节点
    private Node last;
    // size
    private int size;

    public void insert(int data, int index) {
        Node node = new Node(data);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出长度");
        }
        if (size == 0) {
            head = node;
            last = node;
        } else if (index == 0) {
            // 插入头部
            node.next = head;
            head = node;
        } else if (index == size) {
            // 插入尾部
            last.next = node;
            last = node;
        } else {
            // 插入中间
            Node pre = get(index - 1);
            node.next = pre.next;
            pre.next = node;
        }
        size++;
    }

    // 删除节点
    public Node delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("不存在");
        }
        Node removedNode = null;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // last = get(index - 2);
            // last.next = null;
            Node prevNode = get(index-1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            // 删除中间
            // Node pre = get(index - 2);
            // pre.next = get(index);
            Node prevNode = get(index-1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    // 查找节点
    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("不存在");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    // 输出
    public void output() {
        Node tem = head;
        while (tem != null) {
            System.out.println(tem.data);
            tem = tem.next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.insert(3, 0);
        node.insert(33, 1);
        node.insert(44, 2);
        node.insert(222222, 1);
        node.output();
        System.out.println("===================");
        node.delete(3);
        node.output();
        // System.out.println(node.size);
    }
}

