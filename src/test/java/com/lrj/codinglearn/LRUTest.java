package com.lrj.codinglearn;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LRUTest
 * @Description:
 * @Date: 2023/10/31 18:00
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class LRUTest {
    public static void main(String[] args) {
        LRUTest lruTest = new LRUTest();
        LRUCache lRUCache = lruTest.new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1); // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2); // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1); // 返回 -1 (未找到)
        lRUCache.get(3); // 返回 3
        lRUCache.get(4); // 返回 4
    }



    //构建链表节点
    class Node{
        private int key, val;
        private Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    //构建双链表
    class DoubleList{
        //头、尾节点
        private Node head, tail;
        //链表元素数量
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        //在链表尾部添加节点x
        private void addLast(Node x){
            x.pre = tail.pre;
            x.next = tail;
            tail.pre.next = x;
            tail.pre = x;
            size++;
        }

        //删除链表节点x
        private void remove(Node x){
            x.pre.next = x.next;
            x.next.pre = x.pre;
            size--;
        }

        //删除链表的第一个节点，并返回改节点
        private Node removeFirst(){
            if (head.next == tail){
                return null;
            }

            Node first = head.next;
            remove(first);
            return first;
        }

        //返回链表长度
        private int size(){
            return size;
        }
    }



    //146.LRU缓存
    class LRUCache {

        private Map<Integer, Node> map;

        private DoubleList cache;
        //最大容量
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        //将key提升为最近使用的
        private void makeRecently(int key){
            Node x = map.get(key);

            //先从链表中删除这个节点
            cache.remove(x);

            //重新插入队尾
            cache.addLast(x);
        }

        //添加最近使用的元素啊
        private void addRecently(int key, int val){
            Node x = new Node(key, val);

            //链表尾部就是最近使用的元素
            cache.addLast(x);

            //添加映射
            map.put(key, x);
        }


        //删除某一个key
        private void deleteKey(int key){
            Node x = map.get(key);
            //从链表中删除
            cache.remove(x);
            //从映射中删除
            map.remove(key);
        }

        //删除最久未使用的元素
        private void removeLeastRecently(){
            //链表头部的第一个元素就是最久未使用的
            Node deleteNode = cache.removeFirst();
            //映射中删除
            int deleteKey = deleteNode.key;
            map.remove(deleteKey);

        }

        public int get(int key) {
            if (!map.containsKey(key)){
                return -1;
            }

            //提升为最近使用的
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            //如果存在则提升为最近使用的
            if (map.containsKey(key)){
                //删除旧的
                deleteKey(key);
                //添加新的
                addRecently(key, value);
                return;
            }

            //如果不存在
            //判断容量是否满了
            if (cache.size() == cap){
                removeLeastRecently();
            }
            addRecently(key, value);
        }
    }
}
