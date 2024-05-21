package com.axing;

import java.util.Arrays;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem3152
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/21 上午10:27
 * @version: 1.0
 */
public class Problem3152 {
    public static void main(String[] args) {
        Problem3152 p = new Problem3152();
        int[] a = {1,1};
        int[][] b= {{0,1}};
        boolean[] arraySpecial = p.isArraySpecial(a, b);
        System.out.println(Arrays.toString(arraySpecial));
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] sum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != nums[i - 1] % 2) {
                sum[i] = 0;
            } else {
                sum[i] = 1;
            }
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = sum[queries[i][0]] == sum[queries[i][1]];
        }
        return ans;
    }
}
