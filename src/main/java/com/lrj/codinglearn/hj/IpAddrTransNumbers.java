package com.lrj.codinglearn.hj;

import java.util.Scanner;

/**
 * @ClassName: IpAddrTransNumbers
 * @Description:
 * @Date: 2023/4/19 11:34
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class IpAddrTransNumbers {

    /**
     * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
     * 一个长整数。
     * 举例：一个ip地址为10.0.3.193
     * 每段数字             相对应的二进制数
     * 10                   00001010
     * 0                    00000000
     * 3                    00000011
     * 193                  11000001
     *
     * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
     *
     * 数据范围：保证输入的是合法的 IP 序列
     *
     * 示例1
     * 输入：10.0.3.193
     *      167969729
     * 输出：167773121
     *      10.3.3.193
     *
     * @param args
     */
    public static void main(String[] args) {

        IpAddrTransNumbers ipAddrTransNumbers = new IpAddrTransNumbers();
        ipAddrTransNumbers.m1();
    }

    /**
     * 操作字符串，并且通过进制转换来操作
     * @author: luorenjie
     * @date: 2023/4/19 14:51
     * @return: void
     */
    private void m1() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.contains(".")){
            String[] nums = s.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (String num : nums) {
                if (!num.matches("[0-9]\\d*") || Integer.parseInt(num) < 0 || Integer.parseInt(num) >255){
                    throw new IllegalArgumentException();
                }
                String binaryString = Integer.toBinaryString(Integer.parseInt(num));
                if (binaryString.length() < 8){
                    binaryString = binaryString.format("%08d", Integer.valueOf(binaryString));
                }
                sb.append(binaryString);
            }
            System.out.println(Long.parseLong(sb.toString(), 2));

        }else {
            String binaryString = Long.toBinaryString(Long.parseLong(s));
            while (binaryString.length() < 32){
                binaryString = "0" + binaryString;
            }
           String[] strs = new String[4];
            for (int i = 0; i < 4; i++) {
                String s1 = binaryString.substring(8*i, 8*i+8);
                String s2 = Long.toString(Long.parseLong(s1, 2));
                strs[i] = s2;
            }
            System.out.println(String.join(".", strs));
        }
    }
}
