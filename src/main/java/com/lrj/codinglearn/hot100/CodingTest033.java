package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.ListNode;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第33题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest033 {


    /**
     * 148.排序链表
     * @author: luorenjie
     * @date: 2024/10/12 16:58
     * @param head
     * @return: ListNode
     */
    public ListNode sortList(ListNode head) {
        /**
         *
         * 方法一：优先级队列排序
         *
         */

//        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) ->{
//            return a.val - b.val;
//        });
//
//        while (head != null){
//            pq.add(head);
//            head = head.next;
//        }
//        ListNode listNode = new ListNode(0), p = listNode;
//        while (!pq.isEmpty()){
//            ListNode tmp = pq.poll();
//            p.next = tmp;
//            tmp.next = null;
//            p = p.next;
//        }
//
//        return listNode.next;


        /**
         *
         * 方法二（进阶）：归并排序
         *
         */

        if (head == null || head.next == null){
            return head;
        }

        //拆分链表
        ListNode newNode = split(head);

        //递归拆分
        head = sortList(head);
        newNode = sortList(newNode);

        //比较大小并合并
        return merge(head, newNode);
    }

    private ListNode split(ListNode head){
        //使用快慢指针，拆分链表
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = slow;

        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode resNode = slow.next;
        slow.next = null;

        return resNode;
    }
    private ListNode merge(ListNode head1, ListNode head2){
        //设置两个链表对应指针
        ListNode p1 = head1, p2 = head2;
        //设置结果集链表
        ListNode resNode = new ListNode(0), pre = resNode;

        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                pre.next = p2;
                p2 = p2.next;
            }else {
                pre.next = p1;
                p1 = p1.next;
            }
            pre = pre.next;
        }

        if (p1 != null){
            pre.next = p1;
        }
        if (p2 != null){
            pre.next = p2;
        }

        return resNode.next;
    }


    public static void main(String[] args) {
        CodingTest033 test = new CodingTest033();

        //链表1：[1,2,3,4,5]
        ListNode node1 = new ListNode(4);
        ListNode node11 = node1.next = new ListNode(2);
        ListNode node12 = node11.next = new ListNode(1);
        ListNode node13 = node12.next = new ListNode(3);

       ListNode listNode = test.sortList(node1);
       System.out.println(listNode);

    }
}
