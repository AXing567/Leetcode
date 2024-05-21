package com.axing;

import java.util.Arrays;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem1542
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/20 下午4:26
 * @version: 1.0
 */
public class Problem1542 {
    public static void main(String[] args) {
        Problem1542 p = new Problem1542();
        System.out.println(p.longestAwesome("3242415"));
    }

    static int[] pre = new int[1 << 11];

    public int longestAwesome(String s) {
        int n = s.length(), status = 0, res = 0;
        Arrays.fill(pre, -2);
        pre[status] = -1;
        for (int i = 0; i < n; i++) {
            status ^= 1 << (s.charAt(i) - '0');
            if (pre[status] != -2) {
                res = Math.max(res, i - pre[status]);
            } else {
                pre[status] = i;
            }
            for (int j = 0; j < 10; j++) {
                int status1 = status ^ (1 << j);
                if (pre[status1] != -2) {
                    res = Math.max(res, i - pre[status1]);
                }

            }


        }
        return res;
    }
}
