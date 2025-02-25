package com.lrj.codinglearn.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CodingTest001
 * @Description: 热题100之第62题
 * @Date: 2024/8/28 14:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CodingTest062 {

    /**
     * 51.N皇后
     * @author: luorenjie
     * @date: 2025/2/25 13:21
     * @param n
     * @return: java.util.List<java.util.List < java.lang.String>>
     */
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        List<String> track = new ArrayList<>();

        //构建行列
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }

            track.add(sb.toString());
        }

        //回溯，从第一行开始
        backtrack(track, 0);
        return res;
    }


    private void backtrack(List<String> track, int row) {
        if (row == track.size()){
            res.add(new ArrayList<>(track));
            return;
        }

        //拿到当前行的字符串长度
        int n = track.get(row).length();

        //遍历当前行所有的列
        for (int col = 0; col < n; col++) {

            //检查当前列是否有皇后冲突
            if (!isValied(track, row, col)){
                continue;
            }

            //拿到当前行的字符串
            StringBuilder sb = new StringBuilder(track.get(row));
            sb.setCharAt(col, 'Q');
            track.set(row, sb.toString());

            //进入下一层决策树，下一行
            backtrack(track, row + 1);

            //退出
            sb.setCharAt(col, '.');
            track.set(row, sb.toString());
        }
    }

    private boolean isValied(List<String> track, int row, int col) {
        int n = track.size();
        //检查当前列是否有冲突
        for (int i = 0; i < n; i++) {
            if (track.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        //检查右上方是否有冲突
        for (int i = row-1, j = col+1; i >= 0 && j < n ;i--, j++) {
            if (track.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        //检查左上方是否有冲突

        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if (track.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        CodingTest062 test = new CodingTest062();
        System.out.println(test.solveNQueens(4));
    }

}
