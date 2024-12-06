package com.lrj.codinglearn.hot100;

import java.util.*;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第15题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest015 {

    /**
     * 189.轮转数组
     * @author: luorenjie
     * @date: 2024/9/13 10:54
     * @param nums
     * @param k
     * @return: void
     */
    public void rotate(int[] nums, int k) {

        /*

        //方法一：利用新数组
       int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(arr, 0, nums, 0, nums.length);



        */


        //方法二：翻转数组
        int n = nums.length;
        k %= n; // 轮转 k 次等于轮转 k%n 次
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        System.out.println(nums);



    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        CodingTest015 test = new CodingTest015();
        test.rotate(new int[]{-1}, 2);
    }
}
