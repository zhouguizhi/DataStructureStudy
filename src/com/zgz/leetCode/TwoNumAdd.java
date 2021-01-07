package com.zgz.leetCode;
import java.util.HashMap;
import java.util.Map;
/**
 * https://leetcode-cn.com/problems/two-sum/
 * 描述:给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案
 */
public class TwoNumAdd {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 11, 15, 2, 7, 10, 16};
        int target = 9;
        twoSum(arr,target);
    }

    /**
     * 暴力解放 不推荐
     * 思路:就是for循环二次然后相加
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int firstNum = nums[i];
            int otherNum = target-firstNum;
            for(int j=1;j<nums.length;j++){
                if(nums[j]==otherNum){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 这是使用HashMap解法 复杂度O(N)
     * 思路:利用hashMap,key是数组中的值,value是数组值对应的下标,当hashMap中没有这个key就加入
     * 比如：map:{9=0, 11=1, 15=2, 2=3, 7=4, 10=5, 16=6} 它要求相加是等于9,
     * 1:arr[0] = 9时,判断map中有没有target-arr[0] = 0; 没有就把key 9:value 0传入到map中 [9=0]
     * 2:arr[1] = 11,target-11 = -2,判断没有这个key,存入到map中, [9=0,11=1]
     * 3:arr[2] = 15,target-15 = -6,判断没有这个key,存入到map中,[9=0,11=1,15=2]
     * 4:arr[3] = 2,target-2 = 7,判断没有key,存入到map中,[9=0,11=1,15=2,2=3]
     * 5:arr[4] = 7,target-7 = 2,判断有这个key,然后就找到了
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]),i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
