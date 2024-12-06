package com.lrj.codinglearn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TwoNumbersAdd
 * @Description:
 * @Date: 2023/4/17 18:17
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class TwoNumbersAdd {

    public static void main(String[] args) {
        TwoNumbersAdd twoNumbersAdd = new TwoNumbersAdd();
        int[] arr = new int[]{2, 3, 4};
        System.out.println(twoNumbersAdd.m1(arr, 6));
        System.out.println(twoNumbersAdd.m2(arr, 6));
    }

    /**
     * hash方式存储，时间复杂度为O(n)
     * @author: luorenjie
     * @date: 2023/4/18 9:58
     * @param numbers
     * @param target
     * @return: int[]
     */
    private int[] m2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int another = target - numbers[i];
            if (map.get(another) != null){
                res[0] = map.get(another);
                res[1] = i+1;
                break;
            }
            map.put(numbers[i], i+1);
        }
        return res;
    }

    /**
     * 双for循环，时间复杂度为O(n^2)
     * @author: luorenjie
     * @date: 2023/4/18 9:57
     * @param numbers
     * @param target
     * @return: int[]
     */
    private int[] m1(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target ){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{-1, -1};
    }

}
