package com.lrj.codinglearn.hot100;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第52题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest052 {

    /**
     * 994.腐烂的橘子
     * @author: luorenjie
     * @date: 2025/1/23 17:24
     * @param grid
     * @return: int
     */
    //新鲜橘子数量
    int count = 0;
    //腐烂的橘子坐标入队
    Queue<int[]> queue = new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //分别记录新鲜的橘子和腐烂的橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    count++;
                }
                if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        //时间次数
        int time = 0;

        //层级迭代处理
        while (count > 0 && !queue.isEmpty()){
            time++;
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int[] orange = queue.poll();
                int x = orange[0];
                int y = orange[1];

                //获取腐烂橘子向四周扩散
                rotting(grid, x-1, y);
                rotting(grid, x+1, y);
                rotting(grid, x, y-1);
                rotting(grid, x, y+1);
            }
        }
        if (count > 0){
            return -1;
        }

        return time;
    }


    private void rotting(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        //边界
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || grid[i][j] == 2){
            return;
        }

        //腐烂好橘子
        if (grid[i][j] == 1){
            grid[i][j] = 2;
            count--;
            queue.add(new int[]{i, j});
        }
    }

    public static void main(String[] args) {
        CodingTest052 test = new CodingTest052();
        /*
         *    2  1  1
         *    1  1  0
         *    0  1  1
         */
//        int[][] grid1 = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
//        System.out.println(test.orangesRotting(grid1));

        /*
         *    2  1  1
         *    0  1  1
         *    1  0  1
         */
        int[][] grid2 = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(test.orangesRotting(grid2));
    }



}
