package com.lrj.codinglearn.hj;

import java.util.Scanner;

/**
 * @ClassName: HJ5Convert
 * @Description:
 * @Date: 2023/4/17 14:25
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class HJ5Convert {

    public static void main(String[] args) throws IllegalAccessException {

        HJ5Convert hj5Convert = new HJ5Convert();
        hj5Convert.m1();
    }

    private static void m2() throws IllegalAccessException {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        for (int i = 2; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c >= '0' && c <= '9'){
//                c*
//            }else if (c >= 'a' && c <= 'f'){
//
//            }else if (c >= 'A' && c <= 'F'){
//
//            }else {
//                throw new IllegalAccessException("参数异常");
//            }
//        }
    }

    /**
     * 使用自带的类转
     * @author: luorenjie
     * @date: 2023/4/17 15:48
     * @return: void
     */
    private static void m1() {
        Scanner scanner = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder(scanner.nextLine());
//        String s = new BigInteger(sb.substring(2), 16).toString(10);
        String s = scanner.nextLine();
        if (s.isEmpty()){
            return;
        }
        char[] cs = s.toCharArray();
        if (cs.length<4){
            return;
        }

        if ('0' != cs[0] || (!Character.toString(cs[1]).toUpperCase().equals("X"))){
            return;
        }
        String s1 = s.substring(2);
        Integer i = Integer.parseInt(s1, 16);
        System.out.println(i);
    }


}
