package com.lrj.codinglearn.hj;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: ReverseChars
 * @Description:
 * @Date: 2023/4/19 9:56
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class ReverseChars {

    /**
     * 将一个字符串str的内容颠倒过来，并输出。
     * 数据范围：1≤len(str)≤10000
     *
     * 示例1
     * 输入：I am a student
     * 输出：tneduts a ma I
     *
     * 示例2
     * 输入：nowcoder
     * 输出：redocwon
     *
     * @param args
     */
    public static void main(String[] args) {

        ReverseChars reverseChars = new ReverseChars();
        reverseChars.m1();
        reverseChars.m2();
    }

    /**
     * 利用可变的字符序列的自带方法
     * @author: luorenjie
     * @date: 2023/4/19 10:25
     * @return: void
     */
    private void m2() {
        Scanner scanner =  new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            sb.append(c);
        }
        System.out.println(sb.reverse());
    }

    /**
     * 利用栈FILO的特性
     * @author: luorenjie
     * @date: 2023/4/19 10:21
     * @return: void
     */
    private void m1() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isEmpty()){
            return;
        }
        char[] cs = s.toCharArray();
        Stack stack = new Stack();
        for (char c : cs) {
            stack.push(c);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
