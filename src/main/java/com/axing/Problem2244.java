package com.axing;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem2244
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/14 上午10:13
 * @version: 1.0
 */
public class Problem2244 {
    public static void main(String[] args) {
        Problem2244 p = new Problem2244();
        int[] t = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int[] t2 = {2, 3, 3};
        System.out.println(p.minimumRounds(t));
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.merge(task, 1, Integer::sum);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return -1;
            result += (int) Math.ceil(entry.getValue() / 3.0);
        }
        return result;
    }
}
