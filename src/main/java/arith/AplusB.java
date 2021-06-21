package arith;

/**
 * @author 林子洋
 * @create 2021-06-18 10:03:11
 */
public class AplusB {

    public static void main(String[] args) {
        // System.out.println(plus1(5, 6));
        System.out.println(reverseInteger(230));
    }

    /**
     * 加法
     * 不使用+
     * @param a a
     * @param b b
     * @return int
     */
    public static int plus1(int a, int b) {
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }

    /**
     * 三位整数转换
     *
     * @param number 三位整数
     * @return int
     */
    public static int reverseInteger(int number) {
        // write your code here
        int a, b, c;
        // 900
        if(number % 100 == 0) {
            return number / 100;
        }
        // 920
        else if (number % 10 == 0) {
            a = number / 100;
            b = number % 100 / 10;
            return b * 10 + a;
        } else {
            a = number / 100;
            b = number % 100 / 10;
            c = number % 10;
            return c * 100 + b * 10 + a;
        }
    }

}
