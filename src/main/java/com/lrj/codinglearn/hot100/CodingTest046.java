package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第46题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest046 {

    /**
     * 114.二叉树展开为链表
     * @author: luorenjie
     * @date: 2024/11/14 10:29
     * @param root
     * @return: void
     */
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }

        //拉直左右子树
        flatten(root.left);
        flatten(root.right);

        /*
         * 后序遍历
         */

        //左右子树已被拉成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        //左子树置空，将左子树拼接到右子树
        root.left = null;
        root.right = left;

        //设置临时根节点
        TreeNode p = root;
        //如果当前根节点的右节点还有子树，则继续向下遍历直到叶子节点
        while (p.right != null){
            p = p.right;
        }
        //向当前根节点的右节点后面添加数据
        p.right = right;
    }



    public static void main(String[] args) {
        CodingTest046 test = new CodingTest046();

        /**
         *
         *                 1
         *                 /\
         *                2  5
         *               / \   \
         *               3  4   6
         *
         */

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(2);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(5);
        treeNode11.left = new TreeNode(3);
        treeNode11.right = new TreeNode(4);
        treeNode12.right = new TreeNode(6);
        test.flatten(treeNode1);
    }
}
