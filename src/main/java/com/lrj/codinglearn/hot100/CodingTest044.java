package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第44题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest044 {

    /**
     * 230.二叉搜索树中第K小的元素
     * @author: luorenjie
     * @date: 2024/10/29 12:06
     * @param root
     * @param k
     * @return: int
     */
    public int kthSmallest(TreeNode root, int k) {
       //由于二叉搜索树是升序的，所以只需要先序遍历即可
        find(root, k);
        return min;
    }

    private void find(TreeNode root, int k) {
        if (root == null){
            return;
        }

        find(root.left, k);
        count++;
        if (count == k){
            min = root.val;
            return;
        }
        find(root.right, k);
    }

    int min = 0, count = 0;

    public static void main(String[] args) {
        CodingTest044 test = new CodingTest044();

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
        System.out.println(test.kthSmallest(treeNode1, 3));

    }
}
