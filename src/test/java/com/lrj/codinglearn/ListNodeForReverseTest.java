package com.lrj.codinglearn;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @ClassName: ListNodeForTwoPointerTest
 * @Description: 递归方式做链表题目
 * @Date: 2023/5/5 14:50
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class ListNodeForReverseTest {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode15 = new ListNode(5);

        listNode1.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;

        ListNode listNode2 = new ListNode(3);
        ListNode listNode22 = new ListNode(4);
        ListNode listNode23 = new ListNode(5);

        listNode2.next = listNode22;
        listNode22.next = listNode23;

        ListNodeForReverseTest test = new ListNodeForReverseTest();



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
        ListNode listNode72 = new ListNode(3);
        ListNode listNode73 = new ListNode(2);
        ListNode listNode74 = new ListNode(1);
        listNode7.next = listNode71;
        listNode71.next = listNode72;
        listNode72.next = listNode73;
        listNode73.next = listNode74;

//        ListNode listNode = test.reverseList2(listNode1);
//        ListNode listNode = test.reverseN(listNode1, 3);
//        ListNode listNode = test.reverseBetween(listNode1, 2,4);
//        ListNode listNode = test.reverseBetween1(listNode1, 2,4);
//        ListNode listNode = test.reverse(listNode1);
//        ListNode listNode = test.reverseKGroup(listNode1, 2);
        boolean yes = test.isPalindrome1(listNode7);
    }


    //206 反转链表（递归）
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //206 反转链表（栈）
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
       ListNode listNode = new ListNode(0), p = listNode;
        while (!stack.isEmpty()){
           ListNode tempNode = stack.pop();
           p.next = tempNode;
           p =p.next;
        }
        p.next = null;
        return listNode.next;
    }

    //206 反转链表（双链表）
    public ListNode reverseList2(ListNode head) {
        ListNode listNode = null;
        while (head != null){
            ListNode tempNode = head.next;
            head.next =listNode;
            listNode = head;
            head = tempNode;
        }

        return listNode;
    }

    //拓展
    ListNode listNode = null;
    public ListNode reverseN(ListNode head, int n){
        if (n == 1){
            listNode = head.next;
            return head;
        }

        ListNode lastNode = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = listNode;

        return lastNode;
    }


    //92 反转链表 II（递归）
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left -1, right - 1);
        return head;
    }

    //92 反转链表 II（双指针）
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        //定义一个空结点
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode p1 = listNode, p2 = listNode.next;

        //移动指针，先将p1移动到指定位置
        for (int i = 0; i < left - 1; i++) {
            p1 = p1.next;
            p2 = p2.next;
        }

        for (int i = 0; i < right - left; i++) {
            ListNode tempNode = p2.next;
            p2.next = p2.next.next;
            tempNode.next = p1.next;
            p1.next = tempNode;
        }

        return listNode.next;
    }


    //25 K 个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null){
                return head;
            }
            b = b.next;
        }

        ListNode resNode = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return resNode;
    }

    //双指针反转单链表
    private ListNode reverse(ListNode node){
        ListNode pre = null, cur = node, nxt = node;
        while (cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private ListNode reverse(ListNode na, ListNode nb){
        ListNode pre = null, cur = na, nxt = na;
        while (cur != nb){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    //234 回文链表（反转递归比较值）
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    //递归和正序节点比较
    private boolean traverse(ListNode right) {
        if (right == null){
            return true;
        }

        boolean res = traverse(right.next);
        res = res && left.val == right.val;

        left = left.next;

        return res;
    }


    //234 回文链表（快慢指针 递归反转链表比较值，优化空间复杂度）
    public boolean isPalindrome1(ListNode head) {
        if (head == null){
            return false;
        }

        //设置快慢指针
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //当快指针不为null时则慢指针往前走一步
        if (fast != null){
            slow = slow.next;
        }


        ListNode l = head;
        ListNode r = reverse(slow);
        while (r != null){
            if (l.val != r.val){
                return false;
            }
            l = l.next;
            r = r.next;
        }
        return true;
    }


}
