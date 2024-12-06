package com.lrj.codinglearn.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第8题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest008 {

    /**
     * 3.无重复字符的最长子串
     * @author: luorenjie
     * @date: 2024/9/4 17:56
     * @param s
     * @return: int
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s.length();
        }

        //滑动窗口
        int left = 0, right = 0;
        int sum = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < s.length()){
            char c = s.charAt(right);

            //扩大窗口
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1){
                //需要删除窗口左侧字符，并缩小窗口
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            //计算步长
            sum = Math.max(sum, right - left);
        }

        return sum;
    }

    public static void main(String[] args) {
        CodingTest008 test = new CodingTest008();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
}
