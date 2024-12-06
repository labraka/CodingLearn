package com.lrj.codinglearn;

/**
 * @ClassName: ListNode
 * @Description: 链表类
 * @Date: 2023/5/5 14:51
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {

    }
}
