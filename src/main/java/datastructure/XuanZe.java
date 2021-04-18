package datastructure;

import java.util.Arrays;

/**
 * @author linzy
 * @create 2021-03-08 11:32:18
 */
public class XuanZe {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 7, 6, 23, 21, 12, 32};
        int minIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        System.out.println(Arrays.toString(nums));
    }

}
