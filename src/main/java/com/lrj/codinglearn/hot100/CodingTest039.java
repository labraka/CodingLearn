package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第39题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest039 {

    /**
     * 101.对称二叉树
     * @author: luorenjie
     * @date: 2024/10/21 10:47
     * @param root
     * @return: boolean
     */
    public boolean isSymmetric(TreeNode root) {
        return traverse(root, root);
    }

    private boolean traverse(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null || left.val != right.val){
            return false;
        }
       return traverse(left.left, right.right) &&  traverse(left.right, right.left);
    }

    public static void main(String[] args) {
        CodingTest039 test = new CodingTest039();

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

        System.out.println(test.isSymmetric(treeNode1));

    }
}
