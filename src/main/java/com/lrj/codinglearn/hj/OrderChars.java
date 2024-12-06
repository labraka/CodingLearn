package com.lrj.codinglearn.hj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @ClassName: OrderChars
 * @Description:
 * @Date: 2023/4/19 15:42
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class OrderChars {

    /**
     *给定 n 个字符串，请对 n 个字符串按照字典序排列。
     * 数据范围：1≤n≤1000  ，字符串长度满足 1≤len≤100
     *
     * 输入描述：
     * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
     *
     * 输出描述：
     * 数据输出n行，输出结果为按照字典序排列的字符串。
     *
     * 示例1
     * 输入：
     *      9
     *      cap
     *      to
     *      cat
     *      card
     *      two
     *      too
     *      up
     *      boat
     *      boot
     * 输出：
     *      boat
     *      boot
     *      cap
     *      card
     *      cat
     *      to
     *      too
     *      two
     *      up
     *
     * @param args
     */
    public static void main(String[] args) {

        OrderChars orderChars = new OrderChars();
        orderChars.m1();
    }

    /**
     * 通过数组排序
     * @author: luorenjie
     * @date: 2023/4/19 16:01
     * @return: void
     */
    private void m1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (s.matches("^[a-z]+$")){
                strs[i] = s;
            }
        }
        Arrays.sort(strs);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
