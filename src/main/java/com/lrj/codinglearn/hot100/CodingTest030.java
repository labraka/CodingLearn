package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;



/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第30题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest030 {

    /**
     * 24.两两交换链表中的节点
     * @author: luorenjie
     * @date: 2024/10/10 11:41
     * @param head
     * @return: com.lrj.codinglearn.ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        /**
         *
         * 方法一：递归
         *
         *       1-->2-->3-->4-->5               2-->1-->3-->4-->5
         *       ↑   ↑   ↑               ====>
         *       one two three
         *
         *
         */

//        ListNode one = head;
//        ListNode two = one.next;
//        ListNode three = two.next;
//        two.next = one;
//        one.next = swapPairs(three);
//
//        return two;

        /**
         *
         * 方法二：交换
         *
         *                  1-->2-->3-->4-->5                2-->1-->3-->4-->5
         *                  ↑   ↑   ↑               ====>    ↑   ↑   ↑
         *                  one two three                    two one three
         *
         */

        ListNode listNode = new ListNode(0), p1 = listNode;
        listNode.next = head;
        while (p1.next != null && p1.next.next != null){
            ListNode node1 = p1.next;
            ListNode node2 = p1.next.next;

            p1.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            p1 = node1;
        }

        return listNode.next;
    }


    public static void main(String[] args) {
        CodingTest030 test = new CodingTest030();

        //链表1：[1,2,3,4,5]
        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(2);
        ListNode node12 = node11.next = new ListNode(3);
        ListNode node13 = node12.next = new ListNode(4);
        node13.next = new ListNode(5);
        ListNode listNode = test.swapPairs(node1);
        System.out.println(listNode);

    }
}
