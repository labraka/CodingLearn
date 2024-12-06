package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第43题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest043 {

    /**
     * 98.验证二叉搜索树
     * @author: luorenjie
     * @date: 2024/10/29 11:37
     * @param root
     * @return: boolean
     */
    public boolean isValidBST(TreeNode root) {
        //左子树节点小于根节点小于右子树节点
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null){
            return true;
        }

        //比较左子树
        if (minNode != null && root.val <= minNode.val){
            return false;
        }
        //比较右子树
        if (maxNode != null && root.val >= maxNode.val){
            return false;
        }

        //递归左右子树
        return isValidBST(root.left, minNode, root) && isValidBST(root.right, root, maxNode);
    }

    public static void main(String[] args) {
        CodingTest043 test = new CodingTest043();

        /**
         *
         *                  2
         *                 /\
         *                1  3
         *                   /\
         *                   4 5
         *
         */

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(1);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(4);
        treeNode12.left = new TreeNode(3);
        treeNode12.right = new TreeNode(5);
        System.out.println(test.isValidBST(treeNode1));

    }
}
