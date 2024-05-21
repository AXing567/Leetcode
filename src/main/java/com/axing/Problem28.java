package com.axing;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem28
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/9 上午8:20
 * @version: 1.0
 */
public class Problem28 {
    // KMP算法
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        int[] next = new int[m + 1];

        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) return i - m;
        }
        return -1;
    }
    // 朴素算法
    class Solution {
        public int strStr(String haystack, String needle) {
            int hl = haystack.length();
            int nl = needle.length();
            if (hl == nl)
                return haystack.equals(needle) ? 0 : -1;
            for (int i = 0; i <= hl - nl; i++) {
                int t = i;
                for (int j = 0; j < nl;) {
                    char h = haystack.charAt(t++);
                    char n = needle.charAt(j++);
                    if (h != n)
                        break;
                    if (j == nl)
                        return i;

                }
            }
            return -1;
        }
    }


}
