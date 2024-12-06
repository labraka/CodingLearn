package com.lrj.codinglearn;


/**
 * @ClassName: NodeTest
 * @Description:
 * @Date: 2023/6/6 16:43
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class NodeTest {

    public static void main(String[] args) {

        NodeTest test = new NodeTest();

        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println(test.connect(node));


    }

    /**
     * 116 填充每个二叉树节点的右侧指针
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node left, Node right) {
        if (left == null || right == null){
            return;
        }

        left.next = right;

        traverse(left.left, left.right);
        traverse(right.left, right.right);

        traverse(left.right, right.left);

    }

}
