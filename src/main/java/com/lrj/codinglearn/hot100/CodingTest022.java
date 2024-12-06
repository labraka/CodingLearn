package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第22题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest022 {

    /**
     * 160.相交链表
     * @author: luorenjie
     * @date: 2024/9/24 15:09
     * @param headA
     * @param headB
     * @return: ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        /**
         *
         * 通过两个指针分别在两个链表向下移动，当指针遍历完链表则切换到另一条链表，
         * 当两个指针重合，则表示到达公共节点了
         *        示例：
         *                                             | p1
         *                                             | ↓
         *        1 9 1 2 4    ------>       1 9 1 2 4 3 2 4
         *        3 2 4        ------>       3 2 4 1 9 1 2 4
         *                                         |     ↑
         *                                         |     p2
         *
         */

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

    public static void main(String[] args) {
        CodingTest022 test = new CodingTest022();
        //公共部分
        ListNode nodeP1 = new ListNode(2);
        nodeP1.next = new ListNode(4);

        //链表1：[1,9,1,2,4]
        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(9);
        ListNode node12 = node11.next = new ListNode(1);
        node12.next = nodeP1;

        //链表2：[3,2,4]
        ListNode node2 = new ListNode(3);
        node2.next = nodeP1;

        System.out.println(test.getIntersectionNode(node1, node2));
    }
}
