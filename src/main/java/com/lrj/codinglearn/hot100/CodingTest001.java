package com.lrj.codinglearn.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第1题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest001 {
    /**
     * 1.两数之和
     * @author: luorenjie
     * @date: 2024/8/28 17:05
     * @param nums
     * @param target
     * @return: int[]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.get(another) != null){
                res[0] = i;
                res[1] = map.get(another);
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }


    public static void main(String[] args) {
        CodingTest001 test = new CodingTest001();
        System.out.println(test.twoSum(new int[]{3,2,4}, 6));
    }

}
