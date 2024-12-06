package com.lrj.codinglearn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: QueueBuildStackTest
 * @Description:
 * @Date: 2023/11/2 16:52
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class QueueBuildStackTest {
    public static void main(String[] args) {
        QueueBuildStackTest test = new QueueBuildStackTest();
        MyStack myStack = test.new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False
    }

    class MyStack {
        private Queue<Integer> q;
        //栈顶元素
        private int topElem;
        public MyStack() {
            q = new LinkedList();
        }

        public void push(int x) {
            q.offer(x);
            topElem = x;
        }

        public int pop() {
            int size = q.size();
            //留两个队尾元素
            while (size > 2){
                q.offer(q.poll());
                size--;
            }

            //队列头部元素
            topElem = q.peek();
            q.offer(q.poll());
            return q.poll();
        }

        public int top() {
            return topElem;
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
