package com.axing;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem1023
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/10 上午7:24
 * @version: 1.0
 */
public class Problem1023 {
    public static void main(String[] args) {
        Problem1023 p = new Problem1023();
        String[] case1 = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String[] case2 = {"FoB"};

        List<Boolean> fb = p.camelMatch(case2, "FoooooBaT");
        System.out.println(fb);

    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> b = new ArrayList<>();
        for (String query : queries) {
            b.add(match(query, pattern));
        }
        return b;
    }

    // 给定两个字符串,判断两个字符串是否匹配
    // 原串s，模式串p
    public boolean match(String ss, String pp) {
        if (ss.equals(pp)) return true;
        byte[] s = ss.getBytes();
        byte[] p = pp.getBytes();
        // s中有的大写字母数量是否与p中大写字母数量相等
        ArrayList<Byte> bigS = new ArrayList<>();
        ArrayList<Byte> bigP = new ArrayList<>();
        for (byte b : s) {
            if (b >= 'A' && b <= 'Z') bigS.add(b);
        }
        for (byte b : p) {
            if (b >= 'A' && b <= 'Z') bigP.add(b);
        }
        if (bigS.size() != bigP.size()) return false;
        for (int i = 0, j = 0; i < s.length; i++) {
            // 匹配到模式串的最后，并且字符匹配，则返回true
            if (j == p.length - 1 && s[i] == p[j]) return true;
            // 匹配则j向右移动一位
            if (j < p.length && s[i] == p[j]) j++;
        }
        return false;
    }
}
