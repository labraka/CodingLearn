package com.lrj.codinglearn.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第20题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest020 {

    /**
     * 48.旋转图像
     * @author: luorenjie
     * @date: 2024/9/23 12:14
     * @param matrix
     * @return: void
     */
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m != n){
            return;
        }


        /**
         *
         * 方法一：先交换，再翻转
         *
         */

        //按对角线交换
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //每一行翻转
        for (int i = 0; i < m; i++) {
            int x = 0, y = n - 1;
            while (x <= y){
                int tmp = matrix[i][x];
                matrix[i][x] = matrix[i][y];
                matrix[i][y] = tmp;
                x++;
                y--;
            }
        }

        /**
         *
         * 方法二：先翻转，再交换
         *
         *         1 2 3       7 8 9
         *         4 5 6       4 5 6
         *         7 8 9       1 2 3
         *
         */

        int x = 0, y = m - 1;
        while (x < y){
            int[] tmp = matrix[x];
            matrix[x] = matrix[y];
            matrix[y] = tmp;
            x++;
            y--;
        }

        //按对角线交换
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        System.out.println(matrix);
    }

    public static void main(String[] args) {
        CodingTest020 test = new CodingTest020();
        test.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        test.rotate(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }
}
