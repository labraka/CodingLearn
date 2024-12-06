package com.lrj.codinglearn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * @ClassName: ArraysTest
 * @Description: 数组测试
 * @Date: 2023/5/9 21:09
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class ArraysTest {


    public static void main(String[] args) {
//        int[] arrs = {0,1,0,2,2,0,3};
        int[] arrs = {1,2,7,11,15};
        char[] ss = {'h','e','l','l','o'};
        ArraysTest test = new ArraysTest();
//        int n = test.removeDuplicates(arrs);
//        int n = test.removeElement(arrs, 2);
//        test.moveZeroes(arrs);
//        int[] m = test.twoSum(arrs, 13);
//        test.reverseString(ss);

//        String str = "babad";
//        String s = test.longestPalindrome(str);

//        int[] a = {-2, 0, 3, -5, 2, -1};
//        ArraysTest.NumArray ta = new NumArray(a);
//        System.out.println(ta.sumRange(2, 5));

//        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
//        ArraysTest.NumMatrix tm = new NumMatrix(matrix);
//        System.out.println(tm.sumRegion(2, 1,4,3));


        // [1,3,2],[2,4,3],[0,2,-2]
//        int[][] updates = {{1,3,2}, {2,4,3}, {0,2,-2}};
//        int[] res = test.getModifiedArray(5, updates);

        //trips = [[2,1,5],[3,3,7]], capacity = 4
//        int[][] trips = {{2,1,5}, {3,3,7}};
//        boolean can = test.carPooling(trips, 4);
//        System.out.println(can);

//        int[][] matrix = {{1, 2, 3}, {4, 5, 6, }, {7, 8, 9}};
//        test.rotate(matrix);


//        String s = "a good    example";
//        String res = test.reverseWords(s);
//        System.out.println(res);

//        int[][] matrix = {{1, 2, 3 ,4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        List<Integer> l = test.spiralOrder(matrix);
//        System.out.println(l);

//        System.out.println(test.generateMatrix(3));


//        String s = "a";
//        String t = "aa";
//        System.out.println(test.minWindow(s, t));

//        String s = "ab";
//        String t = "eidboaoo";
//        System.out.println(test.checkInclusion(s, t));

//        String s = "cbaebabacd";
//        String p = "abc";
//        System.out.println(test.findAnagrams(s, p));


//        System.out.println(test.lengthOfLongestSubstring("abcabcbbdefgh"));

//        System.out.println(test.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

//        int[] nums = {-1,0,3,5,9,12};
//        System.out.println(test.search(nums, 9));

//        int[] nums = {5,7,7,8,8,10};
//        System.out.println(test.searchRange(nums, 9));

//        int[] nums = {1,3};
//        Solution solution = new Solution(nums);
//        System.out.println(solution.pickIndex());

//        int[] nums = {3,2,2,4,1,4};
//        System.out.println(test.shipWithinDays(nums, 3));

//        int[] nums = {3,6,7,11};
//        System.out.println(test.minEatingSpeed(nums, 8));

//        int[] nums = {1,2,3,4,5};
//        System.out.println(test.splitArray(nums, 2));

//        int[] nums1 = {12,24,8,32};
//        int[] nums2 = {13,25,32,11};
//        System.out.println(test.advantageCount(nums1, nums2));


//        RandomizedSet randomizedSet = new RandomizedSet();
//        randomizedSet.insert(1);
//        randomizedSet.remove(2);
//        randomizedSet.insert(2);
//        randomizedSet.getRandom();
//        randomizedSet.remove(1);
//        randomizedSet.insert(2);
//        randomizedSet.getRandom();


//        int[] nums = {0, 2, 3, 5, 6};
//        Black black = new Black(7, nums);
//        System.out.println(black.pick());

        System.out.println(test.removeDuplicateLetters("cbacdcbc"));

    }

    //------------------------------------快慢指针------------------------------------

    //26 删除有序数组中的重复项(快慢指针)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if (nums[slow] != nums[fast]){
                slow ++;
                nums[slow] = nums[fast];
            }
            fast ++;
        }
        return slow + 1;
    }

    //27 移除元素(快慢指针)
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }

        return slow + 1;
    }

    //283 移动零(快慢指针)
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1){
            return;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow ++;
            }
            fast ++;
        }
        System.out.println(slow);
    }




    //------------------------------------左右指针------------------------------------


    //167 两数之和 II
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0 || numbers.length == 1){
            return new int[]{-1, -1};
        }
        int left = 0, right = numbers.length - 1;
        while (left < right){
            int res = numbers[left] + numbers[right];
            if (res == target){
                return new int[]{left + 1, right + 1};
            }else if (res < target){
                left ++;
            }else {
                right --;
            }
        }
        return new int[]{-1, -1};
    }

    //344 反转字符
    public void reverseString(char[] s) {
        if (s.length == 0 || s.length == 1){
            return;
        }

        int left = 0, right = s.length - 1;
        while (left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        System.out.println(s);
    }


    //5 最长回文子串
    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() <= 1){
            return s;
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res;
    }

    private String palindrome(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


    //------------------------------------前缀和数组------------------------------------

    //303 区域和检索 - 数组不可变
    static  class NumArray{
        int[] preSum;
        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = nums[i - 1] + preSum[i - 1];
            }
            System.out.println(preSum);
        }

        private int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }


    //304 二维区域和检索 - 矩阵不可变
    static class NumMatrix {

        int[][] preSum;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            if (m == 0 || n == 0){
                return;
            }
            /*
                              0  1  2  3  4
               matrix=    0 [ 3, 0, 1, 4, 2 ]
                          1 [ 5, 6, 3, 2, 1 ]
                          2 [ 1, 2, 0, 1, 5 ]
                          3 [ 4, 1, 0, 1, 7 ]
                          4 [ 1, 0, 3, 0, 5 ]

            preSum=      [ 0, 0, 0, 0, 0, 0 ]
                         [ 0, 3, 3, 4, 8,10 ]
                         [ 0, 8,14,18,24,27 ]
                         [ 0, 9,17,21,28,36 ]
                         [ 0,13,22,26,34,49 ]
                         [ 0,14,23,30,38,58 ]



             */

            preSum = new int[m+1][n+1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    preSum[i+1][j+1] = preSum[i][j+1] + preSum[i+1][j] + matrix[i][j] - preSum[i][j];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1];
        }
    }


    //------------------------------------差分数组------------------------------------



    /**
     * @Description 构建差分数组工具类
     * @author: luorenjie
     * @date: 2023/5/15 17:41
     * @return: null
     */
    static class Difference{

        //构建全局差分数组
        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            //给差分数组添加元素
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i-1];
            }
        }

        //区间递增
        private void increase(int i, int j, int val){
            diff[i] += val;
            if (j+1 < diff.length){
                diff[j+1] -= val;
            }
        }

        //返回结果
        private int[] result(){
            int res[] = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }


    /**
     * 370 区间加法
     *
     * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
     * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
     * 请你返回 k 次操作后的数组。
     *
     * 示例:
     * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
     * 输出: [-2,0,3,5,3]
     *
     * 解释:
     * 初始状态:
     * [0,0,0,0,0]
     * 进行了操作 [1,3,2] 后的状态:
     * [0,2,2,2,0]
     * 进行了操作 [2,4,3] 后的状态:
     * [0,2,5,5,3]
     * 进行了操作 [0,2,-2] 后的状态:
     * [-2,0,3,5,3]
     *
     *
     */
    int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference difference = new Difference(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            difference.increase(i, j, val);
        }
        return difference.result();
    }

    //1109 航班统计
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            difference.increase(i, j ,val);
        }
        return difference.result();
    }


    //1094 拼车
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference difference = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;
            difference.increase(i, j, val);
        }
        int[] res = difference.result();
        for (int re : res) {
            if (re > capacity){
                return false;
            }
        }
        return true;
    }

    //------------------------------------二维数组花式遍历------------------------------------

    //48 旋转图像
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0){
            return;
        }

        //对角线旋转
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int[] ma : matrix) {
            int x = 0, y = ma.length-1;
            while (x < y){
                int tmp = ma[x];
                ma[x] = ma[y];
                ma[y] = tmp;
                x++;
                y--;
            }
        }
        System.out.println(matrix);
    }



    //151 反转字符串中的单词
    public String reverseWords(String s) {
        if (s.length() == 0){
            return null;
        }

        //清洗数据
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        int n = 0;
        for (String s1 : ss) {
            if (!s1.equals("") && !s1.equals(" ")){
                sb.append(s1);
                if (n < ss.length - 1){
                    sb.append(" ");
                }
            }
            n++;
        }

        //交换单词
        String s1 = sb.toString();
        String[] s2 = s1.split(" ");
        int m = 0, z = s2.length - 1;
        while (m < z){
            String tmp = s2[m];
            s2[m] = s2[z];
            s2[z] = tmp;
            m++;
            z--;
        }

        //单词后增加空格
        sb = new StringBuilder();
        int w = 0;
        for (String s3 : s2) {
            sb.append(s3);
            if (w < s2.length - 1){
                sb.append(" ");
            }
            w++;
        }
        return sb.toString();
    }


    //54 螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0){
            return null;
        }

        /*
          利用边界收缩法：确定 上->右->下->左 四个边界，进行顺时针收缩
                         0   —— —— —— >  n-1
                            ^         |
                            |         |
                            |         |
                            |         v
                            < —— —— ——   m-1
         */
        int up = 0, down = m - 1;
        int left = 0, right = n-1;

        List<Integer> resList = new ArrayList<>();
        while (resList.size() < m * n){
            if (up <= down){
                //顶部，从左到右遍历
                for (int i = left; i <= right; i++) {
                    resList.add(matrix[up][i]);
                }
                //向下移动
                up++;
            }

            if (left <= right){
                //右侧，从上向下遍历
                for (int i = up; i <= down; i++) {
                    resList.add(matrix[i][right]);
                }
                //向左移动
                right--;
            }

            if (up <= down){
                //底部，从右向左遍历
                for (int i = right; i >= left ; i--) {
                    resList.add(matrix[down][i]);
                }
                //向上移动
                down--;
            }

            if (left <= right){
                //左侧，从下向上遍历
                for (int i = down; i >= up; i--) {
                    resList.add(matrix[i][left]);
                }
                //向右移动
                left++;
            }
        }
        return resList;
    }

    //59 螺旋矩阵 II
    public int[][] generateMatrix(int n) {
        if (n == 0){
            return null;
        }

        //创建矩阵
        int[][] matrix = new int[n][n];

        //设置上、右、下、左边界
        int up = 0, right = n - 1;
        int left = 0, down = n - 1;

        //初始元素
        int num = 1;
        while (num <= n*n){

            //上边界：下移，从左向右添加元素
            if (up <= down){
                for (int i = left; i <= right; i++) {
                    matrix[up][i] = num++;
                }
                up++;
            }

            //右边界：左移，从上向下添加元素
            if (left <= right){
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }

            //下边界：上移，从右向左添加元素
            if (up <= down){
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = num++;
                }
                down--;
            }

            //左边界：右移，从下向上添加元素
            if (left <= right){
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }

    //------------------------------------滑动窗口------------------------------------


    //76 最小覆盖子串
    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //统计t字符以及出现的次数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //设置窗口
        int left = 0, right = 0;

        //设置出现的次数
        int valid = 0;

        //设置起始索引和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()){

            //需要进入窗口的字符
            char c = s.charAt(right);

            //扩大窗口
            right++;

            //窗口内的一系列处理
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            //是否需要收缩窗口
            while (valid == need.size()){
                if (right - left < len){
                    start = left;
                    len = right - left;
                }

                //需要从窗口删除的字符
                char d = s.charAt(left);

                //缩小窗口
                left++;

                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE  ? "" : s.substring(start, start + len);
    }


    //567 字符串的排列
    public boolean checkInclusion(String s1, String s2) {
        //设置hash记录字符以及出现的次数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //字符记录
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //设置窗口指针
        int left = 0, right = 0;

        //设置出现的次数
        int valid = 0;


        while (right < s2.length()){

            //需要进入窗口的字符串
            char c = s2.charAt(right);

            //扩大窗口
            right++;

            //处理窗口里面的字符串
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            //是否找到合法子串
            if (valid == need.size()){
                return true;
            }

            while (right - left >= s1.length()){

                //移除窗口的字符
                char d = s2.charAt(left);

                //缩小窗口
                left++;

                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }

                    window.put(d, window.get(d)- 1);
                }

            }

        }
        return false;
    }


    //438 找到字符串中所有字母异位词
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //目标将字符串放入hash表
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //窗口的左右指针
        int left = 0, right = 0;

        //字符出现的次数
        int valid = 0;

        //存放下标的数组
        Set<Integer> res = new HashSet<>();

        while (right < s.length()){

            //当前进入窗口的值
            char c = s.charAt(right);

            //扩大窗口
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            //判断是否需要收缩窗口
            while (right - left >= p.length()){

                //是否找到字串
                if (valid == need.size()){
                    res.add(left);
                }

                //需要移出窗口的字符
                char d = s.charAt(left);

                //缩小窗口
                left++;

                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }

                    window.put(d, window.get(d) - 1);
                }

            }
        }
        return new ArrayList<>(res);
    }



    //3 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        //设置窗口hash缓存
        Map<Character, Integer> window = new HashMap<>();

        //设置窗口左右指针
        int left = 0, right = 0;

        //设置统计次数
        int sum = 0;

        while (right < s.length()){
            //进入窗口的字符
            char c = s.charAt(right);

            //扩大窗口
            right++;

            //将字符和次数缓存到hash表中
            window.put(c, window.getOrDefault(c, 0) + 1);

            //是否出现重复的需要缩小窗口
            while (window.get(c) > 1){
                //需要删除的字符
                char d = s.charAt(left);

                //缩小窗口
                left++;

                window.put(d, window.get(d) - 1);
            }
            sum = Math.max(sum, right - left);
        }

        return sum;
    }


    //187 重复的DNA序列
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        List<Character> window = new ArrayList<>();

        int left = 0, right = 0;

        int len = 10;

        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            window.add(c);

            while (right - left == len){
                String s1 = window.toString();
                if (set.contains(s1)){
                    String s2 = s1.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", "");
                    res.add(s2);
                }else {
                    set.add(s1);
                }

                //移除字符
                window.remove(0);
                left++;
            }
        }

        return new ArrayList<>(res);
    }


    //------------------------------------二分查找------------------------------------

    //704 二分查找
    public int search(int[] nums, int target) {
        //设置左右下标
        int left = 0, right = nums.length - 1;

        while (left <= right){
            //中间下标
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }


    //34 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];

        //第一个位置即最左侧开始下标
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }

        if (left >= nums.length || nums[left] != target){
            res[0] = -1;
        }else {
            res[0] = left;
        }


        left = 0;
        right = nums.length - 1;
        //第最后一个位置即最右侧结束下标
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                left = mid + 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target){
            res[1] = -1;
        }else {
            res[1] = right;
        }

        return res;
    }


    //528 按权重随机选择
    static class Solution{
        int[] preNums;
        public Solution(int[] w) {
            preNums = new int[w.length + 1];
            for (int i = 1; i <= w.length; i++) {
                preNums[i] = preNums[i-1] + w[i-1];
            }
        }

        public int pickIndex() {
            int n = preNums.length;
            Random random = new Random();
            //生成随机数
            int target = random.nextInt(preNums[n-1]) + 1;

            return binarySearch(preNums, target) - 1;
        }

        //二分搜索
        private int binarySearch(int[] preNums, int target) {
            int left = 0, right = preNums.length - 1;

            //左固定，右收缩，返回左
            while (left <= right){
                int mid = left + (right - left) / 2;

                if (preNums[mid] == target){
                    right = mid - 1;
                }else if (preNums[mid] < target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

            //右固定，左收缩，返回右
//            while (left <= right){
//                int mid = left + (right - left) / 2;
//                if (preNums[mid] == target){
//                    left = mid + 1;
//                } else if (preNums[mid] < target) {
//                    left = mid + 1;
//                }else {
//                    right = mid - 1;
//                }
//            }

            if (left >= preNums.length){
                return -1;
            }

            return left;
        }

    }

    //1011 在 D 天内送达包裹的能力
    public int shipWithinDays(int[] weights, int days) {
        /*
         * 二分查找
         * 首先这艘船的重量是固定的, 货物的运输顺序必须按照数组weights的顺序来,
         * 不能打乱顺序. 那么我们可以想到这艘船最小的运载能力必须是所有货物中最重的
         * 那一件max(weights), 否则无法完成运输的任务. 这艘船最大的运载能力就是一
         * 次性把所有的货都搬走, 就是sum(weights). 所以答案就在区间[max(weights),
         * sum(weights)]之间!
         */

        //初始左右边界
        int left = 0, right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right){
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 根据二分的载重，获取能运完这批货的天数
     * @param weights
     * @param mid
     * @return
     */
    private int f(int[] weights, int mid){
        //运载货物的天数
        int days = 1;
        //当前这一天运载货物的载重之和
        int sum = 0;
        for (int weight : weights) {
            //累计的载重如果超出给定的载重，则需要增加一天，当前这一天运送包裹载重之和需要清零
            if (sum + weight > mid){
                days++;
                sum = 0;
            }
            sum += weight;
        }

        return days;
    }


    //875 爱吃香蕉的珂珂
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if (getHours(piles, mid) <= h){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getHours(int[] piles, int mid){
        int hours = 0;
        for (int pile : piles) {
            hours += pile / mid;
            if (pile % mid > 0){
                hours++;
            }
        }
        return hours;
    }


    //410 分割数组的最大值
    public int splitArray(int[] nums, int k) {
        //找到最大的
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right){
            int mid = left + (right - left) / 2;

            if (getSplit(nums, mid) <= k){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getSplit(int[] nums, int mid) {
        int split = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > mid){
                split++;
                sum = 0;
            }
            sum += num;
        }
        return split;
    }



    //870 优势洗牌
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //对集合1升序排序
        Arrays.sort(nums1);

        //采用优先级队列对集合2降序排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] n1, int[] n2)->{
            return n2[1] - n1[1];
        });

        //将元素添加到队列中
        for (int i = 0; i < nums2.length; i++) {
            pq.add(new int[]{i, nums2[i]});
        }

        //设置左右指针
        int left = 0, right = nums2.length - 1;

        //返回结果集
        int[] res = new int[nums2.length];

        while (!pq.isEmpty()){
            int[] pair = pq.poll();
            int i = pair[0];
            int val = pair[1];
            if (nums1[right] > val){
                res[i] = nums1[right];
                right--;
            }else {
                res[i] = nums1[left];
                left++;
            }
        }

        return res;
    }



    //380 O(1) 时间插入、删除和获取随机元素
   static class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> nums;
        public RandomizedSet() {
            map = new HashMap<>();
            nums = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            nums.add(val);
            map.put(val, nums.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)){
                return false;
            }
            //获取删除元素的下标
            int index = map.get(val);

            //将删除元素的下标设置给最后一个元素
            map.put(nums.get(nums.size() - 1), index);

            //将删除的元素和最后一个元素交换
            Collections.swap(nums, index, nums.size() - 1);

            //删除最后一个元素
           nums.remove(nums.size() - 1);

           //删除缓存
            map.remove(val);

            return true;
        }

        public int getRandom() {
            return nums.get((int)(Math.random() * nums.size()));
        }
    }

    //710 黑名单中的随机数
    static class Black {
        Random random;
        Map<Integer, Integer> map;
        int whiteLen;

        public Black(int n, int[] blacklist) {
            random = new Random();
            map = new HashMap<>();
            int blackLen = blacklist.length;
            whiteLen = n - blackLen;

            for (int b : blacklist) {
                map.put(b,888);
            }

            int last = n - 1;
            for (int b : blacklist) {
               if (b >= whiteLen){
                   continue;
               }

               while (map.containsKey(last)){
                   last--;
               }
               map.put(b, last);
               last--;
            }
        }

        public int pick() {
            int i = random.nextInt(whiteLen);
            return map.getOrDefault(i, i);
        }
    }



    //316 去除重复字母
    public String removeDuplicateLetters(String s) {
        //利用单调栈
        Stack<Character> stack = new Stack();

        //小写字母(a-z)的ascll码(97-122)

        //出现过的字符进行字符统计
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        //重复的字符进行记录
        boolean[] b = new boolean[256];

        //最后的结果
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            count[c]--;
            if (b[c]){
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c){
                if (count[stack.peek()] == 0){
                    break;
                }
                b[stack.pop()] = false;
            }
            stack.push(c);
            b[c] = true;
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

}
