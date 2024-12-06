package com.lrj.codinglearn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第6题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest006 {

    /**
     * 15.三数之和
     * @author: luorenjie
     * @date: 2024/9/2 10:18
     * @param nums
     * @return: List<List < Integer>>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length == 0 || nums.length < 3){
            return resList;
        }

        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    resList.add(Arrays.asList( nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        CodingTest006 test = new CodingTest006();
        System.out.println(test.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
