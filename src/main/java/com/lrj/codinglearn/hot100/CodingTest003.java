package com.lrj.codinglearn.hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第3题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest003 {
    /**
     * 128.最长连续序列
     * @author: luorenjie
     * @date: 2024/8/29 15:26
     * @param nums
     * @return: int
     */
    public int longestConsecutive(int[] nums) {
        //采用数组排序和双指针法
        int res = 1, cur = 1;
        int p1 = -1, p2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        while (p1 < p2 && p2 < list.size() - 1){
            p1++;
            p2++;
            if (list.get(p2) - list.get(p1) != 1){
                res = Math.max(cur, res);
                cur = 1;
                continue;
            }
            cur++;
        }
        return Math.max(cur, res);
    }

    public static void main(String[] args) {
        CodingTest003 test = new CodingTest003();
        System.out.println(test.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }
}
