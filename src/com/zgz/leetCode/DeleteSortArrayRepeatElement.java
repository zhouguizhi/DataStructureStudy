package com.zgz.leetCode;
/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * 描述:给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 * 例子:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class DeleteSortArrayRepeatElement {
    public static void main(String[] args) {
        int[]  nums = {1,1,2,2,3,4,5};
        int index = removeDuplicates(nums);
    }

    /**
     * 思路:这个是要求不能引入新数组,如果能引入新的数组那么就简单了,直接用一个新数组,判断没有就加入，或者最简单的就是使用集合
     * 解决这个题目可以参考下判断链表是否有环,它就是使用快慢指针的,for循环遍历数组中的数组,然后在for循环外面定义一个变量,在for
     * 循环中取判断
     * @param nums {1,1,2,2,3,4,5}
     * @return 返回新数组的长度
     */
    public static int removeDuplicates(int[] nums) {
        if (nums==null||nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
