package com.axing;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem3151
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/21 上午10:43
 * @version: 1.0
 */
public class Problem3151 {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        boolean f = nums[0] % 2 == 0;
        for (int i = 1; i < nums.length; i++) {
            boolean f2 = nums[i] % 2 == 0;
            if (f == f2) return false;
            f = f2;
        }
        return true;
    }
}
