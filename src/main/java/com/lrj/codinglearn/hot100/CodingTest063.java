package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第63题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest063 {

    /**
     * 35.搜索插入位置
     * @author: luorenjie
     * @date: 2025/2/25 15:49
     * @param nums
     * @param target
     * @return: int
     */
    public int searchInsert(int[] nums, int target) {
        //二分查找
        int l = 0, r = nums.length-1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            //找到则返回下标
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        //否则则返回左指针
        return l;
    }

    public static void main(String[] args) {
        CodingTest063 test = new CodingTest063();
        System.out.println(test.searchInsert(new int[]{1,3,5,6}, 7));
    }

}
