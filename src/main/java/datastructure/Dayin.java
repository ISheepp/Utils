package datastructure;

/**
 * @author linzy
 * @create 2021-03-11 13:51:39
 */
public class Dayin {
    public static void main(String[] args) {
        Da da = new Da();
        Thread a = new Thread(()->{
            synchronized (da) {
                da.print();
            }
        });

        Thread b = new Thread(()->{
            synchronized (da) {
                da.print();
            }
        });

        Thread c = new Thread(()->{
            synchronized (da) {
                da.print();
            }
        });

        a.start();
        b.start();
        c.start();
    }
}

class Da {
    static int num = 1;
    public void print() {
        for (int i = 0; i < 10; i++) {
            if (num == 1) {
                System.out.println("A");
            } else if (num == 2) {
                System.out.println("B");
            } else if (num == 3) {
                System.out.println("C");
            }
            num++;
        }
    }
}
