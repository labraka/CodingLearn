package com.lrj.codinglearn.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第19题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest019 {

    /**
     * 54.螺旋矩阵
     * @author: luorenjie
     * @date: 2024/9/20 14:56
     * @param matrix
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 || n == 0){
            return null;
        }
        /**
         *  边界收缩
         *
         *      up  ----------> right
         *          ↑        |
         *          |        ↓
         *    left <---------- down
         *
         */

        int up = 0, down = m - 1;
        int left = 0, right = n - 1;

        List<Integer> resList = new ArrayList<>();
        while (resList.size() < m * n){

            //上边界，向下收缩，从左向右遍历
            if (up <= down){
                for (int i = left; i <= right; i++) {
                  resList.add(matrix[up][i]);
                }
                //向下收缩
                up++;
            }

            //右边界，向左收缩，从上向下遍历
            if (right >= left){
                for (int i = up; i <= down; i++) {
                    resList.add(matrix[i][right]);
                }
                //向左收缩
                right--;
            }

            //下边界，向上收缩，从右向左遍历
            if (down >= up){
                for (int i = right; i >= left; i--) {
                    resList.add(matrix[down][i]);
                }
                //向上收缩
                down--;
            }

            //左边界，向右收缩，从下向上遍历
            if (left <= right){
                for (int i = down; i >= up; i--) {
                    resList.add(matrix[i][left]);
                }
                //向右收缩
                left++;
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        CodingTest019 test = new CodingTest019();
        System.out.println(test.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(test.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
