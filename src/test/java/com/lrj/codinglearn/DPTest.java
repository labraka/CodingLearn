package com.lrj.codinglearn;

import java.util.*;

/**
 * @ClassName: DPTest
 * @Description:
 * @Date: 2023/11/9 17:47
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class DPTest {
    public static void main(String[] args) {
        DPTest test = new DPTest();
//        System.out.println(test.fib(4));
//
//        System.out.println(test.coinChange(new int[]{1,2,5}, 11));
//
//
//        System.out.println(test.lengthOfLIS(new int[]{0,1,0,3,2,3}));
//
//        System.out.println(test.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
//
//        System.out.println(test.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println(test.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(test.minDistance("catsandog", "cat"));
        System.out.println(test.canPartition(new int[]{1,2,5}));
        System.out.println(test.change(5, new int[]{1,2,5}));
        System.out.println(test.minPathSum(new int[][]{{1,3,1},{4,5,1},{1,2,1}}));
        System.out.println(test.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
        System.out.println(test.findRotateSteps("ring", "rg"));
        System.out.println(test.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }

    //509.斐波那契数
    public int fib(int n) {
        //解法一：自顶向下
//        int[] memo = new int[n+1];
//        return dp(n, memo);

        //解法二：自底向上
        if (n == 0 || n ==1){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //动态规划
    private int dp(int n, int[] memo) {
        if (n == 0 || n == 1){
            return n;
        }
        //已经计算过，则不需再计算
        if (memo[n] != 0){
            return memo[n];
        }

        memo[n] = dp(n-1, memo) + dp(n-2, memo);
        return memo[n];
    }


    //322.零钱兑换
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        /*
         * 解法一：自顶向下，化解为子问题，时间复杂度为O(nk)
         */
//        //增加备忘录，避免重复计算
//        memo = new int[amount + 1];
//        //给备忘录增加一个不会被取到的特殊值
//        Arrays.fill(memo, 888);
//
//        return dp1(coins, amount);

        /*
         * 解法二：自底向上，消除重叠子问题
         */

        int[] dp = new int[amount+1];
        //初始值amount+1
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        //外层遍历所有情况
        for (int i = 0; i < dp.length; i++) {
            //内层求最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    private int dp1(int[] coins, int amount) {
        if (amount == 0){
            return amount;
        }
        if (amount < 0){
            return -1;
        }

        if (memo[amount] != 888){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //计算子问题结果
            int subProblem = dp1(coins, amount - coin);
            if (subProblem == -1){
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem+1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    //300.最长递增子序列
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        //初始化为1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    //354.俄罗斯套娃信封问题
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        //按照宽高，宽度升序排序，然后高度降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        //对高度找LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }


    //53.最大子子数组和
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return n;
        }

        //定义dp[i]，记录以nums[i]为结尾的最大子数组和
        int[] dp = new int[n];

        //第一个元素没有子数组
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }

        int res = Integer.MIN_VALUE;
        //得到nums的最大子数组
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    //139.单词拆分
    //用hash集合判断单词是否存在
    Set<String> wordDict;
    //备忘录，-1：未计算  0：无法凑出  1：可以凑出
    int[] memo1;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);

        memo1 = new int[s.length()];

        Arrays.fill(memo1, -1);

        return dp2(s, 0);
    }

    private boolean dp2(String s, int i){
        if (i == s.length()){
            return true;
        }

        //备忘录中是否已存在了
        if (memo1[i] != -1){
            return memo1[i] == 1 ? true : false;
        }

        for (int j = 0; i+j <= s.length(); j++) {
            String prefix = s.substring(i, i+j);
            //前缀匹配单词的
            if (wordDict.contains(prefix)){
                //继续查找下一个
                boolean next = dp2(s, i+j);
                if (next){
                    memo1[i] = 1;
                    return true;
                }
            }
        }

        //无法凑出
        memo1[i] = 0;
        return false;
    }

    //140.单词拆分Ⅱ
    //避免重复的词典
    Set<String> wordDict1;
    //备忘录
    List<String>[] memo2;
    public List<String> wordBreak1(String s, List<String> wordDict) {
        this.wordDict1 = new HashSet<>(wordDict);
        memo2 = new List[s.length()];
        return dp3(s, 0);
    }

    private List<String> dp3(String s, int i) {
        List<String> res = new ArrayList<>();
        if (i == s.length()){
            res.add("");
            return res;
        }

        //避免重复计算
        if (memo2[i] != null){
            return memo2[i];
        }

        for (int len = 0; i+len <= s.length(); len++) {

            String prefix = s.substring(i, i+len);

            if (wordDict1.contains(prefix)){

                //找到单词匹配
                List<String> suffix = dp3(s, i + len);

                for (String suf : suffix) {
                    if (suf.isEmpty()){
                        res.add(prefix);
                    }else {
                        res.add(prefix + " " + suf);
                    }
                }
            }
        }

        memo2[i] = res;
        return res;
    }


    //72.编辑距离
    //备忘录，防止重复计算
    int[][] memo3;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo3 = new int[m][n];
        for (int[] row : memo3) {
            //初始化备忘录代表未计算
            Arrays.fill(row, -1);
        }

        return dp4(word1, m-1, word2, n-1);
    }

    private int dp4(String s1, int i, String s2, int j) {
        if (i == -1){
            return j+1;
        }
        if (j == -1){
            return i+1;
        }

        if (memo3[i][j] != -1){
            return memo3[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)){
            memo3[i][j] = dp4(s1, i-1, s2, j-1);
        }else {
            memo3[i][j] = minDes(
                    dp4(s1, i, s2, j-1) + 1,
                    dp4(s1, i-1, s2, j) + 1,
                    dp4(s1, i-1, s2, j-1) + 1
            );
        }

        return memo3[i][j];
    }

    private int minDes(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }



    //416.分割等和子集
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;

        for (int num : nums) {
            sum += num;
        }

        //和为奇数则不满足
        if (sum % 2 != 0){
            return false;
        }

        sum = sum / 2;

//        //解法一：二维数组
//        boolean[][] dp = new boolean[n+1][sum+1];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = true;
//        }
//
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= sum; j++) {
//                if (j - nums[i-1] < 0){
//                    //背包容量不足，不能装下第i个物品
//                    dp[i][j] = dp[i-1][j];
//                }else {
//                    //装入/不转入背包
//                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
//                }
//            }
//        }
//        return dp[n][sum];

        //解法二：一维数组
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[sum];
    }



    //518.零钱兑换
    public int change(int amount, int[] coins) {
        int n = coins.length;

//        //解法一：二维数组
//        int[][] dp = new int[n+1][amount+1];
//
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= amount; j++) {
//                if (j - coins[i-1] >= 0){
//                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
//                }else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//
//        return dp[n][amount];

        //解法二：一维数组
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] >= 0){
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }

        return dp[amount];
    }


    //64.最小路径和
    int[][] memo4;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo4 = new int[m][n];
        for (int[] rows : memo4) {
            Arrays.fill(rows, -1);
        }
        return dp5(grid, m-1, n-1);
    }

    private int dp5(int[][] grid, int i, int j) {
        if (i == 0 && j == 0){
            return grid[0][0];
        }

        if (i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }

        if (memo4[i][j] != -1){
            return memo4[i][j];
        }

        memo4[i][j] = Math.min(
        dp5(grid, i, j-1), dp5(grid, i-1, j)) + grid[i][j];

        return memo4[i][j];
    }


    //174.地下城游戏
    int[][] memo5;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        memo5 = new int[m][n];

        for (int[] row : memo5) {
            Arrays.fill(row, -1);
        }

        return dp6(dungeon, 0, 0);
    }

    private int dp6(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        if (m-i == 1 && n-j == 1){
            return dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
        }

        if (m == i || n == j){
            return Integer.MAX_VALUE;
        }

        if (memo5[i][j] != -1){
            return memo5[i][j];
        }

        int res = Math.min(dp6(dungeon, i, j+1), dp6(dungeon, i+1, j)) - dungeon[i][j];

        memo5[i][j] = res <= 0 ? 1 : res;

        return memo5[i][j];
    }


    //514.自由之路
    Map<Character, List<Integer>> charForIndexMap;
    int[][] memo6;
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        memo6 = new int[m][n];
        charForIndexMap = new HashMap<>();

        //记录圆环上字符的索引映射
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            if (!charForIndexMap.containsKey(c)){
                charForIndexMap.put(c, new ArrayList<>());
            }
            charForIndexMap.get(c).add(i);
        }

        return dp7(ring, 0, key, 0);
    }


    private int dp7(String ring, int i, String key, int j){
        //完成输入
        if (j == key.length()){
            return 0;
        }

        if (memo6[i][j] != 0){
            return memo6[i][j];
        }

        int n = ring.length();

        int res = Integer.MAX_VALUE;

        //遍历key所需字符在ring字符所在的坐标
        char c = key.charAt(j);
        List<Integer> indexList = charForIndexMap.get(c);
        for (Integer index : indexList) {
            //拨动指针的次数
            int delta = Math.abs(index - i);
            //选择顺时针还是逆时针
            delta = Math.min(delta, n - delta);
            //拨动指针ring[index]，key[j+1]
            int subProblem = dp7(ring, index, key, j+1);

            //按按钮需要+1操作
            res = Math.min(res, 1+delta+subProblem);
        }

        memo6[i][j] = res;
        return res;
    }



    //787.K站中专内最便宜的航班
    Map<Integer, List<int[]>> indegree;
    int src,dst;
    int[][] memo7;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.src = src;
        this.dst = dst;
        k++;

        memo7 = new int[n][k+1];
        for (int[] row : memo7) {
            Arrays.fill(row, 888);
        }

        indegree = new HashMap<>();
        for (int[] flight : flights) {
            int to = flight[1];
            int from = flight[0];
            int price = flight[2];
            if (!indegree.containsKey(to)){
                indegree.put(to, new ArrayList<>());
            }
            indegree.get(to).add(new int[]{from, price});
        }

        return dp8(dst, k);
    }


    private int dp8(int s, int k){
        if (s == src){
            return 0;
        }
        
        if (k == 0){
            return -1;
        }

        if (memo7[s][k] != 888){
            return memo7[s][k];
        }
        
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)){
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];

                //划分为子问题
                int subProblem = dp8(from, k-1);

                if (subProblem != -1){
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        memo7[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo7[s][k];
    }
}
