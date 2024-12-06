package com.lrj.codinglearn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean[] visited;
    private boolean[] onPath;
    private boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }
    //构建图
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new ArrayList[]{};
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
    //DFS遍历框架
    private void traverse(List<Integer>[] graph, int s){
        if (onPath[s]){
            hasCycle = true;
        }
        if (visited[s]){
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for (Integer g : graph[s]) {
            traverse(graph, g);
        }

        onPath[s] = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
