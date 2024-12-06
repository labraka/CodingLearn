package com.lrj.codinglearn;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {

    private boolean[] visited;
    private boolean[] onPath;
    private boolean hasCycle = false;
    private List<Integer> resList;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        resList = new ArrayList<>();
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCycle){
            return new int[]{};
        }

        Collections.reverse(resList);

        int[] res = new int[numCourses];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }


    //构件图
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }

    //迭代遍历
    private void traverse(List<Integer>[] graph, int s){
        if (onPath[s]){
            hasCycle = true;
        }
        if (visited[s] || hasCycle){
            return;
        }
        visited[s] = true;
        onPath[s] = true;

        for (Integer g : graph[s]) {
            traverse(graph, g);
        }

        resList.add(s);

        onPath[s] = false;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] arr = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(arr.length);
        int[] res = solution1.findOrder(4, arr);
        System.out.println(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
