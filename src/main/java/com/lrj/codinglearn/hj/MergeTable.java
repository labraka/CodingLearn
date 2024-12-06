package com.lrj.codinglearn.hj;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: MergeTable
 * @Description:
 * @Date: 2023/4/19 15:01
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class MergeTable {

    /**
     * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
     *
     * 提示:
     * 0 <= index <= 11111111
     * 1 <= value <= 100000
     *
     * 输入描述：
     * 先输入键值对的个数n（1 <= n <= 500）
     * 接下来n行每行输入成对的index和value值，以空格隔开
     *
     * 输出描述：
     * 输出合并后的键值对（多行）
     *
     * 示例1
     * 输入：
     *      4
     *      0 1
     *      0 2
     *      1 2
     *      3 4
     * 输出：
     *      0 3
     *      1 2
     *      3 4
     *
     *
     * 示例2
     * 输入：
     *      3
     *      0 1
     *      0 2
     *      8 9
     * 输出：
     *      0 3
     *      8 9
     *
     * @param args
     */
    public static void main(String[] args) {
        MergeTable mergeTable = new MergeTable();
        mergeTable.m1();
    }

    /**
     * 利用TreeMap有序输出
     * @author: luorenjie
     * @date: 2023/4/19 15:40
     * @return: void
     */
    private void m1() {
        Scanner scanner = new Scanner(System.in);
        List<String> ls = new ArrayList<>();
        while(scanner.hasNextInt()){
            String s = scanner.nextLine();
            ls.add(s);
        }
        List<String> filterList = ls.stream().filter(x -> x.contains(" ")).collect(Collectors.toList());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String s : filterList) {
            String[] strs = s.split(" ");
            int key = Integer.parseInt(strs[0]);
            int val = Integer.parseInt(strs[1]);
            if (map.get(key) != null){
                val = map.get(key) + val;
                map.put(key, val);
            }else {
                map.put(key, val);
            }
        }

       map.forEach((k, v) ->{
           System.out.println(k + " " + v);
       });
    }
}
