package com.lrj.codinglearn.hot100;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第5题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest005 {
    /**
     * 11.盛最多水的容器
     * @author: luorenjie
     * @date: 2024/8/30 16:23
     * @param height
     * @return: int
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        //双指针收缩，计算最左到最右的面积，每次得到最大面积即可
        while (left < right){
            int cur = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur);

            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        CodingTest005 test = new CodingTest005();
        System.out.println(test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
