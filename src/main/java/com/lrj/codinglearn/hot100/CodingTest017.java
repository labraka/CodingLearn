package com.lrj.codinglearn.hot100;

import java.util.Arrays;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第17题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest017 {

    /**
     * 41.缺失的第一个正数
     * @author: luorenjie
     * @date: 2024/9/18 11:30
     * @param nums
     * @return: int
     */
    public int firstMissingPositive(int[] nums) {
        //先给数组正序排序
        Arrays.sort(nums);
        int res = 0;

        for (int num : nums) {
            //排除小于1的数
            if (num < 1){
                continue;
            }

            //如果当前数不按顺序增长，则代表结果的后一个数没出现
            if (num > res + 1){
                return res + 1;
            }
            res = num;
        }

        return res + 1;
    }

    public static void main(String[] args) {
        CodingTest017 test = new CodingTest017();
        System.out.println(test.firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
        System.out.println(test.firstMissingPositive(new int[]{-1, 1, 0, -3, 3}));
        System.out.println(test.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(test.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(test.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
