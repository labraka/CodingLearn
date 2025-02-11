package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第55题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest056 {


    /**
     * 78.子集
     * @author: luorenjie
     * @date: 2025/2/10 15:23
     * @param nums
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     */
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();

        //回溯，从数组下标零开始
        backtrack(nums, track, 0);

        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return a.size() - b.size();
            }
        });
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, int start) {
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);

            //进入下一层决策树
            backtrack(nums, track, i + 1);

            //退出
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        CodingTest056 test = new CodingTest056();
        System.out.println(test.subsets(new int[]{1,2,3}));
    }

}
