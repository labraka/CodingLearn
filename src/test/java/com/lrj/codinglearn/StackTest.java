package com.lrj.codinglearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: StackTest
 * @Description:
 * @Date: 2023/10/19 16:31
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class StackTest {
    public static void main(String[] args) {
        StackTest test = new StackTest();
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};
//        int[] r = test.nextGreaterElement(nums1, nums2);
//        System.out.println(r);
        int[] nums = {1,3,4,2,3};
        int[] res = test.nextGreaterElements(nums);
        System.out.println(res);
    }

    //496.下一个更大元素
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);

        Map<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    private int[] nextGreaterElement(int[] nums){
        int n = nums.length;

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    //503.下一个更大元素Ⅱ
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 2*n-1; i > 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }

            res[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
