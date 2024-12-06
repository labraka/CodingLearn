package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第50题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest050 {


    /**
     * 124.二叉树中的最大路径和
     * @author: luorenjie
     * @date: 2024/11/28 10:47
     * @param root
     * @return: int
     */
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        //遍历左右节点值
        int leftMax = maxPathSum(root.left);
        int rightMax = maxPathSum(root.right);
        /*
         * 四种情况：
         * 1.返回自己节点
         * 2.返回和右节点值
         * 3.返回和左节点值
         *
         */
        int curMax = Math.max(root.val, root.val + Math.max(leftMax, rightMax));
        //4.和左右节点的值
        res =  Math.max(res, Math.max(curMax, root.val + leftMax + rightMax));
        return curMax;
    }


    public static void main(String[] args) {
        CodingTest050 test = new CodingTest050();

        /**
         *
         *                -10
         *                 /\
         *                9  20
         *                   /\
         *                  15 7
         *
         *
         */
        TreeNode treeNode1 = new TreeNode(-10);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(9);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(20);
        TreeNode treeNode111 = treeNode12.left = new TreeNode(15);
        TreeNode treeNode112 = treeNode12.right = new TreeNode(7);
        int maxNum = test.maxPathSum(treeNode1);
        System.out.println(maxNum);
    }
}
