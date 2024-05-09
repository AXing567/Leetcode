package com.axing;

import java.util.Arrays;

public class Problem26 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 2, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }


}
