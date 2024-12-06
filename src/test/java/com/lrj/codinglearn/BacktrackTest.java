package com.lrj.codinglearn;

import java.util.*;

/**
* @ClassName: BacktrackTest
* @Description: 
* @Date: 2023/12/15 15:20
* @Author luorenjie
* @Version V1.0
* @Since JDK 1.8
*/public class BacktrackTest {

    public static void main(String[] args) {
        BacktrackTest test = new BacktrackTest();
        System.out.println(test.permute(new int[]{1, 2, 3}));
        System.out.println(test.solveNQueens(4));
        System.out.println(test.subsets(new int[]{1, 2, 3}));
        System.out.println(test.combine(4, 2));
        System.out.println(test.subsetsWithDup(new int[]{4,4,4,1,4}));
        System.out.println(test.permuteUnique(new int[]{1,1,2}));
        System.out.println(test.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(test.canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
        System.out.println(test.numIslands(new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}}));
        System.out.println(test.closedIsland(new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}}));
        System.out.println(test.numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println(test.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
        System.out.println(test.countSubIslands(new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}}, new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}));
        test.solveSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
        System.out.println(test.generateParenthesis(3));
        System.out.println(test.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }

    List<List<Integer>> res = new ArrayList<>();
    //46.全排列
    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        List<Integer> track = new ArrayList<>();

        //路径中元素会记录为true，避免重复使用
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);

        return res;
    }

    private void backtrack(int[] nums,  List<Integer> track, boolean[] used){
        if (track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            //进入下一层决策树
            backtrack(nums, track, used);

            //取消选择
            track.remove(track.size()-1);
            used[i] = false;
        }
    }


    //51.N皇后
    List<List<String>> res1 = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        List<String> track = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            track.add(sb.toString());
        }

        //回溯
        backtrack1(track, 0);

        return res1;
    }

    private void backtrack1(List<String> track, int row){
        if (track.size() == row){
            res1.add(new ArrayList<>(track));
            return;
        }

        //当前行字符串的长度
        int n = track.get(row).length();
        //当前行遍历列
        for (int col = 0; col < n; col++) {
            //排除不合法的
            if (!isVolid(track, row, col)){
                continue;
            }

            StringBuilder sb = new StringBuilder(track.get(row));
            sb.setCharAt(col, 'Q');
            track.set(row, sb.toString());

            //进入下一层决策树
            backtrack1(track, row+1);

            //撤销选择
            sb.setCharAt(col, '.');
            track.set(row, sb.toString());
        }
    }

    private boolean isVolid(List<String> track, int row, int col){
        int n = track.size();

        //检查当前列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (track.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        //检查右上方是否有皇后冲突
        for (int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if (track.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        //检查左上方是否有皇后冲突
        for (int i = row-1, j = col-1; i >= 0 && j >= n; i--, j--) {
            if (track.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }



    //78.子集
    List<List<Integer>> res2 = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //记录每个路径
        List<Integer> track = new ArrayList<>();

        //回溯
        backtrack2(nums, track, 0);
        Collections.sort(res2, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        return res2;
    }

    private void backtrack2(int[] nums, List<Integer> track, int start){
        res2.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);

            //进入下一层决策树
            backtrack2(nums, track, i+1);

            //撤销
            track.remove(track.size()-1);
        }
    }



    //77.组合
    List<List<Integer>> res3 = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();

        //回溯
        backtrack3(track, n, k, 1);

        return res3;
    }


    private void backtrack3(List<Integer> track, int n, int k, int start){
        if (track.size() == k){
            res3.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);

            //进入下一层决策树
            backtrack3(track, n, k, i+1);

            //撤销选择
            track.remove(track.size()-1);
        }
    }

    //90.子集Ⅱ
    List<List<Integer>> res4 = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> track = new ArrayList<>();

        //排序
        Arrays.sort(nums);

        ///回溯
        backtrack4(nums, track, 0);

        return res4;
    }

    private void backtrack4(int[] nums, List<Integer> track, int start) {
        //每个值都是一个子集
        res4.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {

            //剪枝操作
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }

            track.add(nums[i]);

            //进入下一层决策树
            backtrack4(nums, track, i+1);

            //撤销
            track.remove(track.size()-1);
        }
    }

    //47.全排列Ⅱ
    List<List<Integer>> res5 = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        used = new boolean[nums.length];
        //排序
        Arrays.sort(nums);

        //回溯
        backtrack5(nums, track);

        return res5;
    }

    private void backtrack5(int[] nums, List<Integer> track) {

        if (track.size() == nums.length){
            res5.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }

            //剪枝
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }

            track.add(nums[i]);
            used[i] = true;

            //进入下一层决策树
            backtrack5(nums, track);

            //撤销
            track.remove(track.size()-1);
            used[i] = false;
        }
    }

    //39.组合总和
    List<List<Integer>> res6 = new ArrayList<>();
    int trackSum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> track = new ArrayList<>();

        //回溯
        backtrack6(candidates, track, target, 0);

        return res6;
    }

    private void backtrack6(int[] candidates, List<Integer> track, int target, int start) {
        if (trackSum > target){
            return;
        }
        if (trackSum == target){
            res6.add(new ArrayList<>(track));
            return;
        }


        for (int i = start; i < candidates.length; i++) {
            trackSum += candidates[i];
            track.add(candidates[i]);

            //进入下一层决策树
            backtrack6(candidates, track, target, i);

            //撤销
            trackSum -= candidates[i];
            track.remove(track.size()-1);
        }

    }

    //698.划分为k个相等的子集
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0){
            return false;
        }

        int avg = sum / k;

        //从小到大排序
        Arrays.sort(nums);
        //最大的数超过平均数，则无法平分
        if (nums[nums.length-1] > avg){
            return false;
        }

        boolean[] used = new boolean[nums.length];

        return backtrack7(k, 0, nums, nums.length-1, used, avg);
    }

    private boolean backtrack7(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        if (k == 0){
            return true;
        }

        if (bucket == target){
            //当前桶装满了，递归穷举下一个桶选择
            return backtrack7(k-1, 0, nums, nums.length-1, used, target);
        }


        for (int i = start; i >= 0; i--) {
            if (used[i] || nums[i] + bucket > target){
                continue;
            }

            used[i] = true;

            if (backtrack7(k, bucket+nums[i], nums, i-1, used, target)){
                return true;
            }

            used[i] = false;

            //剪枝
            while (i > 0 && nums[i-1] == nums[i]){
                i--;
            }
        }

        return false;
    }


    //200.岛屿的数量
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    //每发现一个岛屿数量加一
                    res++;

                    //DFS淹没陆地
                    dfs(grid, i, j);

                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        //边界情况
        if (i < 0 || j < 0 || i >= m || j >= n){
            return;
        }

        //不是陆地
        if (grid[i][j] == '0'){
            return;
        }

        //将陆地变为海水
        grid[i][j] = '0';

        //淹没上下左右的陆地

        dfs(grid, i-1, j);//上
        dfs(grid, i+1, j);//下
        dfs(grid, i, j-1);//左
        dfs(grid, i, j+1);//右
    }



    //1254.统计封闭岛屿的数目
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            //淹掉左边的
            dfs1(grid, i, 0);
            //淹掉右边的
            dfs1(grid, i, n-1);
        }

        for (int j = 0; j < n; j++) {
            //淹掉上边的
            dfs1(grid, 0, j);
            //淹掉下边的
            dfs1(grid, m-1, j);
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    //岛屿数+1
                    res++;
                    //dfs淹没岛屿
                    dfs1(grid, i ,j);
                }
            }
        }

        return res;
    }

    private void dfs1(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        //边界
        if (i < 0 || j < 0 || i >= m || j >= n){
            return;
        }

        //如果是水则返回
        if (grid[i][j] == 1){
            return;
        }

        //淹没岛屿
        grid[i][j] = 1;

        //淹没上下左右
        dfs1(grid, i-1, j);
        dfs1(grid, i+1, j);
        dfs1(grid, i, j-1);
        dfs1(grid, i, j+1);

    }



    //1020.飞地的数量
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        //淹没左右的岛屿
        for (int i = 0; i < m; i++) {
            dfs2(grid, i, 0);
            dfs2(grid, i, n-1);
        }

        //淹没上下的岛屿
        for (int j = 0; j < n; j++) {
            dfs2(grid, 0, j);
            dfs2(grid, m-1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    res ++;
                }
            }
        }

        return res;
    }

    private void dfs2(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n){
            return;
        }

        if (grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;

        dfs2(grid, i-1, j);
        dfs2(grid, i+1, j);
        dfs2(grid, i, j-1);
        dfs2(grid, i, j+1);
    }

    //695.岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    res = Math.max(res, dfs3(grid, i, j));
                }
            }
        }

        return res;
    }

    private int dfs3(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n){
            return 0;
        }

        if (grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return dfs3(grid, i+1, j)
                +dfs3(grid, i, j+1)
                +dfs3(grid, i-1, j)
                +dfs3(grid, i, j-1)+1;
    }

    //1905.统计子岛屿
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1){
                    dfs4(grid2, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1){
                    res++;
                    dfs2(grid2, i, j);
                }
            }
        }
        return res;
    }


    private void dfs4(int[][] grid2, int i, int j){
        int m = grid2.length, n = grid2[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n){
            return;
        }

        if (grid2[i][j] == 0){
            return;
        }

        grid2[i][j] = 0;

        dfs4(grid2, i-1, j);
        dfs4(grid2, i+1, j);
        dfs4(grid2, i, j-1);
        dfs4(grid2, i, j+1);
    }


    //37.解数独
    public void solveSudoku(char[][] board) {
        backtrack8(board, 0, 0);
        System.out.println(Arrays.asList(board));
    }

    private boolean backtrack8(char[][] board, int i, int j){
        int m = 9, n = 9;
        //列遍历完，从下一行开始遍历
        if (j == n){
            return backtrack8(board, i+1, 0);
        }

        if (i == m){
            return true;
        }

        //如果该位置是预设的数字，则继续往下一列遍历
        if (board[i][j] != '.'){
            return backtrack8(board, i, j+1);
        }

        for (char c = '1'; c <= '9'; c++) {
            //如果遇不到合法数字就跳过
            if (!isVolid1(board, i, j, c)){
                continue;
            }

            board[i][j] = c;
            //继续进入下一列决策树
            if (backtrack8(board, i, j+1)){
                return true;
            }
            //撤销
            board[i][j] = '.';
        }

        return false;
    }

    private boolean isVolid1(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            //当前的列是否有重复数字
            if (board[i][k] == c){
                return false;
            }
            //当前的行是否有重复数字
            if (board[k][j] == c){
                return false;
            }
            //判断3*3方框是否有重复数字
            if (board[(i/3)*3+k/3][(j/3)*3+i%3] == c){
                return false;
            }
        }
        return true;
    }


    //22.括号生成
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();

        //回溯过程中的路径
        StringBuilder track = new StringBuilder();

        //拥有左右相等的括号
        backtrack9(n, n, track, res);

        return res;
    }

    private void backtrack9(int left, int right, StringBuilder track, List<String> res) {
        //边界：数量小于0不合法，左括号小于右括号数量也不合法
        if (left < 0 || right < 0 || left > right){
            return;
        }

        //左右都用完时得到一个合法的括号组
        if (left == 0 && right == 0){
            res.add(track.toString());
            return;
        }

        //尝试放左括号
        track.append("(");
        //选择
        backtrack9(left-1, right, track, res);
        //撤销选择
        track.deleteCharAt(track.length()-1);

        //尝试放右括号
        track.append(")");
        //选择
        backtrack9(left, right-1, track, res);
        //撤销选择
        track.deleteCharAt(track.length()-1);
    }


    //752.打开转盘锁
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        //用集合快速判断是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();

        //是否已穷举
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()){
            //临时存储扩散结果
            Set<String> tmp = new HashSet<>();

            for (String cur : q1) {
                if (deads.contains(cur)){
                    continue;
                }

                if (q2.contains(cur)){
                    return step;
                }

                visited.add(cur);

                for (int i = 0; i < 4; i++) {
                    String up = plusOne(cur, i);
                    if (!visited.contains(up)){
                        tmp.add(up);
                    }
                    String down = minusOne(cur, i);
                    if (!visited.contains(down)){
                        tmp.add(down);
                    }
                }
            }

            //增加步数
            step++;

            //交换q1和q2，下一轮while扩散q2;
            q1 = q2;
            q2 = tmp;
        }

        return -1;
    }

    //将s[i]向下拨动一次
    private String minusOne(String s, int i) {
        char[] cs = s.toCharArray();
        if (cs[i] == '0'){
            cs[i] = '9';
        }else {
            cs[i] -= 1;
        }
        return new String(cs);
    }

    //将s[i]向上拨动一次
    private String plusOne(String s, int i) {
        char[] cs = s.toCharArray();
        if (cs[i] == '9'){
            cs[i] = '0';
        }else {
            cs[i] += 1;
        }
        return new String(cs);
    }

}
