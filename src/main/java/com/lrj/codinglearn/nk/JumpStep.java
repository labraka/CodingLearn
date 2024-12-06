package com.lrj.codinglearn.nk;

/**
 * @ClassName: JumpStep
 * @Description:
 * @Date: 2023/4/18 10:04
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class JumpStep {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 数据范围：1≤n≤40
     * 要求：时间复杂度：O(n) ，空间复杂度：O(1)
     * @param args
     */
    public static void main(String[] args) {
        JumpStep jumpStep = new JumpStep();
        System.out.println(jumpStep.m1(7));
        System.out.println(jumpStep.m2(7));
    }

    /**
     * 动态规划 从下往上
     * @author: luorenjie
     * @date: 2023/4/18 15:36
     * @param jump
     * @return: int
     */
    private int m2(int jump) {
        if (jump <= 1){
            return 1;
        }
        int[] dp = new int[jump + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= jump; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[jump];
    }

    /**
     * 青蛙跳台阶问题：f(0)=1,f(1)=1,f(2)=2；
     * 斐波那契数列问题：f(0)=0,f(1)=1,f(2)=1。
     *
     * 递归调用 f(n) = f(n-1) + f(n-2)
     * 大量重复的递归计算
     * @author: luorenjie
     * @date: 2023/4/18 10:12
     * @param jump
     * @return: int
     */
    private int m1(int jump) {
        if (jump <= 1){
            return 1;
        }
        return m1(jump -1) + m1(jump -2);
    }
}
