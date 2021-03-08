//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 977 👎 0

  
package com.codelin.leetcode.editor.cn;

import java.util.Arrays;

public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = {0, 3, 1, 0, 4};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            }
        }
        // 第一次排序逆序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int tem = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tem;
                }
            }
        }
        // 第二次正序
        for (int i = 0; i < nums.length - 1 - zeroNum; i++) {
            for (int j = 0; j < nums.length - 1 - zeroNum - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tem = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tem;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}