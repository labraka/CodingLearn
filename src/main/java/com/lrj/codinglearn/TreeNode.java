package com.lrj.codinglearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TreeNode
 * @Description: 树
 * @Date: 2023/5/4 16:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    static List<Integer> list = new ArrayList<>();
    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    private void traverse(TreeNode root){
        if (root != null){
            traverse(root.left);
            traverse(root.right);
            list.add(root.val);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 30;

        TreeNode leftNode = new TreeNode();
        TreeNode rightNode  = new TreeNode();
        leftNode.val = 15;
        rightNode.val = 40;
        root.left = leftNode;
        root.right = rightNode;

        TreeNode leftNode1 = new TreeNode();
        TreeNode rightNode1  = new TreeNode();
        leftNode1.val = 1;
        rightNode1.val = 20;
        leftNode.left = leftNode1;
        leftNode.right = rightNode1;

        TreeNode leftNode2 = new TreeNode();
        TreeNode rightNode2  = new TreeNode();
        leftNode2.val = 35;
        rightNode2.val = 50;
        rightNode.left = leftNode2;
        rightNode.right = rightNode2;



        root.traverse(root);
        System.out.println(list);
        System.out.println(root.oneSideMax(root));
        int[] pres = {30, 15, 1, 20, 40, 35, 50};
        int[] ines = {1, 15, 20, 30, 35, 40, 30};
        TreeNode node = root.build(pres, 0, 6, ines, 0, 6);
        System.out.println(node);
    }


    int res = Integer.MIN_VALUE;
    int oneSideMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
        // 后序位置
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        // 前序位置，寻找左右子树的索引
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
