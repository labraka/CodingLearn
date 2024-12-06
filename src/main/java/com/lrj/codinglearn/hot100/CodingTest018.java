package com.lrj.codinglearn.hot100;

import java.util.*;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第18题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest018 {

    /**
     * 73.矩阵置零
     * @author: luorenjie
     * @date: 2024/9/19 11:45
     * @param matrix
     * @return: void
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //集合记录为零的下标
        List<int[]> indexList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    indexList.add(new int[]{i, j});
                }
            }
        }

        //将对应的行和列的值变为零
        for (int i = 0; i < indexList.size(); i++) {
            //行
            int row = indexList.get(i)[0];
            //列
            int col = indexList.get(i)[1];

            for (int y = 0; y < n; y++) {
                matrix[row][y] = 0;
            }
            for (int x = 0; x < m; x++) {
                matrix[x][col] = 0;
            }

        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        CodingTest018 test = new CodingTest018();
        test.setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        test.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }
}
