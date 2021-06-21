package arith;

/**
 * @author 林子洋
 * @create 2021-06-17 16:22:58
 */
public class swapAB {

    public static void main(String[] args) {
        int a = 8;
        int b = 5;
        System.out.println(a ^ b);
        // swap(a, b);
        // System.out.println(aplusb(a, b));
    }

    private static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }

    public static int aplusb(int a, int b) {
        // write your code here
        if (b == 0)
            return a;
        else
            return aplusb(a ^ b, (a & b) << 1);
    }


}

