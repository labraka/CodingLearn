package com.lrj.codinglearn.hot100;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第65题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest065 {

    /**
     * 34.在排序数组中查找元素的第一个和最后一个位置
     * @param nums
     * @param target
     * @author: luorenjie
     * @date: 2025/2/26 11:35
     * @return: int[]
     */
    public int[] searchRange(int[] nums, int target) {
        //设置左开右闭边界，分别二分查找
        int l = 0, r = nums.length - 1;
        //设置返回参数
        int[] res = new int[2];
        //收缩右侧边界
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        //判断左边界和值
        if (l >= nums.length || nums[l] != target) {
            res[0] = -1;
        } else {
            res[0] = l;
        }

        //坐标还原
        l = 0;
        r = nums.length - 1;
        //收缩左侧边界
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        //判断右边界和值
        if (r < 0 || nums[r] != target) {
            res[1] = -1;
        } else {
            res[1] = r;
        }

        return res;
    }


    public static void main(String[] args) {
        CodingTest065 test = new CodingTest065();
        System.out.println(test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(test.searchRange(new int[]{}, 8));
    }

}
