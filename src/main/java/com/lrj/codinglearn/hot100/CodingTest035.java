package com.lrj.codinglearn.hot100;


import com.lrj.codinglearn.ListNode;

import java.util.*;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第35题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest035 {

    /**
     * 146.LRU缓存
     * @author: luorenjie
     * @date: 2024/10/15 10:32
     * @param capacity
     * @return: null
     */
    Map<Integer, Integer> cache;
    int cap;
    public CodingTest035(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        //将当前查询的放到链表尾部
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        //如果是有缓存，则变为最近使用
        if (cache.containsKey(key)){
            //将当前查询的放到链表尾部
            makeRecently(key);
            return;
        }

        //删除链表头部的
        if (cache.size() == cap){
            Iterator iterator = cache.keySet().iterator();
            cache.remove(iterator.next());
        }

        cache.put(key, value);
    }

    private void makeRecently(int key){
        Integer oldVal = cache.get(key);
        cache.remove(key);
        cache.put(key, oldVal);
    }

    public static void main(String[] args) {
        CodingTest035 test = new CodingTest035(2);
        test.put(1, 1);
        test.put(2, 2);
        test.get(1);
        test.put(3, 3);
        test.get(2);
        test.put(4, 4);
        test.get(1);
        test.get(3);
        test.get(4);

       System.out.println(test.cache);

    }
}
