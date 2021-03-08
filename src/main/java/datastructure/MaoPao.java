package datastructure;

import java.util.Arrays;

/**
 * @author linzy
 * @create 2021-03-08 11:32:01
 */
public class MaoPao {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 7, 6, 23, 21, 12, 32};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
