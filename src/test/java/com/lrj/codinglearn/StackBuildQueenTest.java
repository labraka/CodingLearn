package com.lrj.codinglearn;

import java.util.Stack;

/**
 * @ClassName: StackBuildQueenTest
 * @Description:
 * @Date: 2023/11/2 16:03
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class StackBuildQueenTest {
    public static void main(String[] args) {
        StackBuildQueenTest test = new StackBuildQueenTest();
        MyQueue myQueue = test.new MyQueue(); myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
    //232.用栈实现队列
    class MyQueue {

        private Stack<Integer> s1,s2;
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            peek();
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }
}
