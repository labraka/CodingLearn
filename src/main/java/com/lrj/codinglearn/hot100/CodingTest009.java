package com.lrj.codinglearn.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第9题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest009 {

    /**
     * 438.找到字符串中所有字母异位词
     * @author: luorenjie
     * @date: 2024/9/5 11:08
     * @param s
     * @param p
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        //使用滑动窗口的方式，和need中的匹配

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();

        //设置一个字符出现次数统计
        int valid = 0;

        while (right < s.length()){
            char c = s.charAt(right);

            //扩大窗口
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            //缩小窗口
            while (right - left >= p.length()){

                //判断是否找到子串
                if (valid == need.size()){
                    res.add(left);
                }

                //移除窗口的字符
                char d = s.charAt(left);

                left++;

                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                }

                window.put(d, window.getOrDefault(d, 0) - 1);

            }

        }

        return res;
    }

    public static void main(String[] args) {
        CodingTest009 test = new CodingTest009();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
    }
}
