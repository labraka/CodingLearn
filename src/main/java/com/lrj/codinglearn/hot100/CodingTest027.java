package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;

import java.util.PriorityQueue;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第27题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest027 {

    /**
     * 21.合并两个有序链表
     * @author: luorenjie
     * @date: 2024/10/8 10:54
     * @param list1
     * @param list2
     * @return: com.lrj.codinglearn.ListNode
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        /**
         *
         * 方法一：采用优先级队列，将节点添加到队列
         *
         */
//        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) ->{
//            return a.val - b.val;
//        });
//
//        while (list1 != null){
//            pq.add(list1);
//            list1 = list1.next;
//        }
//        while (list2 != null){
//            pq.add(list2);
//            list2 = list2.next;
//        }
//        //通过指针往下遍历，返回对应结果集
//        ListNode res = new ListNode(0), p = res;
//        while (!pq.isEmpty()){
//            ListNode tmp = pq.poll();
//            p.next = tmp;
//            tmp.next = null;
//            p = p.next;
//        }
//
//        return res.next;


        /**
         *
         * 方法二：直接比较
         *
         */

        ListNode res = new ListNode(0), p = res;

        while (list1 != null &&  list2 != null){
            if (list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 != null){
            p.next = list1;
        }

        if (list2 != null){
            p.next = list2;
        }

        return res.next;

    }

    public static void main(String[] args) {
        CodingTest027 test = new CodingTest027();

        /**
         *
         *   链表1：[1,2,3,4]
         *       1-->2-->3-->4
         *
         */
        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(2);
        ListNode node12 = node11.next = new ListNode(3);
        ListNode node13 = node12.next = new ListNode(4);

        //链表2：[1,2]
        ListNode node2 = new ListNode(3);
        ListNode node21 = node2.next = new ListNode(6);
//        node21.next = node2;
        System.out.println(test.mergeTwoLists(node1, node2));
    }
}
