package com.lrj.codinglearn.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第2题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest002 {
    /**
     * 49.字母异位词分组
     * @author: luorenjie
     * @date: 2024/8/29 11:32
     * @param strs
     * @return: java.util.List<java.util.List < java.lang.String>>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String cl = encode(str);
            if (!map.containsKey(cl)){
                map.put(cl, new ArrayList<>());
            }
            map.get(cl).add(str);
        }
        List<List<String>> resList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            resList.add(entry.getValue());
        }

        return resList;
    }

    private String encode(String str){
        char[] count = new char[26];
        for (char c : str.toCharArray()) {
            int detal = c - 'a';
            count[detal]++;
        }
        return new String(count);
    }

    public static void main(String[] args) {
        CodingTest002 test = new CodingTest002();
        System.out.println(test.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
