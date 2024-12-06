package com.lrj.codinglearn.hot100;

import java.util.*;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第11题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest011 {

    /**
     * 239.滑动窗口最大值
     * @author: luorenjie
     * @date: 2024/9/9 16:04
     * @param nums
     * @param k
     * @return: int[]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //使用大顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
            if (i >= k - 1){
                res[idx++] = queue.peek()[1];
                //若堆顶元素的下标小于当前滑动窗口左端点时，则丢弃该元素
                while (queue.peek()[0] <= i - k){
                    queue.poll();
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        CodingTest011 test = new CodingTest011();
        System.out.println(test.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }
}
