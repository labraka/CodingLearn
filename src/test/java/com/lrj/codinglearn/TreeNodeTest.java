package com.lrj.codinglearn;

import java.util.*;

/**
 * @ClassName: TreeNodeTest
 * @Description:
 * @Date: 2023/5/31 14:28
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class TreeNodeTest {

    public static void main(String[] args) {
        TreeNodeTest test = new TreeNodeTest();

        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

//        System.out.println(test.maxDepth(treeNode));
//        System.out.println(test.maxDepth1(treeNode));

//        System.out.println(test.diameterOfBinaryTree(treeNode));
//
//        TreeNode treeNode10 = new TreeNode(1);
//        TreeNode treeNode11 = new TreeNode(2);
//        TreeNode treeNode12 = new TreeNode(3);
//        TreeNode treeNode20 = new TreeNode(1);
//        TreeNode treeNode21 = new TreeNode(3);
//        TreeNode treeNode22 = new TreeNode(2);
//        treeNode10.left = treeNode11;
//        treeNode10.right = treeNode12;
//        treeNode20.left = treeNode21;
//        treeNode20.right = treeNode22;
//        System.out.println(test.isSameTree(treeNode10, treeNode20));

//        TreeNode node = test.invertTree(treeNode);
//        System.out.println(node);

//        test.flatten(treeNode);
//        System.out.println(treeNode);

//        test.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});

//        TreeNode root = test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
//        System.out.println(root);

//        TreeNode root = test.buildTree1(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//        System.out.println(root);


//        TreeNode root = test.constructFromPrePost(new int[]{3, 9, 20, 15, 7}, new int[]{9, 15, 7, 20, 3});
//        System.out.println(root);


//        System.out.println(test.findDuplicateSubtrees(treeNode));

//        String data = test.serialize(treeNode);
//        System.out.println(data);
//        TreeNode root = test.deserialize(data);
//        System.out.println(root);


//        int[] arrs = new int[]{4,9,5,1,2,6};
//        System.out.println(1/2);
//        System.out.println(test.sortArray(arrs));

//        TreeNode treeNode30 = new TreeNode(4);
//        TreeNode treeNode31 = new TreeNode(2);
//        TreeNode treeNode32 = new TreeNode(5);
//        TreeNode treeNode33 = new TreeNode(3);
//        treeNode30.left = treeNode31;
//        treeNode30.right = treeNode32;
//        treeNode31.right = treeNode33;
//        System.out.println(test.kthSmallest(treeNode30, 3));

//        TreeNode tr = test.convertBST(treeNode30);
//        System.out.println(tr);

//        TreeNode treeNode40 = new TreeNode(5);
//        TreeNode treeNode41 = new TreeNode(4);
//        TreeNode treeNode42 = new TreeNode(6);
//        TreeNode treeNode43 = new TreeNode(3);
//        TreeNode treeNode44 = new TreeNode(7);
//        treeNode40.left = treeNode41;
//        treeNode40.right = treeNode42;
//        treeNode42.left = treeNode43;
//        treeNode42.right = treeNode44;
//        System.out.println(test.isValidBST(treeNode40));


//        TreeNode treeNode50 = new TreeNode(4);
//        TreeNode treeNode51 = new TreeNode(2);
//        TreeNode treeNode52 = new TreeNode(7);
//        TreeNode treeNode53 = new TreeNode(1);
//        TreeNode treeNode54 = new TreeNode(3);
//
//        treeNode50.left = treeNode51;
//        treeNode50.right = treeNode52;
//        treeNode51.left = treeNode53;
//        treeNode51.right = treeNode54;
//        TreeNode tn = test.searchBST(treeNode50, 4);
//        System.out.println(tn);



        System.out.println(test.numTrees(5));

    }

    /**
     * 104 二叉树的最大深度
     *
     * 方法一：递归前序遍历
     *
     * 方法二：递归后序遍历
     */
    //记录遍历到节点的深度
    int depth = 0;
    //记录最大深度
    int res;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null){
            return;
        }

        //记录当前遍历节点的深度
        depth++;
        traverse(root.left);
        traverse(root.right);
        res = Math.max(res, depth);
        //遍历完弹栈的时候需要将当前深度-1
        depth--;
    }


    public int maxDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftMax = maxDepth1(root.left);
        int rightMax = maxDepth1(root.right);
        int res1 = Math.max(leftMax, rightMax) + 1;
        return res1;
    }


    /*
     * 543 二叉树的直径
     */

    //设置全局最大直径参数
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxD(root);
        return maxDiameter;
    }

    private int maxD(TreeNode root) {
        if (root == null){
            return 0;
        }

        int maxLeft = maxD(root.left);
        int maxRight = maxD(root.right);

        int maxD = maxLeft + maxRight;

        maxDiameter = Math.max(maxD, maxDiameter);
        return Math.max(maxLeft ,maxRight) + 1;
    }

    //相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //226 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        traverse1(root);
        return root;
    }
    private void traverse1(TreeNode root) {
        if (root == null){
            return;
        }

        //前序遍历
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //遍历左右子树
        traverse1(root.left);
        traverse1(root.right);
    }

    //114 将二叉树展开为链表
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left =null;
        root.right =left;

        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }


    //654 最大二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = build(nums, 0, nums.length - 1);
       return root;
    }

    private TreeNode build(int[] nums, int li, int ri) {
        if (nums.length == 0 || li > ri){
            return null;
        }
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i = li; i <= ri; i++) {
            if (maxVal < nums[i]){
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, li, index-1);
        root.right = build(nums, index + 1, ri);
        return root;
    }


    //105 从前序和中序遍历序列构造二叉树
    Map<Integer, Integer> iMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            iMap.put(inorder[i], i);
        }
        return traverseBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode traverseBuild(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd){
        if (preorder.length == 0 || preStart > preEnd){
            return null;
        }

        int rootVal = preorder[preStart];

        int index = iMap.get(rootVal);

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = traverseBuild(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = traverseBuild(preorder, preStart + leftSize + 1, preEnd, inorder, inEnd, index + 1);

        return root;
    }


    //106 从后序和中序遍历序列构造二叉树
    Map<Integer, Integer> iMap1 = new HashMap();
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            iMap1.put(inorder[i], i);
        }
        return build1(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build1(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postorder.length == 0 || postStart > postEnd){
            return null;
        }

        int rootVal = postorder[postEnd];

        int index = iMap1.get(rootVal);

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build1(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build1(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    //889 根据前序和后序遍历构造二叉树
    Map<Integer, Integer> pMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            pMap.put(postorder[i], i);
        }

        return build2(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build2(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preorder.length == 0 || preStart > preEnd){
            return null;
        }

        if (preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];

        int leftRootVal = preorder[preStart + 1];

        int index = pMap.get(leftRootVal);

        int leftSize = index - postStart + 1;

        TreeNode root = new TreeNode(rootVal);

        root.left = build2(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = build2(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);

        return root;
    }


    //652 寻找重复的子树
    Map<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res1 = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse11(root);
        return res1;

    }

    private String traverse11(TreeNode root){
        if (root == null){
            return "#";
        }

        String left = traverse11(root.left);
        String right = traverse11(root.right);

        String subTree = left + "," + right + "," + root.val;
        System.out.println(subTree);
        int freq = memo.getOrDefault(subTree, 0);

        if (freq == 1){
            res1.add(root);
        }
        memo.put(subTree, freq + 1);
        return subTree;
    }

    /**
     * 297 二叉树的序列化与反序列化
     * @param root
     * @return
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("#").append(",");
            return;
        }

        sb.append(root.val).append(",");
        traverse(root.left, sb);
        traverse(root.right, sb);
    }


    public TreeNode deserialize(String data) {
//        LinkedList<String> list = new LinkedList<>();
        List<String> l = new ArrayList<>();
        for (String s : data.split(",")) {
            l.add(s);
        }
        return traverse(l);
    }

    private TreeNode traverse(List<String> list){
        if (list.isEmpty()){
            return null;
        }

        String val = list.remove(0);
        if (val.equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));

        root.left = traverse(list);
        root.right = traverse(list);

        return root;
    }


    //912 排序数组
    public int[] sortArray(int[] nums) {

        /*
         * 采用归并排序
         */
//        Merge.sort(nums);

        /*
         * 采用快速排序
         */
//        quickSort(nums, 0, nums.length - 1);

        /*
         * 采用插入排序
         */
        insertSort(nums);

        return nums;
    }


    //归并排序
     static class Merge {
        private static int[] tmps;

        public static void sort(int[] nums) {
            tmps = new int[nums.length];
            sort(nums, 0, nums.length - 1);
        }

         private static void sort(int[] nums, int left, int right) {
            if (left == right){
                return;
            }

            int mid = left + (right - left) / 2;

            sort(nums, left, mid);
            sort(nums, mid+1, right);

            merge(nums, left, mid, right);
         }

         private static void merge(int[] nums, int left, int mid, int right) {
             for (int i = left; i <= right; i++) {
                 tmps[i] = nums[i];
             }

             int i = left, j = mid + 1;
             for (int p = left; p <= right; p++) {
                 if (i == mid + 1){
                     nums[p] = tmps[j];
                     j++;
                 } else if (j == right + 1) {
                     nums[p] = tmps[i];
                     i++;
                 } else if (tmps[i] > tmps[j]) {
                     nums[p] = tmps[j];
                     j++;
                 }else {
                     nums[p] = tmps[i];
                     i++;
                 }
             }
         }
     }

     //快速排序
    private void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }

        int base = nums[left];

        int i = left, j = right;
        while (i < j){
            while (i < j && nums[j] >= base){
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= base){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = base;

        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }

    //插入排序
    private void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j = i-1;

            while (j >= 0 && nums[j] > target){
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = target;
        }
    }


    //230 二叉搜索树中第k小的元素
    int m;
    int sort;
    public int kthSmallest(TreeNode root, int k) {
        /**
         * 中序遍历
         */
        traverse12(root, k);
        return m;
    }

    private void traverse12(TreeNode root, int k) {
        if (root == null){
            return;
        }

        traverse12(root.left, k);
        sort++;
        if (sort == k){
            m = root.val;
            return;
        }
        traverse12(root.right, k);

    }

    //538 把二叉搜索树转换为累加树

    public TreeNode convertBST(TreeNode root) {
        traverse13(root);
        return root;
    }
    int sum;
    private void traverse13(TreeNode root) {
        if (root == null){
            return;
        }
        traverse13(root.right);
        sum += root.val;
        System.out.println(sum);
        root.val = sum;
        traverse13(root.left);
    }


    //98 验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode maxRoot, TreeNode minRoot){
        if (root == null){
            return true;
        }

        if (maxRoot != null && root.val >= maxRoot.val){
            return false;
        }

        if (minRoot != null && root.val <= minRoot.val){
            return false;
        }

        return isValidBST(root.left, root, minRoot) && isValidBST(root.right, maxRoot, root);
    }

    //700 二叉搜索树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        //二分搜索
        if (root == null){
            return null;
        }

        if (root.val == val){
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        }else {
            return searchBST(root.right, val);
        }

    }


    //96 不同的二叉搜索树
    int [][] cache;
    public int numTrees(int n) {
        cache = new int[n+1][n+1];
        return count(1, n);
    }

    private int count(int l, int r) {
        if (l > r){
            return 1;
        }

        if (cache[l][r] != 0){
            return cache[l][r];
        }

        int res = 0;
        for (int i = l; i <= r; i++) {
            int left = count(l, i-1);
            int right = count(i+1, r);
            res += left * right;
        }
        return res;
    }

    class NestedIterator implements Iterator<Integer> {

        private  Iterator<Integer> it;
        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> resList = new LinkedList();
            for (NestedInteger nestedInteger : nestedList) {
                traverse15(nestedInteger, resList);
            }

            it = resList.listIterator();
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        private void traverse15(NestedInteger nestedInteger, List<Integer> resList) {
            if (nestedInteger.isInteger()){
                resList.add(nestedInteger.getVal());
                return;
            }

            for (NestedInteger integer : nestedInteger.getList()) {
                traverse15(integer, resList);
            }
        }




        class NestedInteger{
            private Integer val;
            private List<NestedInteger> list;

            public NestedInteger(Integer val) {
                this.val = val;
            }

            public NestedInteger(List<NestedInteger> list) {
                this.list = list;
            }

            public Integer getVal() {
                return val;
            }

            public boolean isInteger(){
                return val != null;
            }

            public List<NestedInteger> getList() {
                return list;
            }
        }

    }
}
