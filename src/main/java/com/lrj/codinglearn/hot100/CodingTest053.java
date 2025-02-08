package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第53题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest053 {

    /**
     * 207.课程表
     * @author: luorenjie
     * @date: 2025/2/7 15:01
     * @param numCourses
     * @param prerequisites
     * @return: boolean
     */
    //设置经过一次递归经历过的节点
    boolean[] onPath;
    //设置遍历过的节点
    boolean[] visited;
    //是否含有环
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //初始化
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        //构建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        //递归遍历图
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int i) {
        //如果该节点已经过，说明有环
        if (onPath[i]){
            hasCycle = true;
        }

        //如果有环或者当前节点已经访问，则直接返回
        if (hasCycle || visited[i]){
            return;
        }

        //刚边遍历的时候，设置该节点访问
        onPath[i] = true;
        visited[i] = true;

        for (Integer integer : graph[i]) {
            traverse(graph, integer);
        }

        //离开则还原
        onPath[i] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            //起始节点
            int from = prerequisite[1];
            //目标节点
            int to = prerequisite[0];

            //将起始节点指向目标节点，构建图
            graph[from].add(to);
        }
        return graph;
    }

    public static void main(String[] args) {
        CodingTest053 test = new CodingTest053();
        System.out.println(test.canFinish(2, new int[][]{{1,0},{0,1}}));
//        System.out.println(test.canFinish(6, new int[][]{{3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}}));
    }

}
