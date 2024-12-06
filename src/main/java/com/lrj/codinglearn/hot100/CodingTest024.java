package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第24题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest024 {

    /**
     * 234.回文链表
     * @author: luorenjie
     * @date: 2024/9/26 11:42
     * @param head
     * @return: boolean
     */
    public boolean isPalindrome(ListNode head) {
        /**
         *
         * 方法一：集合+双指针
         *
         */
//        List<Integer> list = new ArrayList<>();
//        while (head != null){
//            list.add(head.val);
//            head = head.next;
//        }
//
//        int l = 0, r = list.size() - 1;
//        while (l < r){
//            if (!list.get(l).equals(list.get(r))){
//                return false;
//            }
//            l++;
//            r--;
//        }
//
//        return true;

        /**
         *
         * 方法二：递归
         *
         * tmp入栈：1-221
         *
         */

        tmp = head;
        return reverse(head);

    }

    ListNode tmp;
    private boolean reverse(ListNode head) {
        if (head == null){
            return true;
        }

        boolean last = reverse(head.next);
        if (head.val != tmp.val){
            return false;
        }

        tmp = tmp.next;
        return last;
    }


    public static void main(String[] args) {
        CodingTest024 test = new CodingTest024();

        //链表1：[1,2,2,1]
        ListNode node1 = new ListNode(1);
        ListNode node11 = node1.next = new ListNode(2);
        ListNode node12 = node11.next = new ListNode(2);
        node12.next = new ListNode(1);

        //链表2：[1,2]
        ListNode node2 = new ListNode(1);
        ListNode node21 = node2.next = new ListNode(2);
        node21.next = new ListNode(1);

        System.out.println(test.isPalindrome(node1));
        System.out.println(test.isPalindrome(node2));
    }
}
