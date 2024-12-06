package com.lrj.codinglearn;

import java.util.*;

/**
 * @ClassName: BFSTest
 * @Description:
 * @Date: 2024/1/25 11:31
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class BFSTest {
    public static void main(String[] args) {
        BFSTest test = new BFSTest();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode node1 = root.right = new TreeNode(20);
        node1.left = new TreeNode(15);
        node1.right= new TreeNode(7);
        System.out.println(test.minDepth(root));
        System.out.println(test.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
        for (int i = 0; i <= 9; i++) {
            System.out.println(i%4);
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //初始化层
        int deep = 1;

        while (!q.isEmpty()){
            int size = q.size();
            //向四周扩散
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                //看是否到叶子节点
                if (cur.left == null && cur.right == null){
                    return deep;
                }

                if (cur.left != null){
                    q.offer(cur.left);
                }

                if (cur.right != null){
                    q.offer(cur.right);
                }
            }

            deep++;
        }

        return deep;
    }

    //773.滑动谜题
    public int slidingPuzzle(int[][] board) {
        int m = board.length, n = board[0].length;
        StringBuilder sb = new StringBuilder();
        String target = "123450";

        //将数组转化成字符串作为BFS的起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }

        String start = sb.toString();

        //记录一维字符串的相邻索引
//        int[][] neighbor = new int[][]{
//                {1, 3},
//                {0, 4, 2},
//                {1, 5},
//                {0, 4},
//                {3, 1, 5},
//                {4, 2}
//        };

        int[][] neighbor = generateNeighborMapping(m, n);

        //BFS框架
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        //从起点开始搜索
        q.offer(start);
        visited.add(start);

        int step = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (target.equals(cur)){
                    return step;
                }

                //找到数字0的索引位置
                int idx = 0;
                for (; cur.charAt(idx) != '0' ; idx++);

                //将数字0和相邻数字交换
                for (int adj : neighbor[idx]) {
                    String newBoard = swap(cur.toCharArray(), adj, idx);
                    if (!visited.contains(newBoard)){
                        q.offer(newBoard);
                        visited.add(newBoard);
                    }
                }

            }
            step++;
        }

        return -1;
    }

    //根据矩阵大小生成索引映射
    private int[][] generateNeighborMapping(int m, int n) {
        int[][] neighbor = new int[m*n][];
        for (int i = 0; i < m * n; i++) {
            List<Integer> neighbors = new ArrayList<>();

            //如果不是第一列，左侧有邻居
            if (i % n != 0){
                neighbors.add(i - 1);
            }
            //如果不是最后一列，右侧有邻居
            if (i % n != n - 1){
                neighbors.add(i + 1);
            }
            //如果不是第一行，上方有邻居
            if (i - n >= 0){
                neighbors.add(i - n);
            }
            //如果不是最后一行，下方有邻居
            if (i + n < m * n){
                neighbors.add(i + n);
            }

            neighbor[i] = neighbors.stream().mapToInt(Integer::intValue).toArray();
        }

        return neighbor;
    }

    private String swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }


}
