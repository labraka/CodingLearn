package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第38题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest038 {

    /**
     * 226.翻转二叉树
     * @author: luorenjie
     * @date: 2024/10/17 14:23
     * @param root
     * @return: com.lrj.codinglearn.TreeNode
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }

        return traverse(root);
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null){
            return null;
        }

        /**
         *
         * 方法一：前序遍历
         *
         */
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;



        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);

        /**
         *
         * 方法二：后序遍历
         *
         */
//        root.left = right;
//        root.right = left;

        return root;
    }


    public static void main(String[] args) {
        CodingTest038 test = new CodingTest038();

        /**
         *
         *                  3                     3
         *                 /\                    /\
         *                9  20      ==>        20 9
         *               /\  /\                 /\  /\
         *              5  6 7 15             15 7 6  5
         *
         */

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(9);
        treeNode11.left = new TreeNode(5);
        treeNode11.right = new TreeNode(6);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(20);
        treeNode12.left = new TreeNode(7);
        treeNode12.right = new TreeNode(15);

       TreeNode treeNode = test.invertTree(treeNode1);
        System.out.println(treeNode);

    }
}
