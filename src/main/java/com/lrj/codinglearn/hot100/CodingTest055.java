package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第55题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest055 {

    /**
     * 46.全排列
     * @author: luorenjie
     * @date: 2025/2/10 14:12
     * @param nums
     * @return: List<List < Integer>>
     */
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        List<Integer> track = new ArrayList<>();

        //回溯
        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, boolean[] used) {
        if (nums.length == track.size()){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            //开始选择
            used[i] = true;
            track.add(nums[i]);

            //进入下一层决策树
            backtrack(nums, track, used);

            //取消选择
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        CodingTest055 test = new CodingTest055();
        System.out.println(test.permute(new int[]{1,2,3}));
    }

}
