package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.util.*;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第36题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest036 {


    /**
     * 94.二叉树的中序遍历
     * @author: luorenjie
     * @date: 2024/10/16 16:26
     * @param root
     * @return: java.util.List<java.lang.Integer>
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //使用递归调用：中序：左-->中-->右
        getVal(root);
        return res;
    }

    private void getVal(TreeNode root){
        if (root == null){
            return;
        }
        getVal(root.left);
        res.add(root.val);
        getVal(root.right);

    }

    public static void main(String[] args) {
        CodingTest036 test = new CodingTest036();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = treeNode1.right = new TreeNode(2);
        TreeNode treeNode12 = treeNode11.left = new TreeNode(3);
        List<Integer> list = test.inorderTraversal(treeNode1);
       System.out.println(list);

    }
}
