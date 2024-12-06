package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第37题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest037 {


    /**
     * 104.二叉树的最大深度
     * @param root
     * @author: luorenjie
     * @date: 2024/10/17 11:19
     * @return: int
     */
    int res = 0;
    public int maxDepth(TreeNode root) {
        /**
         *
         * 方法一：递归，前序遍历
         *
         */
//        int deep = 0;
//        traverse(root, deep);
//        return res;


        /**
         *
         * 方法二：动态规划
         *
         */
        return traverse1(root);

    }

    private int traverse1(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftMax = traverse1(root.left);
        int rightMax = traverse1(root.right);

        //求得左右最大深度+当前节点
        return 1 + Math.max(leftMax, rightMax);
    }


    private void traverse(TreeNode root, int deep) {
        if (root == null){
            return;
        }

        //前序遍历的时候深度+1
        deep++;
        //记录最大深度
        res = Math.max(res, deep);
        traverse(root.left, deep);
        traverse(root.right, deep);
        //当前节点遍历完-1
        deep--;
    }


    public static void main(String[] args) {
        CodingTest037 test = new CodingTest037();
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(9);
        treeNode11.left = new TreeNode(5);
        treeNode11.right = new TreeNode(6);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(20);
        treeNode12.left = new TreeNode(7);
        treeNode12.right = new TreeNode(15);
       System.out.println(test.maxDepth(treeNode1));

    }
}
