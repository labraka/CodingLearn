package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.ListNode;

import java.math.BigInteger;
import java.util.Stack;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第28题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest028 {


    /**
     * 2.两数相加
     * @author: luorenjie
     * @date: 2024/10/9 10:27
     * @param l1
     * @param l2
     * @return: com.lrj.codinglearn.ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /**
         *
         * 方法一：利用栈先进后出，将链表依次入栈，弹栈，再使用字符串操作，最后进行遍历组装成新链表
         *
         */
//        StringBuffer sb1 = new StringBuffer(), sb2 = new StringBuffer();
//        Stack<Integer> stack = new Stack<>();
//
//        while (l1 != null){
//            stack.add(l1.val);
//            l1 = l1.next;
//        }
//        while (!stack.isEmpty()){
//            sb1.append(stack.pop()+"");
//        }
//        while (l2 != null){
//            stack.add(l2.val);
//            l2 = l2.next;
//        }
//        while (!stack.isEmpty()){
//            sb2.append(stack.pop()+"");
//        }
//
//        BigInteger res = new BigInteger(sb1.toString()).add(new BigInteger(sb2.toString()));
//
//        for (char c : res.toString().toCharArray()) {
//            stack.add(Integer.valueOf(c-'0'));
//        }
//
//        ListNode listNode = new ListNode(0), p = listNode;
//        while (!stack.isEmpty()){
//            p.next = new ListNode(stack.pop());
//            p = p.next;
//        }
//
//        return listNode.next;

        /**
         *
         * 方法二：利用双指针
         *
         */
        ListNode listNode = new ListNode(0), lnP = listNode;
        ListNode p1 = l1, p2 = l2;

        //进位数缓存
        int carny = 0;

        while (p1 != null || p2 != null || carny > 0){
            //当前位加上上次进位
            int val = carny;
            if (p1 != null){
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null){
                val += p2.val;
                p2 = p2.next;
            }

            carny = val / 10;
            val = val % 10;
            lnP.next = new ListNode(val);
            lnP = lnP.next;
        }

        return listNode.next;

    }

    public static void main(String[] args) {
        CodingTest028 test = new CodingTest028();

        //链表1：[2,4,3]
        ListNode node1 = new ListNode(2);
        ListNode node11 = node1.next = new ListNode(4);
        node11.next = new ListNode(3);

        //链表2：[5,6,4]
        ListNode node2 = new ListNode(5);
        ListNode node21 = node2.next = new ListNode(6);
        node21.next = new ListNode(4);
        System.out.println(test.addTwoNumbers(node1, node2));


        //链表3：[9,9,9,9,9,9,9]
        ListNode node3 = new ListNode(9);
        ListNode node31 = node3.next = new ListNode(9);
        ListNode node32 = node31.next = new ListNode(9);
        ListNode node33 = node32.next = new ListNode(9);
        ListNode node34 = node33.next = new ListNode(9);
        ListNode node35 = node34.next = new ListNode(9);
        node35.next = new ListNode(9);

        //链表4：[9,9,9,9]
        ListNode node4 = new ListNode(9);
        ListNode node41 = node4.next = new ListNode(9);
        ListNode node42 = node41.next = new ListNode(9);
        node42.next = new ListNode(9);
        System.out.println(test.addTwoNumbers(node3, node4));

        //链表5：[9]
        ListNode node5 = new ListNode(9);

        //链表6：[1,9,9,9,9,9,9,9,9,9,9,9,9]
        ListNode node6 = new ListNode(1);
        ListNode node61 = node6.next = new ListNode(9);
        ListNode node62 = node61.next = new ListNode(9);
        ListNode node63 = node62.next = new ListNode(9);
        ListNode node64 = node63.next = new ListNode(9);
        ListNode node65 = node64.next = new ListNode(9);
        ListNode node66 = node65.next = new ListNode(9);
        ListNode node67 = node66.next = new ListNode(9);
        ListNode node68 = node67.next = new ListNode(9);
        node68.next = new ListNode(9);
        System.out.println(test.addTwoNumbers(node5, node6));

    }
}
