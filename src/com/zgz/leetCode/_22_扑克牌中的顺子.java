package com.zgz.leetCode;
import java.util.Arrays;
/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)…他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
 * 不是顺子…..LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,
 * 然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0
 *
 * 思路:
 * 第一步:去除0
 * 第二步:看有没有重复数字 如果有是步可能是顺子
 * 第三步:看除了0意外的最大最小值  他们的差是不是等于4
 */
public class _22_扑克牌中的顺子 {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 0,0};  // true
        System.out.println(isStraight(array));
    }
    public static boolean isStraight(int[] nums){
        if(nums==null||nums.length!=5){
            return false;
        }
        //对数组进行排序
        Arrays.sort(nums);
        //去除0 因为前面已经对数组进行了排序,所以如果有0肯定是会出现在第一个 在数字中
        int k=0;
        while (nums[k]==0){
            k++;
        }
        //判断有没有重复的数字
        for(int i=k+1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return false;
            }
        }
        return nums[4]-nums[k]<=4;
    }
}
