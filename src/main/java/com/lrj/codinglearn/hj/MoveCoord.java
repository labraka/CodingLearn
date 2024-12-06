package com.lrj.codinglearn.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: CountChars
 * @Description:
 * @Date: 2023/4/17 14:25
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class MoveCoord {

    /**
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     *
     * 输入：
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     * 坐标之间以;分隔。
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     * 下面是一个简单的例子 如：
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 处理过程：
     * 起点（0,0）
     * +   A10   =  （-10,0）
     * +   S20   =  (-10,-20)
     * +   W10  =  (-10,-10)
     * +   D30  =  (20,-10)
     * +   x    =  无效
     * +   A1A   =  无效
     * +   B10A11   =  无效
     * +  一个空 不影响
     * +   A10  =  (10,-10)
     * 结果 （10， -10）
     *
     *数据范围：每组输入的字符串长度满足 1≤n≤10000  ，坐标保证满足 −2^31≤x,y≤2^31−1  ，且数字部分仅含正数
     *
     *
     * 示例1
     * 输入：A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 输出：10,-10
     *
     *
     * 示例2
     * 输入：ABC;AKL;DA1;
     * 输出：0,0
     * @param args
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IOException {

        MoveCoord moveCoord = new MoveCoord();
        moveCoord.m1();
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
    private void m1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] strs = s.split(";");
//        int[] res = new int[]{0, 0};
        int x = 0, y = 0;
        for (String str : strs) {
            if (str.isEmpty() || str.equals("") || !str.matches("[WASD][0-9]{1,2}")){
                continue;
            }
            int val = Integer.parseInt(str.substring(1));
            switch (str.charAt(0)){
                case 'W':
                    y += val;
                    break;
                case 'A':
                    x -= val;
                    break;
                case 'S':
                    y -= val;
                    break;
                case 'D':
                    x += val;
                    break;
            }
        }
        System.out.println(x + "," + y);
//        return res;
    }


}
