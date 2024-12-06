package com.lrj.codinglearn.hj;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @ClassName: MingRandomNumbers
 * @Description:
 * @Date: 2023/4/18 16:06
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class MingRandomNumbers {

    /**
     * 明明的随机数
     * 明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
     * 数据范围：1≤n≤1000，输入的数字大小满足1≤val≤500
     * @param args
     */
    public static void main(String[] args) {
        MingRandomNumbers mingRandomNumbers = new MingRandomNumbers();
        mingRandomNumbers.m1();
        mingRandomNumbers.m2();
    }

    /**
     * 使用数组的方式
     * @author: luorenjie
     * @date: 2023/4/18 18:18
     * @return: void
     */
    private void m2() {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int count = in.nextInt();    //随机数总数
            int[] data = new int[count];
            for(int i=0; i < count; i++)    //读入生成的随机数
                data[i] = in.nextInt();

            Arrays.sort(data);    //使用库函数排序
            System.out.println(data[0]);    //打印排序后的第一个数（必不重复）
            for(int i=1; i < count; i++){    //打印其他数字，需与前面数字比较，不重复才能打印
                if(data[i] != data[i-1])
                    System.out.println(data[i]);
            }
        }
    }

    /**
     * 使用TreeSet方式
     * @author: luorenjie
     * @date: 2023/4/18 18:12
     * @return: void
     */
    private void m1() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        TreeSet treeSet = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            treeSet.add(scanner.nextInt());
        }
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
