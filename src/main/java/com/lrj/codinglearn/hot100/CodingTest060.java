package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第60题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest060 {

  
    /**
     * 79.单词搜索
     * @author: luorenjie
     * @date: 2025/2/14 11:41 
     * @param board
     * @param word
     * @return: boolean
     */
    boolean find;
    public boolean exist(char[][] board, String word) {
        find = false;
        //将单词转换为数组
        char[] words = word.toCharArray();

        //进行横向和纵向遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find){
                    return find;
                }
                dfs(board, words, i, j, 0);
            }
        }
        return find;
    }

    private void dfs(char[][] board, char[] words, int i, int j, int k) {
        int m = board.length, n = board[0].length;
        //边界
        if (i < 0 || i >= m || j < 0 || j >= n){
            return;
        }

        //全部遍历完，则返回
        if (k == words.length){
            find = true;
            return;
        }
        //当前字符不匹配直接返回
        if (board[i][j] != words[k]){
            return;
        }

        //将搜索过的字符改成 "#"
        board[i][j] = '#';

        //递归上下左右搜索
        dfs(board, words, i+1, j, k+1);
        dfs(board, words, i-1, j, k+1);
        dfs(board, words, i, j+1, k+1);
        dfs(board, words, i, j-1, k+1);

        //退出
        board[i][j] = '#';
    }

    public static void main(String[] args) {
        CodingTest060 test = new CodingTest060();
        System.out.println(test.exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCB"));
    }

}
