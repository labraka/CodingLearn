package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第61题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest061 {

    /**
     * 131.分割回文串
     * @author: luorenjie
     * @date: 2025/2/20 11:24
     * @param s
     * @return: java.util.List<java.util.List < java.lang.String>>
     */
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> track = new ArrayList<>();

        //回溯，从0开始
        backtrack(s, track, 0);

        return res;
    }

    private void backtrack(String s, List<String> track, int start) {
        if (start == s.length()){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < s.length(); i++) {

            //判断是否回文串，不是则返回
            if (!isHuiwen(s, start, i)){
                continue;
            }
            track.add(s.substring(start, i+1));

            //进入下一层决策树
            backtrack(s, track, i + 1);

            //退出
            track.remove(track.size() - 1);
        }
    }

    private boolean isHuiwen(String s, int l, int r) {
        //左右指针对撞，不同一定不是回文
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public static void main(String[] args) {
        CodingTest061 test = new CodingTest061();
        System.out.println(test.partition("efe"));
    }

}
