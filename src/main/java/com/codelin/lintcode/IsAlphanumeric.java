package com.codelin.lintcode;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * @author 林子洋
 * @create 2021-06-22 13:24:04
 */
public class IsAlphanumeric {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] num = {9,8,7,6,5,4,3,2,1,0};
        solution.prime(5);
        System.out.println();
    }

}

class Solution {

    /**
     * 判断输入的是否是英文字符和数字以外的字符
     *
     * @param c 输入字符
     * @return boolean
     */
    public boolean test(char c) {
        String s = String.valueOf(c);
        String pattern = "[A-Za-z0-9]";
        return Pattern.matches(pattern, s);
    }

    /**
     * 小写转大写
     *
     * @param character 输入字符
     * @return char
     */
    public char lowercaseToUppercase(char character) {
        // write your code here
        int i = (int) character - 32;
        // char c = Character.toUpperCase(character);
        return (char)i;
    }

    /**
     * 输入年月计算天数
     *
     * @param year 年
     * @param month 月
     * @return 当月天数
     */
    public int getTheMonthDays(int year, int month) {
        Set<Integer> set = Sets.newHashSet(1, 3, 5, 7, 8, 10, 12);
        if (set.contains(month)) {
            return 31;
        }
        if (month != 2) {
            return 30;
        }
        if (year % 4 != 0 || year % 100 == 0) {
            return 28;
        }
        return 29;
    }

    /**
     * 简单计算器
     *
     * @param a: An integer
     * @param operator: A character, +, -, *, /.
     * @param b: An integer
     * @return The result
     */
    public int calculate(int a, char operator, int b) {
        // write your code here
        if (operator == '+') {
            return a + b;
        }
        if (operator == '-') {
            return a - b;
        }
        if (operator == '*') {
            return a * b;
        }
        if (operator == '/') {
            return a / b;
        }
        return 0;
    }

    /**
     * 返回三个整数中最大的值
     *
     * @param num1: An integer
     * @param num2: An integer
     * @param num3: An integer
     * @return an integer
     */
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // write your code here
        List<Integer> list = Lists.newArrayList(num1, num2, num3);
        return Collections.max(list);

    }

    /**
     * 打印大X
     * @param n 行数
     * @return list
     */
    public List<String> printX(int n) {
        // write your code here
        ArrayList<String> list = Lists.newArrayList();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == 1 || j == n - i - 1) {
                    sb.append("X");
                } else {
                    sb.append(" ");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    /**
     * 给你一个大小size,生成一个元素从1 到 size的数组
     * @param size size
     * @return list
     */
    public List<Integer> generate(int size) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序
     * 1.必须在原数组上操作
     * 2.最小化操作数
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        // 1. 两次循环
        /*int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }*/

        // 2. 双指针
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                if (nums[slow] == 0) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                }
                slow++;
            }
            fast++;
        }

    }

    /**
     * 寻找n个数中的最大值
     *
     * @param nums nums
     * @return int
     */
    public int maxNum(List<Integer> nums) {
        // write your code here
        return Collections.max(nums);
    }

    /**
     * 交换数组两个元素
     * 给你一个数组和两个索引，交换下标为这两个索引的数字
     * 输入:  [1, 2, 3, 4], index1 = 2, index2 = 3
     * 输出:  交换后你的数组应该是[1, 2, 4, 3]， 不需要返回任何值，只要就地对数组进行交换即可。
     * 样例解释: 就地交换，不需要返回值。
     *
     * @param A: An integer array
     * @param index1: the first index
     * @param index2: the second index
     */
    public void swapIntegers(int[] A, int index1, int index2) {
        // write your code here
        int temp;
        temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    /**
     * 给定整数 n ，按照如下规则打印从 1 到 n 的每个数：
     *
     * 如果这个数被3整除，打印fizz。
     * 如果这个数被5整除，打印buzz。
     * 如果这个数能同时被3和5整除，打印fizz buzz。
     * 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
     *
     * @param n: An integer
     * @return A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            String s = help(i, 3, "fizz") + help(i, 15, " ") + help(i, 5, "buzz");
            if ("".equals(s)) {
                list.add("" + i);
            }else{ list.add(s);}

        }
        return list;
    }

    /**
     * 除法工具类
     * @param n 被除数
     * @param div 除数
     * @param s 打印的字符串
     * @return String
     */
    public String help(int n, int div, String s) {
        return n % div == 0 ? s : "";
    }

    /**
     * 数学家们曾提出一个著名的猜想——冰雹猜想。
     * 对于任意一个自然数N，如果N是偶数，就把它变成N / 2；
     * 如果N是奇数，就把它变成 3 * N+1。
     * 按照这个法则运算下去，最终必然得1。
     * 试问，该数通过几轮变换，会变成1呢？
     *
     * @param num: an integer
     * @return return an integer
     */
    public int getAnswer(int num) {
        // write your code here.
        int temp = 0;
        if (num < 0 || num > 1000) {
            return 0;
        }
        // 偶数
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                temp++;
            } else {
                num = 3 * num + 1;
                temp++;
            }
        }
        return temp;
    }

    /**
     * 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。
     *
     * 该数字按照数位高低进行排列，最高位的数在列表的最前面。
     *
     * @param digits: a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        long l = Long.parseLong(sb.toString()) + 1;
        // int 可能会导致数组太长而溢出 java.lang.NumberFormatException::For input string: "9876543210"
        // int i = Integer.parseInt(sb.toString()) + 1;
        String s = l + "";
        int[] answer = new int[s.length()];
        for (int j = 0; j < s.length(); j++) {
            int integer = Integer.parseInt(String.valueOf(s.charAt(j)));
            answer[j] = integer;
        }
        return answer;
    }

    /**
     * 判断一个非负整数 n 的二进制表示是否为回文数 我们保证 0 <= n <= 2^32 - 1
     *
     * 样例1
     *
     * 输入: n = 0
     * 输出: True
     * 解释:
     * 0 的二进制表示为：0。
     * 样例2
     *
     * 输入: n = 3
     * 输出: True
     * 解释:
     * 3 的二进制表示为：11。
     * 样例3
     *
     * 输入: n = 4
     * 输出: False
     * 解释:
     * 4 的二进制表示为：100。
     * 样例4
     *
     * 输入: n = 6
     * 输出: False
     * 解释:
     * 6 的二进制表示为：110。
     *
     * @param n: non-negative integer n.
     * @return return whether a binary representation of a non-negative integer n is a palindrome.
     */
    public boolean isPalindrome(int n) {
        // Write your code here
        String binaryString = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(binaryString);
        return binaryString.equals(sb.reverse().toString());
    }

    /**
     * 寻找素数n以内 100以内
     *
     * @param n: an integer
     * @return return all prime numbers within n.
     */
    public List<Integer> prime(int n) {
        // write your code here
        int num = 0;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    num++;
                }
            }
        }
        System.out.println(num);
        return null;
    }

}
