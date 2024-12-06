package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第42题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest042 {

    /**
     * 108.将有序数组转换为二叉搜索树
     * @author: luorenjie
     * @date: 2024/10/25 14:44
     * @param nums
     * @return: com.lrj.codinglearn.TreeNode
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildAVLTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildAVLTree(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }

        //先序遍历，以中间节点为根节点展开
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildAVLTree(nums, left, mid - 1);
        root.right = buildAVLTree(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        CodingTest042 test = new CodingTest042();

        /**
         *
         *                  3
         *                 /\
         *                9  20
         *                    /\
         *                   15 7
         *
         */

//        TreeNode treeNode1 = new TreeNode();
//        TreeNode treeNode11 = treeNode1.left = new TreeNode(9);
//        TreeNode treeNode12 = treeNode1.right = new TreeNode(20);
//        treeNode12.left = new TreeNode(15);
//        treeNode12.right = new TreeNode(7);
        TreeNode root = test.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(root);

    }
}
