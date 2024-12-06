package com.lrj.codinglearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: QueueTest
 * @Description:
 * @Date: 2023/10/30 14:22
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class QueueTest {

    public static void main(String[] args) {
        QueueTest test = new QueueTest();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = test.maxSlidingWindow(nums, 3);
        System.out.println(res);
    }

    //构建单调队列
    class MonotonicQueue {

        //双链表，支持头部尾部删除元素
        //维护其中的元素自尾部到头部单调递增
        private LinkedList<Integer> maxq = new LinkedList<>();

        //添加元素
        private void push(int n){
            while (!maxq.isEmpty() && maxq.getLast() < n){
                maxq.pollLast();
            }
            maxq.addLast(n);
        }

        //返回当前队列中最大元素
        private int max(){
            return maxq.getFirst();
        }

        //如果当前队列元素是n删除它
        private void pop(int n){
            if (n == maxq.getFirst()){
                maxq.pollFirst();
            }
        }
    }

    //239.滑动窗口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            window.push(nums[i]);
            if (i >= k-1){
                res.add(window.max());
                window.pop(nums[i-k+1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
