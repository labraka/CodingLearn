package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第45题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest045 {

    /**
     * 199.二叉树的右视图
     * @author: luorenjie
     * @date: 2024/11/13 17:48
     * @param root
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        find(root, deep, res);
        return res;
    }

    private void find(TreeNode root, int deep, List<Integer> res) {
        if (root == null){
            return;
        }

        if (deep == res.size()){
            res.add(root.val);
        }

        //现遍历右子树
        find(root.right, deep + 1, res);
        find(root.left, deep + 1, res);
    }

    int deep;
    public static void main(String[] args) {
        CodingTest045 test = new CodingTest045();

        /**
         *
         *                  1
         *                 /\
         *                2  3
         *                 \   \
         *                  5   4
         *
         */

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = treeNode1.left = new TreeNode(2);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(3);
        treeNode11.right = new TreeNode(5);
        treeNode12.right = new TreeNode(4);
        System.out.println(test.rightSideView(treeNode1));

    }
}
