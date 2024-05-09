package com.axing;

import java.util.Arrays;

public class Problem27 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int j = removeElement(arr,2);
        for (int i = 0; i < j; i++) {
            System.out.print(arr[i] + " , ");
        }
        System.out.println(j);

    }

    public static int removeElement(int[] nums, int val) {
        int sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
                sum++;
            }
        }
        Arrays.sort(nums);
        return nums.length - sum;

    }

}
