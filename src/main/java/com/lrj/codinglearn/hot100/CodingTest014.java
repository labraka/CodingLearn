package com.lrj.codinglearn.hot100;

import java.util.*;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第14题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest014 {

    /**
     * 56.合并区间
     *
     * @param intervals
     * @author: luorenjie
     * @date: 2024/9/12 9:48
     * @return: int[][]
     */
    public int[][] merge(int[][] intervals) {
        //先给数组升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //添加头节点
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            //拿到当前数组
            int[] cur = intervals[i];

            //获取结果集最后一个元素
            int last = res.get(res.size() - 1)[1];

            //比较当前节点的第一个元素是否被结果集上一个元素包含
            if (last >= cur[0]){
                //比较两个区间的尾节点，取最大的
                res.get(res.size() - 1)[1] = Math.max(last, cur[1]);
            }else {
                //不包含则添加至结果集合
                res.add(cur);
            }
        }

        return res.toArray(new int[][]{});

    }

    public static void main(String[] args) {
        CodingTest014 test = new CodingTest014();
        int[][] a1 = new int[][]{{1, 4}, {4, 5}, {8, 10}, {15, 18}};
        int[][] a2 = new int[][]{{1, 4}, {4, 5}};
        int[][] a3 = new int[][]{{1, 4}, {2, 3}};
        System.out.println(test.merge(a1));
        System.out.println(test.merge(a2));
        System.out.println(test.merge(a3));
    }
}
