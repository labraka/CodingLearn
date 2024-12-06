package com.lrj.codinglearn;

import java.util.PriorityQueue;

/**
 * @ClassName: ListNodeForTwoPointerTest
 * @Description: 双指针方式做链表题目
 * @Date: 2023/5/5 14:50
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class ListNodeForTwoPointerTest {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode14 = new ListNode(5);
        ListNode listNode15 = new ListNode(6);

        listNode1.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;

        ListNode listNode2 = new ListNode(3);
        ListNode listNode22 = new ListNode(4);
        ListNode listNode23 = new ListNode(5);

        listNode2.next = listNode22;
        listNode22.next = listNode23;

        ListNodeForTwoPointerTest test = new ListNodeForTwoPointerTest();
//        ListNode resList = test.mergeTwoLists(listNode1, listNode2);
//        ListNode resList1 = test.mergeTwoLists1(listNode1, listNode2);



        ListNode listNode3 = new ListNode(2);
        ListNode listNode32 = new ListNode(6);
        ListNode listNode33 = new ListNode(7);
        ListNode listNode34 = new ListNode(8);
        ListNode listNode35 = new ListNode(9);
        ListNode listNode36 = new ListNode(10);

        listNode3.next = listNode32;
        listNode32.next = listNode33;
        listNode33.next = listNode34;
        listNode34.next = listNode35;
        listNode35.next = listNode36;

        ListNode listNode4 = new ListNode(3);
        ListNode listNode41 = new ListNode(2);
        ListNode listNode42 = new ListNode(0);
        ListNode listNode43 = new ListNode(-4);

        listNode4.next = listNode41;
        listNode41.next = listNode42;
        listNode42.next = listNode43;
        listNode43.next = listNode41;

        ListNode listNode5 = new ListNode(1);
        ListNode listNode52 = new ListNode(2);
        ListNode listNode53 = new ListNode(3);
        ListNode listNode54 = new ListNode(4);
        ListNode listNode55 = new ListNode(5);
        ListNode listNode6 = new ListNode(8);
        listNode5.next = listNode52;
        listNode52.next = listNode53;
        listNode53.next = listNode54;
        listNode54.next = listNode55;
        listNode6.next = listNode53;


        ListNode listNode7 = new ListNode(1);
        ListNode listNode71 = new ListNode(2);
        ListNode listNode72 = new ListNode(2);
        ListNode listNode73 = new ListNode(3);
        ListNode listNode74 = new ListNode(3);
        ListNode listNode75 = new ListNode(1);

        listNode7.next = listNode71;
        listNode71.next = listNode72;
        listNode72.next = listNode73;
        listNode73.next = listNode74;
        listNode74.next = listNode75;
//        ListNode resList2 = test.partition(listNode3, 3);
        ListNode[] listNodes = {listNode1, listNode2, listNode3};
//        ListNode listNode = test.mergeKLists(listNodes);
//        ListNode listNode = test.removeNthFromEnd(listNode1, 2);
//        ListNode listNode = test.middleNode(listNode1);
//        ListNode listNode = test.detectCycle(listNode4);
//        ListNode listNode = test.getIntersectionNode(listNode5, listNode6);
        ListNode listNode = test.deleteDuplicates(listNode7);

    }


    //86 分隔链表
    public ListNode partition(ListNode head, int x) {
        ListNode smaNode = new ListNode(0), p1 = smaNode;
        ListNode bigNode = new ListNode(0), p2 = bigNode;
        ListNode p = head;
        while (p != null){
            if (p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = bigNode.next;
        return smaNode.next;
    }

    //21 合并两个有序链表 (双指针)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0), limitNode = listNode;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                limitNode.next = list2;
                list2 = list2.next;
            } else {
                limitNode.next = list1;
                list1 = list1.next;
            }
            limitNode = limitNode.next;
        }

        if (list1 != null){
            limitNode.next = list1;
        }
        if (list2 != null){
            limitNode.next = list2;
        }
        return listNode.next;
    }


    //21 合并两个有序链表（递归）
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val){
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists1(list1, list2.next);
        return list2;
    }



    //23 合并K个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        ListNode listNode = new ListNode(0), p = listNode;

        //使用优先级队列，最小堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (v1, v2) ->(v1.val - v2.val));
        for (ListNode node : lists) {
            if (node != null){
                priorityQueue.add(node);
            }
        }
        while (!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null){
                priorityQueue.add(node.next);
            }
            p = p.next;
        }

        return listNode.next;
    }


    //19 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        if (n == 0){
            return head;
        }

        //指针p1先走n步
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        //设置空结点，并设置指针p2
        ListNode listNode = new ListNode(0), p2 = listNode;
        listNode.next = head;

        //两个指针同时往下走，当p1为null走完，p2则走到p1上面
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        //将p2的下个节点删除
        p2.next = p2.next.next;

        return listNode.next;
    }


    //876 链表的中间结点
    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    //142 环形链表
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean have = false;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                have = true;
                break;
            }
        }

        if (have){
            fast = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    //160 相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2){
            if (p1 != null){
                p1 = p1.next;
            }else {
                p1 = headB;
            }

            if (p2 != null){
                p2 = p2.next;
            }else {
                p2 = headA;
            }
        }
        return p1;
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head, fast = head;
        while(fast != null){
            if (slow.val != fast.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
