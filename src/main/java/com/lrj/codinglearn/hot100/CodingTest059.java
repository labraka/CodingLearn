package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第59题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest059 {

    /**
     * 22.括号生成
     * @author: luorenjie
     * @date: 2025/2/13 11:24
     * @param n
     * @return: java.util.List<java.lang.String>
     */
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        //回溯，左右括号要对称，从最大数量开始递减
        backtrack(n, n, sb);

        return res;
    }

    private void backtrack(int left, int right, StringBuilder sb) {
        //左右括号都已放完，则添加值并返回
        if (left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }

        //左右括号不等，或者递减小于0了，则返回
        if (left < 0 || right < 0 || right < left){
            return;
        }

        //尝试添加左括号
        sb.append("(");
        //进入下一层决策树
        backtrack(left - 1, right, sb);
        //退出
        sb.deleteCharAt(sb.length() - 1);


        //尝试添加右括号
        sb.append(")");
        //进入下一层决策树
        backtrack(left, right - 1, sb);
        //退出
        sb.deleteCharAt(sb.length() - 1);

    }


    public static void main(String[] args) {
        CodingTest059 test = new CodingTest059();
        System.out.println(test.generateParenthesis(7));
    }

}
