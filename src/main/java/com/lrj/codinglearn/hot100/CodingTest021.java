package com.lrj.codinglearn.hot100;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第21题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest021 {

    /**
     * 240.搜索二维矩阵II
     * @author: luorenjie
     * @date: 2024/9/23 18:18
     * @param matrix
     * @param target
     * @return: boolean
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        //设置起始下标
        int i = 0, j = n - 1;

        while (i < m && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CodingTest021 test = new CodingTest021();
        System.out.println(test.searchMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 0));
        System.out.println(test.searchMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 5));
    }
}
