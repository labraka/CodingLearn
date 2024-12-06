package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第29题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest029 {

    /**
     * 19.删除链表的倒数第N个结点
     * @author: luorenjie
     * @date: 2024/10/10 10:46
     * @param head
     * @param n
     * @return: com.lrj.codinglearn.ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0){
            return head;
        }

        //先让指针p1走n步
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        ListNode listNode = new ListNode(0), p2 = listNode;
        listNode.next = head;

        //指针p2和p1同时走剩下的k-n步
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        /**
         *
         * k=5,n=2
         * 这时让指针p2的下一个节点指向下下个节点
         *
         *
         *  (listNode)     0-->1-->2-->3-->4-->5
         *                             ↑
         *                             p2
         *
         *                             0-->1-->2-->4-->5
         */

        p2.next = p2.next.next;

        return listNode.next;

    }

    public static void main(String[] args) {
        CodingTest029 test = new CodingTest029();

        //链表1：[1,2,3,4,5]
        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(2);
        ListNode node12 = node11.next = new ListNode(3);
        ListNode node13 = node12.next = new ListNode(4);
        node13.next = new ListNode(5);

        System.out.println(test.removeNthFromEnd(node1, 2));

    }
}
