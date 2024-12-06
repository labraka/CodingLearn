package com.lrj.codinglearn;

import java.util.*;

/**
 * @ClassName: ClassicTest
 * @Description:
 * @Date: 2024/3/6 12:11
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class ClassicTest {
    public static void main(String[] args) {
        ClassicTest test = new ClassicTest();

        System.out.println(test.isUgly(14));
        System.out.println(test.nthUglyNumber(9));
        System.out.println(test.nthSuperUglyNumber(1, new int[]{2,3,5}));
        System.out.println(test.nthUglyNumber(1000000000, 2, 217983653, 336916467));
        System.out.println(test.diffWaysToCompute("2*3-4*5"));
        System.out.println(test.isPossible(new int[] {1,2,3,4,4,5}));
        System.out.println(test.pancakeSort(new int[] {3,2,4,1}));
        System.out.println(test.multiply("123", "456"));
        System.out.println(test.calculate(" 2-1 + 2 "));
        System.out.println(test.calculateⅡ(" 2-1 + 2 "));
        System.out.println(test.trap(new int[] {4,2,0,3,2,5}));
        System.out.println(test.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(test.isValid("()([]{})"));
        System.out.println(test.minAddToMakeValid("(()("));
        System.out.println(test.minInsertions("()))"));
        System.out.println(test.isRectangleCover(new int[][]{{1,1,3,3}, {3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}));
    }


    //263.丑数
    public boolean isUgly(int n) {
        if (n <= 0){
            return false;
        }

        while (n % 2 == 0){
            n /= 2;
        }

        while (n % 3 == 0){
            n /= 3;
        }

        while (n % 5 == 0){
            n /= 5;
        }

        return n == 1;
    }


    //264.丑数Ⅱ
    public int nthUglyNumber(int n) {
        //初始3个有序链表的头节点指针
        int p2 = 1, p3 = 1, p5 = 1;
        //结果数组
        int[] ugly = new int[n + 1];

        //初始三个有序链表头节点值
        int product2 = 1, product3 = 1, product5 = 1;

        //初始指针
        int p = 1;
        while (p <= n){
            //找到三个链表最小值
            int min = Math.min(Math.min(product2, product3), product5);
            ugly[p] = min;
            if (min == product2){
                product2 = 2 * ugly[p2];
                p2++;
            }

            if (min == product3){
                product3 = 3 * ugly[p3];
                p3++;
            }

            if (min == product5){
                product5 = 5 * ugly[p5];
                p5++;
            }

            p++;
        }

        return ugly[n];
    }


    //313.超级丑数
    public int nthSuperUglyNumber(int n, int[] primes) {
        //使用优先级队列装三元数组 int[]{product, prime, p}
        //product：链表节点的值；prime：下个节点所需的质数因子；p：代表链表上的指针
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            return a[0] - b[0];
        });

        //将链表的头节点加入优先级队列
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new int[]{1, primes[i], 1});
        }

        //最终结果链表
        int[] ugly = new int[n + 1];
        //最终结果链表上的指针
        int p = 1;

        while (p <= n){
            //取三个链表的最小节点
            int[] pair = pq.poll();
            int product = pair[0];
            int prime = pair[1];
            int p1 = pair[2];

            //避免结果链表出现重复元素
            if (product != ugly[p - 1]){
                //接到结果链表上
                ugly[p] = product;
                p++;
            }

            //生成下一个节点加入优先级队列
            int[] nextPair = new int[]{ugly[p1] * prime, prime, p1 + 1};
            pq.offer(nextPair);
        }

        return ugly[n];
    }

/*
超时！！！！！！！！！！

    //1201.丑数Ⅲ
    public int nthUglyNumber(int n, int a, int b, int c) {
        //三个链表有序乘积后的合并
        long productA = a, productB = b, productC = c;

        //第n个元素的值
        long min = -888;
        //链表的指针
        int p = 1;

        while (p <= n){
            min = Math.min(productA, Math.min(productB, productC));

            //前进链表
            if (min == productA){
                productA += a;
            }
            if (min == productB){
                productB += b;
            }
            if (min == productC){
                productC += c;
            }
            p++;
        }

        return (int) min;
    }
*/


    //1201.丑数Ⅲ
    public int nthUglyNumber(int n, int a, int b, int c) {
        if (a == 1 || b == 1 || c == 1) return n;

        // 两两组合的最小公倍数
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        // 三个数的最小公倍数
        long lcmABC = lcm(lcmAB, c);



        long left = Math.min(a,Math.min(b,c)), right = Math.min(2000000000,left*n);
        //采用二分查找法
        while (left <= right){
            //拿到中间值
            long mid = left + (right - left) / 2;
            // 计算 [1..mid] 之间有多少个能够被 a 或 b 或 c 整除的数字
            // 集合论定理：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C
            long sum = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcmABC;
            if (sum < n){
                // [1~mid] 中符合条件的元素个数<n，所以目标在右半边
                left = mid + 1;
            }else {
                // [1~mid] 中符合条件的元素个数>=n，所以目标在左半边
                right = mid - 1;
            }
        }

        System.out.println(left + "..." + right);
        return (int) left;
    }


    //最小公倍数
    private long lcm(long a, long b){
        return a * b / gcd(a, b);
    }

    //最大公因数
    private long gcd(long a, long b){
        if (a == 0){
            return b;
        }
        return gcd(b % a, a);
    }



    //241.为运算表达式设计优先级
    // 备忘录
    Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        if (memo.containsKey(expression)){
            return memo.get(expression);
        }
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            //扫描运算符，进行分治
            if (c == '+' || c == '-' || c == '*'){
                /**  分 **/
                //以运算符为中心，将字符分为左右两个字符串，分别递归计算
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                /**  治 **/
                //通过子问题结果合成原问题结果
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+'){
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        }else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        // base case，如果res为空，则证明该输入是一个数字
        if (res.isEmpty()){
            res.add(Integer.valueOf(expression));
        }

        memo.put(expression, res);
        return res;
    }

    //659.分割数组为连续子序列
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        //统计nums中元素的频率
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            //数字已被用完
            if (freq.get(num) == 0){
                continue;
            }

            if (need.containsKey(num) && need.get(num) > 0){
                //num可以接到之前某个序列后面
                need.put(num, need.get(num) - 1);
                freq.put(num, freq.get(num) - 1);
                //对于num+1的需求+1
                need.put(num, need.getOrDefault(num + 1, 0) + 1);
            }else if (freq.containsKey(num) && freq.containsKey(num + 1) && freq.containsKey(num + 2)
                    && freq.get(num) > 0 && freq.get(num + 1) > 0 && freq.get(num + 2) > 0){
                freq.put(num, freq.getOrDefault(num, 0) - 1);
                freq.put(num + 1, freq.getOrDefault(num + 1, 0) - 1);
                freq.put(num + 2, freq.getOrDefault(num + 2, 0) - 1);
                //对num+3的需求+1
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            }else {
                return false;
            }
        }
        return true;
    }

    //969.煎饼排序
    LinkedList<Integer> res1 = new LinkedList<>();
    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res1;
    }

    //递归排序
    private void sort(int[] arr, int n){
        //base case 说明已经遍历完了
        if (n == 1){
            return;
        }
        //最大值和最大数组下标
        int max = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }

        if(maxIndex != n - 1){
            //第一次翻转，大饼放前面
            reverse(arr, 0, maxIndex);
            res1.add(maxIndex + 1);

            //第二次翻转，大饼放最后
            reverse(arr, 0, n - 1);
            res1.add(n);
        }

        //递归调用
        sort(arr, n - 1);
    }

    private void reverse(int[] arr, int i, int j){
        while (i < j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    //43.字符串相乘
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        //最终结果
        int[] res2 = new int[m+n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //数组位乘积
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //对应结果位指针位置
                int p1 = i + j, p2 = i + j + 1;
                //叠加到res上
                int sum = mult + res2[p2];
                res2[p2] = sum % 10;
                res2[p1] += sum / 10;
            }
        }

        //排除首位0
        int i = 0;
        while (i < res2.length && res2[i] == 0){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (; i < res2.length; i++) {
            sb.append(res2[i]);
        }

        return sb.toString();

    }


    //224.基本计算器
    public int calculate(String s) {
        Deque<Character> deque = new LinkedList<>();
        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i));
        }

        return opsDeque(deque);
    }

    private int opsDeque(Deque<Character> deque){

        //将数字入栈
        Stack<Integer> stack = new Stack<>();

        //符号，首位赋值+
        char sign = '+';
        int num = 0;

        while (!deque.isEmpty()){
            char c = deque.pop();

            //判断当前是否数字
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            //遇到左括号递归
            if (c == '('){
                num = opsDeque(deque);
            }

            //如果不是数字，或者是最后一位
            if (!Character.isDigit(c) || deque.isEmpty()){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                //符号赋值
                sign = c;
                num = 0;
            }

            //遇到右括号，则返回结果
            if (c == ')'){
                break;
            }
        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    //227.基本计算器Ⅱ
    public int calculateⅡ(String s) {
        Deque<Character> deque = new LinkedList<>();
        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i));
        }
        return  opsDeque1(deque);
    }

    private int opsDeque1(Deque<Character> deque) {
        //数字入库结果栈
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        while (!deque.isEmpty()){
            char c = deque.pop();
            //判断是否为'('，如果是则递归
            if (c == '('){
                num = opsDeque1(deque);
            }

            //判断是否为数字
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            //如果是符号，则进行入库和计算
            if (!Character.isDigit(c) || deque.isEmpty()){
                if (sign == '+'){
                    stack.push(num);
                } else if (sign == '-'){
                    stack.push(-num);
                } else if (sign == '*'){
                    stack.push(stack.pop() * num);
                } else{
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }

            if (c == ')'){
                break;
            }
        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }

        return res;
    }

    //42.接雨水
    public int trap(int[] height) {
        int n = height.length;

        //左右指针
        int left = 0, right = n-1;

        //左右最大值
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax){
                res += leftMax - height[left];
                left++;
            }else {
                res += rightMax - height[right];
                right--;
            }
        }

        return  res;
    }

    //11.盛最多水的容器
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int res = 0;

        while (left < right){
            int curArea = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, curArea);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }

        return res;
    }


    //20.有效的括号
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if (!stack.isEmpty() && find(c) == stack.peek()){
                stack.pop();
            }else {
                return false;
            }
        }

        if (stack.isEmpty()){
            return true;
        }

        return false;
    }

    private char find(char c){
        if (c == ')'){
            return '(';
        } else if (c == '}') {
            return '{';
        }else {
            return '[';
        }
    }


    //921.使括号有效的最少添加
    public int minAddToMakeValid(String s) {
        //添加的次数，需要右括号的数量
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //如果是左括号，则需要一个右括号
            if (c == '('){
                need++;
            }

            //如果已经是右括号，则不需要右括号了
            if (c == ')'){
                need--;
            }

            //说明当前需要左括号
            if (need == -1){
                need = 0;
                //增加一个左括号
                res++;
            }
        }

        return res+need;
    }


    //1541.平衡括号字符串的最少插入次数
    public int minInsertions(String s) {
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '('){
                need += 2;
                if (need % 2 == 1){
                    res++;
                    need--;
                }
            }
            if (c == ')'){
                need --;
                if (need == -1){
                    res++;
                    need = 1;
                }
            }
        }

        return res + need;
    }


    //391.完美矩形
    public boolean isRectangleCover(int[][] rectangles) {
        //找到顶点坐标
        int X1 = Integer.MAX_VALUE, X2 = Integer.MIN_VALUE, Y1 = Integer.MAX_VALUE, Y2 = Integer.MIN_VALUE;
        int sumArea = 0;
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            X1 = Math.min(X1, x1);
            Y1 = Math.min(Y1, y1);
            X2 = Math.max(X2, x2);
            Y2 = Math.max(Y2, y2);
            sumArea = sumArea + (x2 - x1) * (y2 - y1);
        }

        int area = (X2 - X1) * (Y2 - Y1);


        return area == sumArea;
    }
}
