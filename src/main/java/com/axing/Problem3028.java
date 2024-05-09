package com.axing;

public class Problem3028 {
    public int returnToBoundaryCount(int[] nums) {
        int sum = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                result++;
            }
        }
        return result;
    }
}
