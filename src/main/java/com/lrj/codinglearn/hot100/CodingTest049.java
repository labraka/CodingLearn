package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第49题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest049 {


    /**
     * 236.二叉树的最近公共祖先
     * @author: luorenjie
     * @date: 2024/11/27 14:37
     * @param root
     * @param p
     * @param q
     * @return: com.lrj.codinglearn.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        //若根节点和左节点或右节点相等，则返回当前根节点
        if (root.left == p || root.right == q){
            return root;
        }

        //遍历左右节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //后序遍历处理
        //情况一：如果左右节点都不为null
        if (left != null && right != null){
            return root;
        }

        //情况二：如果左右节点有都为null，返回null
        if (left ==null && right == null){
            return null;
        }

        return left == null ? right : left;
    }


    public static void main(String[] args) {
        CodingTest049 test = new CodingTest049();

        /**
         *
         *                 3
         *                 /\
         *                5   1
         *               /\   /\
         *              6  2 0  8
         *                /\
         *               7  4
         *
         */
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(5);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(1);
        TreeNode treeNode111 = treeNode11.left = new TreeNode(6);
        TreeNode treeNode112 = treeNode11.right = new TreeNode(2);
        treeNode12.left = new TreeNode(0);
        treeNode12.right = new TreeNode(8);
        treeNode112.left = new TreeNode(7);
        treeNode112.right = new TreeNode(4);
        TreeNode treeNode = test.lowestCommonAncestor(treeNode1, treeNode11, treeNode12);
        System.out.println(treeNode);
    }
}
