package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第40题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest040 {

    /**
     * 543.二叉树的直径
     * @author: luorenjie
     * @date: 2024/10/21 11:19
     * @param root
     * @return: int
     */
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return diameter;
    }

    int diameter = 0;
    private int traverse(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftMax = traverse(root.left);
        int rightMax = traverse(root.right);
        diameter = Math.max(diameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        CodingTest040 test = new CodingTest040();

        /**
         *
         *                  3
         *                 /\
         *                9  9
         *               /\  /\
         *              5  6 6 5
         *
         */

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(9);
        treeNode11.left = new TreeNode(5);
        treeNode11.right = new TreeNode(6);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(9);
        treeNode12.left = new TreeNode(6);
        treeNode12.right = new TreeNode(5);

        System.out.println(test.diameterOfBinaryTree(treeNode1));

    }
}
