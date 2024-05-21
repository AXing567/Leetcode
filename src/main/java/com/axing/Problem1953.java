package com.axing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem1953
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/16 上午8:12
 * @version: 1.0
 */
public class Problem1953 {
    public static void main(String[] args) {
        Problem1953 p = new Problem1953();
        int[] case1 = {5, 2, 1};
        long l = p.numberOfWeeks(case1);
        System.out.println(l);
    }

    public long numberOfWeeks(int[] milestones) {
        long longest = milestones[0];
        long rest = 0;
        for (int i : milestones) {
            longest = Math.max(longest, i);
            rest += i;
        }
        rest -= longest;
        if (longest > rest + 1){
            return rest * 2 + 1;
        }else{
            return longest + rest;
        }
    }
}
