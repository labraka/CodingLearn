package com.lrj.codinglearn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第7题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest007 {

    /**
     * 42.接雨水
     * @author: luorenjie
     * @date: 2024/9/3 10:45
     * @param height
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     */
    public int trap(int[] height) {
        //使用左右双指针，收缩计算
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax){
                res += leftMax - height[left];
                left++;
            }else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        CodingTest007 test = new CodingTest007();
        System.out.println(test.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
