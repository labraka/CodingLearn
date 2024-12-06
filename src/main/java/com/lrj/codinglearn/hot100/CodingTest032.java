package com.lrj.codinglearn.hot100;

import com.lrj.codinglearn.Node1;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第32题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest032 {

    /**
     * 138.随机链表的复制
     * @author: luorenjie
     * @date: 2024/10/11 14:04
     * @param head
     * @return: com.lrj.codinglearn.Node1
     */
    public Node1 copyRandomList(Node1 head) {

        /**
         *
         * 使用map缓存：key对应旧节点，value构建新节点
         * 再遍历map，将下一节点
         *
         */
        Map<Node1, Node1> map = new HashMap<>();
        Node1 cur = head;
        while (cur != null){
            map.put(cur, new Node1(cur.val));
            cur = cur.next;
        }

        //遍历将新节点的下一个节点和随机指针赋值
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        
        return map.get(head);
    }




    public static void main(String[] args) {
        CodingTest032 test = new CodingTest032();

        //链表1：[1,2,3,4,5]
        Node1 node1 = new Node1(7);
        Node1 node11 = node1.next = new Node1(13);
        Node1 node12 = node11.next = new Node1(11);
        Node1 node13 = node12.next = new Node1(10);
        Node1 node14 = node13.next = new Node1(1);

        node1.random = null;
        node11.random = node1;
        node12.random = node14;
        node13.random = node12;
        node14.random = node1;

        Node1 node = test.copyRandomList(node1);
        System.out.println(node);

    }
}
