package com.lrj.codinglearn.hot100;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第64题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest064 {

    /**
     * 74.搜索二维矩阵
     * @author: luorenjie
     * @date: 2025/2/26 10:32
     * @param matrix
     * @param target
     * @return: boolean
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = matrix[i].length - 1;
            //找到当前行，二分查找
            while (l <= r){
                int mid = l + (r - l) / 2;
                if (matrix[i][mid] == target){
                    return true;
                } else if (matrix[i][mid] > target) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        CodingTest064 test = new CodingTest064();
        System.out.println(test.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 10));
    }

}
