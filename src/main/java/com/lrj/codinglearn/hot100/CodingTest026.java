package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第26题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest026 {

    /**
     * 142.环形链表II
     * @author: luorenjie
     * @date: 2024/9/30 15:09
     * @param head
     * @return: com.lrj.codinglearn.ListNode
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        //是否有环
        boolean have  = false;
        //使用快慢指针，当快指针追上慢指针时，说明有环
        ListNode slow = head, fast = head;
        while (fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                have = true;
                break;
            }
        }

        //如果有环，则将快慢指针任意一个作为头节点，并且一起往下走，相交点就是环的起点
        slow = head;
        while (have){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return null;

    }


    public static void main(String[] args) {
        CodingTest026 test = new CodingTest026();

        /**
         *
         *   链表1：[1,2,2,1]
         *       1-->2-->2-->1
         *           ↑_______|
         *
         */
        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(2);
        ListNode node12 = node11.next = new ListNode(2);
        ListNode node13 = node12.next = new ListNode(1);
        node13.next = node11;

        //链表2：[1,2]
        ListNode node2 = new ListNode(1);
        ListNode node21 = node2.next = new ListNode(2);
//        node21.next = node2;
        System.out.println(test.detectCycle(node1));
        System.out.println(test.detectCycle(node2));
    }
}
