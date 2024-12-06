package com.lrj.codinglearn.hot100;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第16题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest016 {

    /**
     * 238.除自身以外数组的乘积
     * @author: luorenjie
     * @date: 2024/9/14 11:50
     * @param nums
     * @return: int[]
     */
    public int[] productExceptSelf(int[] nums) {

        /**
         * 计算左右三角形面积，将对角线分割
         *
         *  1   2   3   4   5
         *  1   1   3   4   5
         *  1   2   1   4   5
         *  1   2   3   1   5
         *  1   2   3   4   1
         *
         */

        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        //计算左三角
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        //计算右三角
        int tmp = 1;
        for (int i = n - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            res[i] *= tmp;
        }

        return res;
    }

    public static void main(String[] args) {
        CodingTest016 test = new CodingTest016();
        test.productExceptSelf(new int[]{1,2,3,4,5});
        test.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
}
