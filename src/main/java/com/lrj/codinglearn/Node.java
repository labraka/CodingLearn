package com.lrj.codinglearn;

/**
 * @ClassName: Node
 * @Description: 带next的树
 * @Date: 2023/6/6 16:42
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
