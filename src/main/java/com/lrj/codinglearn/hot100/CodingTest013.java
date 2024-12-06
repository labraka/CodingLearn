package com.lrj.codinglearn.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第13题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest013 {

    /**
     * 53.最大子数组和
     * @author: luorenjie
     * @date: 2024/9/11 12:02
     * @param nums
     * @return: int
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        //动态规划dp
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        CodingTest013 test = new CodingTest013();
        System.out.println(test.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
