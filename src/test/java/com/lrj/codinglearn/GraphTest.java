package com.lrj.codinglearn;

import java.util.*;

/**
 * @ClassName: GraphTest
 * @Description: 图算法
 * @Date: 2023/6/25 17:24
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class GraphTest {
    public static void main(String[] args) {
        GraphTest test = new GraphTest();

//        int[][] graph = new int[][] {{1,2},{3},{3},{}};
//        int[][] graph = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
//        System.out.println(test.allPathsSourceTarget(graph));

//        int [][] prerequisites = new int[][]{{1, 0}};
//        System.out.println(test.canFinish(2, prerequisites));
//        System.out.println(test.findOrder(2, prerequisites));

//        int[][] graph = new int[][] {{1,3},{0,2},{1,3},{0,2}};
//        int[][] graph = new int[][] {{1,2},{0,2},{0,1}};
//        System.out.println(test.isBipartite(graph));


//        int[][] dislikes = new int[][] {{1,2},{1,3},{2,3}};
//        int[][] dislikes = new int[][] {{1,2},{1,3},{2,4}};
//        System.out.println(test.possibleBipartition(4, dislikes));

        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        test.solve(board);
    }


    List<List<Integer>> resList = new ArrayList<>();
    //797 所有可能得路径
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        traverse(graph, 0, path);
        return resList;
    }

    private void traverse(int[][] graph, int s, List<Integer> path) {
        path.add(s);

        int n = graph.length;
        if (s == n-1){
            resList.add(new ArrayList<>(path));
        }

        for (int i : graph[s]) {
            traverse(graph, i, path);
        }

        path.remove(path.size() - 1);
    }


    /**
     * 207 课程表
     */
    //记录一次 traverse 递归经过的节点
    boolean[] onPath;
    //记录遍历过的节点
    boolean[] visited;
    //记录图中是否有环
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse1(graph, i);
        }

        return !hasCycle;
    }

    /**
     * 构造图
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            //起始节点
            int from = prerequisite[1];
            //指向节点
            int to = prerequisite[0];

            //修完所有的from才修to
            //在图中添加一条从from指向to的有向边
            graph[from].add(to);
        }

        return graph;
    }

    /**
     * 递归遍历图
     * @param graph
     * @param s
     */
    private void traverse1(List<Integer>[] graph, int s){
        //出现环
        if (onPath[s]){
            hasCycle = true;
        }

        //如果找到环则不需要再遍历
        if (visited[s] || hasCycle){
            return;
        }

        //进来的时候将节点置为true
        onPath[s] = true;
        visited[s] = true;

        for (Integer integer : graph[s]) {
            traverse1(graph, integer);
        }

        //出去的时候将节点置为false
        onPath[s] = false;
    }


    /**
     * 210 课程表Ⅱ
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //构造有向图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        //计算入度
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            indegree[to]++;
        }
        
        //根据入度初始化队列中的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        //记录拓扑排序结构
        int[] res = new int[numCourses];
        
        //记录遍历节点的顺序（索引）
        int count = 0;
        
        //执行BFS
        while (!queue.isEmpty()){
            int cur = queue.poll();
            //弹出节点的顺序即为拓扑排序的结果
            res[count] = cur;
            count++;

            for (Integer integer : graph[cur]) {
                indegree[integer]--;
                if (indegree[integer] == 0){
                    queue.offer(integer);
                }
            }
        }

        
        if (count != numCourses){
            //存在环，拓扑排序不存在
            res = new int[]{};
        }
        

        return res;
    }

    //785.判断二分图
    private boolean[] visited1;
    private boolean[] color;
    private boolean ok = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited1 = new boolean[n];
        color = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited1[i]){
                traverse2(graph, i);
            }
        }
        return ok;
    }

    private void traverse2(int[][] graph, int v){
        if (!ok){
            return;
        }
        visited1[v] = true;

        for (int i : graph[v]) {
            if (!visited1[i]){
                color[i] = !color[v];
                traverse2(graph, i);
            }else {
                if (color[v] == color[i]){
                    ok = false;
                    return;
                }
            }
        }
    }


    //886.可能的二分法
    private boolean[] visited2;
    private boolean[] color1;
    private boolean ok1 = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited2 = new boolean[n+1];
        color1 = new boolean[n+1];

        List<Integer>[] graph = buildGraph1(n, dislikes);

        for (int i = 1; i <= n; i++) {
            if (!visited2[i]){
                traverse3(graph, i);
            }
        }
        return ok1;
    }

    private List<Integer>[] buildGraph1(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            int to = dislike[1];
            int from = dislike[0];
            graph[to].add(from);
            graph[from].add(to);
        }
        return graph;
    }

    private void traverse3(List<Integer>[] graph, int v){
        if (!ok1){
            return;
        }
        visited2[v] = true;

        for (int i : graph[v]) {
            if (!visited2[i]){
                color1[i] = !color1[v];
                traverse3(graph, i);
            }else {
                if (color1[v] == color1[i]){
                    ok1 = false;
                    return;
                }
            }
        }
    }




    //130.被围绕的区域
    public void solve(char[][] board) {

        if (board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;

        //给dummy留一个额外位置
        UF uf = new UF(m * n + 1);
        int dummy = m * n;

        //将首列和末列的“O”和dummy连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O'){
                uf.union(i*n, dummy);
            }
            if (board[i][n-1] == 'O'){
                uf.union(i*n+n-1, dummy);
            }
        }

        //将首行和末行的”O“和dummy相连
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O'){
                uf.union(j, dummy);
            }
            if (board[m-1][j] == 'O'){
                uf.union(n*(m-1)+j, dummy);
            }
        }

        //方向组d是上下左右搜索的常用手法
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == 'O'){
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = i + d[k][1];
                        if (board[x][y] == 'O'){
                            uf.union(x*n+y, i*n+y);
                        }
                    }
                }
            }
        }

        //所有不和dummy连通的”O“，都要被替换掉
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!uf.connected(dummy, i*n+j)){
                    board[i][j] = 'X';
                }
            }
        }

        System.out.println(board);
    }

    /*
     * 并查集（Union-Find）
     */
    class UF{

        //记录连通分量
        private int count;
        //节点x的父节点是parent[x]
        private int[] parent;

        //构造函数，n为图的节点总数
        public UF(int n) {
            //一开始互不通连
            this.count = n;
            //父节点指针初始指向自己
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 将节p和q相连
         * @param p
         * @param q
         */
        private void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ){
                return;
            }

            //将两棵树合并为一棵树
            parent[rootP] = rootQ;
            //两个分量合二为一
            count--;
        }

        private int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * 判断p和q是否连通
         * @param p
         * @param q
         * @return
         */
        private boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        /**
         * 返回多少个连通分量
         * @return
         */
        private int count(){
            return count;
        }
    }
}
