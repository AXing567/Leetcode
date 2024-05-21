package com.axing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem826
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/17 上午10:11
 * @version: 1.0
 */
public class Problem826 {
    public static void main(String[] args) {
        Problem826 p = new Problem826();
        int[] d = {18, 83, 18, 72, 63};
        int[] pr = {54, 98, 19, 47, 77};
        int[] w = {18, 28, 78, 100, 16};
        System.out.println(p.maxProfitAssignment(d, pr, w));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            map.merge(difficulty[i], profit[i], Math::max);
        }
        System.out.println(map);
        int[] keyArray = map.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        // 存储前i项最大的值  index[5]:0到5之间最大的值
        int[] maxArr = new int[keyArray.length];
        int temp = 0;
        maxArr[0] = map.get(map.firstKey());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (temp == 0) {
                temp++;
                continue;
            }
            int val = entry.getValue();
            maxArr[temp] = Math.max(val, maxArr[temp - 1]);
            temp++;
        }

        for (int i : worker) {
            int index = Arrays.binarySearch(keyArray, i);
            if (index < 0) {
                index = -index - 2;
            }

            if (index != -1) {
                int max = 0;
                max = maxArr[index];
                res += max;
            }
        }
        return res;
    }

    public int case2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[] maxProfit = new int[100001];
        for (int i = 0; i < n; i++) {
            maxProfit[difficulty[i]] = Math.max(maxProfit[difficulty[i]], profit[i]);
        }
        int max = 0;
        for (int i = 0; i < maxProfit.length; i++) {
            if (maxProfit[i] < max) {
                maxProfit[i] = max;
            } else {
                max = maxProfit[i];
            }
        }
        int ans = 0;
        for (int i : worker) {
            ans += maxProfit[i];
        }
        return ans;
    }
}
