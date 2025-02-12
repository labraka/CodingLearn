package com.lrj.codinglearn.hot100;


import java.util.*;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第57题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest057 {

    /**
     * 17.电话号码的字母组合
     * @author: luorenjie
     * @date: 2025/2/11 15:29
     * @param digits
     * @return: java.util.List<java.lang.String>
     */
    //创建映射
    List<String> letters = new ArrayList<>(Arrays.asList(
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ));
    List<String> res;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        sb = new StringBuilder();

        if (digits.isEmpty()){
            return res;
        }

        //回溯，从0开始
        backtack(digits, 0);

        return res;
    }

    private void backtack(String digits, int start) {
        if (digits.length() == sb.length()){
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(start) - '0';
        for (char c : letters.get(digit).toCharArray()) {
            sb.append(c);

            //进入下一层决策树
            backtack(digits, start + 1);

            //退出
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        CodingTest057 test = new CodingTest057();
        System.out.println(test.letterCombinations(""));
    }

}
