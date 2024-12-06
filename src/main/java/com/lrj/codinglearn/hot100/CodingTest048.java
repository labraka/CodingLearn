package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第48题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest048 {


    /**
     * 437.路径总和III
     * @author: luorenjie
     * @date: 2024/11/20 15:18
     * @param root
     * @param targetSum
     * @return: int
     */
    Map<Integer, Integer> memo;
    int target;
    public int pathSum(TreeNode root, int targetSum) {
        //缓存最小前缀和
        memo = new HashMap<>();
        memo.put(0, 1);
        target = targetSum;
        //递归
        return find(root, 0);
    }

    private int find(TreeNode root, int curSum) {
        if (root == null){
            return 0;
        }
        //当前最小前缀和
        curSum += root.val;

        //当前路径个数
        int res = memo.getOrDefault(curSum - target, 0);

        //将最小前缀和缓存
        memo.put(curSum, memo.getOrDefault(curSum, 0) + 1);

        //遍历左右子树
        int left = find(root.left, curSum);
        int right = find(root.right, curSum);

        //删除已经找过的路径
        memo.put(curSum, memo.get(curSum) - 1);
        return res + left + right;
    }


    public static void main(String[] args) {
        CodingTest048 test = new CodingTest048();

        /**
         *
         *                 10
         *                 /\
         *                5  -3
         *               /\    \
         *              3  2   11
         *             /\   \
         *            3 -2   1
         *
         */
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(5);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(-3);
        TreeNode treeNode111 = treeNode11.left = new TreeNode(3);
        TreeNode treeNode112 = treeNode11.right = new TreeNode(2);
        treeNode12.right = new TreeNode(11);
        treeNode111.left = new TreeNode(3);
        treeNode111.right = new TreeNode(-2);
        treeNode112.right = new TreeNode(1);
        int num = test.pathSum(treeNode1, 8);
        System.out.println(num);
    }
}
