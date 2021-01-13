package com.zgz.leetCode;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * 描述:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * example:
 * 输入: [2,2,1]
 * 输出: 1
 */
public class OnlyAppearOneInteger {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println("result:="+singleNumber1(arr));
        System.out.println("result:="+(0^4));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    public static int singleNumber1(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
