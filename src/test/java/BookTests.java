import entity.Weekday;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * @author linzy
 * @create 2021-01-20 21:28:46
 */
public class BookTests {

    @Test
    public void test1(){
        System.err.println(Math.random());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw");
        int n = in.nextInt();

        // fill an array with numbers 1 2 3 ... n
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);

            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }
        // print the sorted arrays
        Arrays.sort(result);
        System.err.println("Bet the following combination. It'll make you rich!");
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 测试LocalDate
     */
    @Test
    public void testForLocalDate(){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        // 设置这个月的第一天
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        // 星期几 2021-1-1星期五 FRIDAY
        System.out.println(weekday);
        // 数字5
        int value = weekday.getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < value; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
    }

}
