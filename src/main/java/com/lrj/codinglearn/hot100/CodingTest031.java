package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第31题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest031 {

    /**
     * 25.K个一组翻转链表
     * @author: luorenjie
     * @date: 2024/10/11 11:17
     * @param head
     * @param k
     * @return: com.lrj.codinglearn.ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        /**
         *
         * 思路：递归
         *   1.以k个为一组，满足条件然后翻转该组，不满足则直接返回当前节点；
         *   2.然后将该组最后一个节点关联到下一组翻转后的头节点；
         *   3.重复上面步骤。
         */

        if (head == null || head.next == null){
            return head;
        }

        //a为需要翻转的链表，b为下一批需要翻转的链表
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null){
                return head;
            }
            b = b.next;
        }

        //翻转a链表
        ListNode resNode = reverse(a, b);
        //将a的尾节点挂在下一批要翻转的头节点
        a.next = reverseKGroup(b, k);
        return resNode;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        //pre为翻转后的结果集，cur为当前节点， nxt为下一个节点
        ListNode pre = null, cur = a, nxt = null;
        while (cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    public static void main(String[] args) {
        CodingTest031 test = new CodingTest031();

        //链表1：[1,2,3,4,5]
        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(2);
        ListNode node12 = node11.next = new ListNode(3);
        ListNode node13 = node12.next = new ListNode(4);
        node13.next = new ListNode(5);
        ListNode listNode = test.reverseKGroup(node1, 4);
        System.out.println(listNode);

    }
}
