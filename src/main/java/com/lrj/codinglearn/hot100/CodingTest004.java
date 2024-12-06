package com.lrj.codinglearn.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第4题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest004 {
    /**
     * 283.移动零
     * @author: luorenjie
     * @date: 2024/8/29 15:26
     * @param nums
     * @return: int
     */
    public void moveZeroes(int[] nums) {
       if (nums.length == 0 || nums.length == 1){
           return;
       }

       //快慢双指针
        int slow = 0, fast = 0;
       while (fast < nums.length){
           if (nums[fast] != 0){
               int tmp = nums[slow];
               nums[slow] = nums[fast];
               nums[fast] = tmp;
               slow++;
           }
           fast++;
       }

       System.out.println(nums);
    }

    public static void main(String[] args) {
        CodingTest004 test = new CodingTest004();
        test.moveZeroes(new int[]{0,1,0,3,12});
    }
}
