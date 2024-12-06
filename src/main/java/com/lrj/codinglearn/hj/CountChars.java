package com.lrj.codinglearn.hj;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: CountChars
 * @Description:
 * @Date: 2023/4/17 14:25
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CountChars {

    /**
     * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
     * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
     * 数据范围：1≤n≤500
     * @param args
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IllegalAccessException {

        CountChars countChars = new CountChars();
        countChars.m1();
    }

    private static void m2() throws IllegalAccessException {
//
    }

    /**
     * 使用lambda转
     * @author: luorenjie
     * @date: 2023/4/17 15:48
     * @return: void
     */
    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isEmpty()||s.equals("")){
            return;
        }
        char[] cs = s.trim().toCharArray();
        Set<Character> set = new String(cs).chars().mapToObj( x->(char)x).collect(Collectors.toSet());
        System.out.println(set.size());
    }


}
