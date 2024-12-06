package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第51题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest051 {


    /**
     * 200.岛屿数量
     * @author: luorenjie
     * @date: 2024/11/28 16:11
     * @param grid
     * @return: int
     */
    int res;
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //岛屿数量+1
                if (grid[i][j] == '1'){
                    res++;

                    //递归淹没岛屿
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        //边界
        if (i < 0 || i >= m || j < 0 || j >= n){
            return;
        }

        //如果是海水，直接返回
        if (grid[i][j] == '0'){
            return;
        }

        //淹没岛屿
        grid[i][j] = '0';

        //淹没上下左右的岛屿
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        CodingTest051 test = new CodingTest051();
        /*
         *
         *                        1  1  0  0  0
         *                        1  1  0  0  0
         *                        0  0  1  0  0
         *                        0  0  0  1  1
         */
        char[][] grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        int maxNum = test.numIslands(grid);
        System.out.println(maxNum);
    }
}
