package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第23题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest023 {

    /**
     * 206.反转链表
     * @author: luorenjie
     * @date: 2024/9/25 10:39
     * @param head
     * @return: com.lrj.codinglearn.ListNode
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
//
//        /**
//         *
//         * 方法一：采用栈FILO，然后使用指针遍历链表
//         *
//         */
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null){
//            stack.add(head);
//            head = head.next;
//        }
//
//        ListNode root = new ListNode(0), p = root;
//        while (!stack.isEmpty()){
//            ListNode tmp = stack.pop();
//            p.next = tmp;
//            p = p.next;
//        }
//
//        p.next = null;
//        return root.next;

        /**
         *
         * 方法二：递归
         *
         */
        ListNode last = reverse(head);
        return last;
    }

    /**
     *
     *
     *         第一轮出栈，head为5，head.next为空，返回5
     *         第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
     *                   把当前节点的子节点的子节点指向当前节点
     *                   此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
     *                   此时链表为1->2->3->4<-5
     *                   返回节点5
     *         第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
     *                   此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
     *                   此时链表为1->2->3<-4<-5
     *                   返回节点5
     *         第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
     *                   此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
     *                   此时链表为1->2<-3<-4<-5
     *                   返回节点5
     *         第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
     *                   此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
     *                   此时链表为1<-2<-3<-4<-5
     *                   返回节点5
     *         出栈完成，最终头节点5->4->3->2->1
     *
     *
     * @author: luorenjie
     * @date: 2024/9/26 11:38
     * @param head
     * @return: com.lrj.codinglearn.ListNode
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    public static void main(String[] args) {
        CodingTest023 test = new CodingTest023();

        //链表1：[1,2,3,4,5]
        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(2);
        ListNode node12 = node11.next = new ListNode(3);
        ListNode node13 = node12.next = new ListNode(4);
        node13.next = new ListNode(5);

        //链表2：[1,2]
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);

        System.out.println(test.reverseList(node1));
        System.out.println(test.reverseList(node2));
    }
}
