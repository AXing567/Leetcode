package com.axing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem1553
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/12 上午7:17
 * @version: 1.0
 */
public class Problem1553 {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Solution s = new Solution();
        System.out.println(s.minDays(10));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

    }

    static class Solution {
        HashMap<Integer, Integer> m = new HashMap<>();

        public int minDays(int n) {
            if (n <= 1)
                return n;
            if (m.containsKey(n)) return m.get(n);
            // 方案2所花费的天数为：使用方案1的天数n%2 + 使用本方法的天数1 + 使用本方法后剩余橘子计算出的最小天数
            // 3同理
            m.put(n, Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)) + 1);
            return m.get(n);
        }
    }
}
