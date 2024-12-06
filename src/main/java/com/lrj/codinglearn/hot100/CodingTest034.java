package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.ListNode;

import java.util.PriorityQueue;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第34题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest034 {


    /**
     * 23.合并K个升序链表
     * @author: luorenjie
     * @date: 2024/10/14 12:05
     * @param lists
     * @return: com.lrj.codinglearn.ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        //采用优先级队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) ->{
            return a.val - b.val;
        });

        for (ListNode node : lists) {
            while (node != null){
                pq.add(node);
                node = node.next;
            }
        }
        ListNode listNode = new ListNode(0), pre = listNode;
        while (!pq.isEmpty()){
            ListNode tmp = pq.poll();
            pre.next = tmp;
            if (tmp.next != null){
                tmp.next = null;
            }

            pre = pre.next;
        }

        return listNode.next;
    }


    public static void main(String[] args) {
        CodingTest034 test = new CodingTest034();

        //链表1：[1,2,3,4,5]
        ListNode[] nodes = new ListNode[3];

        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(3);
        ListNode node12 = node11.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        ListNode node21 = node2.next = new ListNode(2);
        ListNode node22 = node21.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        ListNode node31 = node3.next = new ListNode(6);

        nodes[0] = node1;
        nodes[1] = node2;
        nodes[2] = node3;
       ListNode listNode = test.mergeKLists(nodes);
       System.out.println(listNode);

    }
}
