package com.lrj.codinglearn.hot100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第12题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest012 {

    /**
     * 76.最小覆盖子串
     * @author: luorenjie
     * @date: 2024/9/10 14:40
     * @param s
     * @param t
     * @return: java.lang.String
     */
    public String minWindow(String s, String t) {
        //滑动窗口
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //初始化目标字符串到缓存中
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //设置窗口指针
        int left = 0, right = 0;

        //设置起始值和窗口长度
        int start = 0, len = Integer.MAX_VALUE;

        //设置目标字符出现次数
        int valid = 0;

        while (right < s.length()){
            char c = s.charAt(right);

            //扩大窗口
            right++;

            //当前字符匹配则滑入窗口
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果缓存字符出现次数和窗口中字符出现次数一致，则增加出现次数
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            //如果字符出现次数和缓存大小一致
            while (valid == need.size()){
                //更新窗口起始值和窗口大小
                if (right - left < len){
                    start = left;
                    len = right - left;
                }

                //需要删除的字符
                char d = s.charAt(left);

                //缩小窗口
                left++;

                if (need.containsKey(d)){
                    //如果缓存字符出现次数和窗口中字符出现次数一致，则减少出现次数
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                }

                window.put(d, window.getOrDefault(d, 0) - 1);
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        CodingTest012 test = new CodingTest012();
        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
    }
}
