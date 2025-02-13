package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第58题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest058 {

    /**
     * 39.组合总和
     * @author: luorenjie
     * @date: 2025/2/12 16:48
     * @param candidates
     * @param target
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     */
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0){
            return res;
        }
        res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();

        //回溯 从0开始
        backtrack(candidates, 0, track, target, 0);

        return res;
    }

    /**
     * 回溯
     * @param candidates 原数组
     * @param start      开始下标
     * @param track      集合
     * @param sum        累加求和
     * @param target     目标值
     * @author: luorenjie
     * @date: 2025/2/13 11:00
     * @return: void
     */
    private void backtrack(int[] candidates, int start, List<Integer> track, int target, int sum) {
        //当累加和等于目标值，则添加路径集合并返回
        if (sum == target){
            res.add(new ArrayList<>(track));
            return;
        }

        //当累加和大于目标值，则直接返回
        if (sum > target){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //进入
            track.add(candidates[i]);
            sum += candidates[i];
            //进入下一层决策树
            backtrack(candidates, i, track, target, sum);
            //退出
            sum -= candidates[i];
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        CodingTest058 test = new CodingTest058();
        System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}
