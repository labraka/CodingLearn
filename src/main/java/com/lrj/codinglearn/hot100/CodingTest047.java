package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第47题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest047 {

    /**
     * 105.从前序与中序遍历序列构造二叉树
     * @author: luorenjie
     * @date: 2024/11/14 11:53
     * @param preorder
     * @param inorder
     * @return: com.lrj.codinglearn.TreeNode
     */
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //将中序的值和下标存在map中供后续使用
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //构建TreeNode
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1){
            return null;
        }
        //根节点的值
        int rootVal = preorder[start1];;

        //根节点在中序遍历中的下标
        int rootIndex = map.get(rootVal);

        //找到左子树的的数量大小
        int leftSize = rootIndex - start2;

        //构建节点
        TreeNode root = new TreeNode(rootVal);

        /*
         *  index：0  1   2    3  4
         *         3  9 | 20  15  7
         *         ↑
         *         9  3 | 15  20  7
         *       left ↑ right
         *
         */

        root.left = buildTree(preorder, start1 + 1, start1 + leftSize, inorder, start2, rootIndex - 1);
        root.right = buildTree(preorder, start1 + leftSize + 1, end1, inorder, rootIndex + 1, end2);

        return root;
    }


    public static void main(String[] args) {
        CodingTest047 test = new CodingTest047();

        /**
         *
         *                 3
         *                 /\
         *                9  20
         *                    /\
         *                   15 7
         *
         */
        int[] preorder = new int[]{3,9,20,15,7}, inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = test.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
