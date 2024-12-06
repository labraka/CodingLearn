package com.lrj.codinglearn.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第10题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest010 {

    /**
     * 560.和为 K 的子数组
     * @author: luorenjie
     * @date: 2024/9/6 15:35
     * @param nums
     * @param k
     * @return: int
     */
    public int subarraySum(int[] nums, int k) {
        //前缀和求解，统计[0,i]前缀和出现的次数
        Map<Integer,Integer> preSum = new HashMap<>();
        //前缀和为0的，只有一个
        preSum.put(0,1);
        int res = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int j = sum - k;

            if (preSum.containsKey(j)){
                res += preSum.get(j);
            }

            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        CodingTest010 test = new CodingTest010();
        System.out.println(test.subarraySum(new int[]{1,1,2}, 3));
    }
}
