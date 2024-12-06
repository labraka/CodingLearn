package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第41题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest041 {

    /**
     * 102.二叉树的层序遍历
     * @author: luorenjie
     * @date: 2024/10/22 10:35
     * @param root
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null){
            return resList;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                level.add(curNode.val);
                if (curNode.left != null){
                    q.offer(curNode.left);
                }
                if (curNode.right != null){
                    q.offer(curNode.right);
                }
            }

            resList.add(level);
        }

        return resList;
    }

    public static void main(String[] args) {
        CodingTest041 test = new CodingTest041();

        /**
         *
         *                  3
         *                 /\
         *                9  20
         *                    /\
         *                   15 7
         *
         */

        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode11 = treeNode1.left = new TreeNode(9);
        TreeNode treeNode12 = treeNode1.right = new TreeNode(20);
        treeNode12.left = new TreeNode(15);
        treeNode12.right = new TreeNode(7);

        System.out.println(test.levelOrder(treeNode1));

    }
}
