package com.axing;

import java.util.HashMap;
import java.util.Map;

public class Problem1512 {
        public int numIdenticalPairs(int[] nums) {
            /*
             * 不用哈希表
             * 一百次循环
             * 如果数值为0则跳过循环
             * 统计某个数字的个数
             * 累加器加加
             * 统计过的数字置零
             * 累加器进行计算并加入到结果（计算：s-1➕s-2➕...1
             * 累加器归零
             */

            /* 用哈希表 */
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            for (int num : nums) {
                m.put(num, m.getOrDefault(num, 0) + 1);
            }

            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                int v = entry.getValue();
                ans += v * (v - 1) / 2;
            }

            return ans;

        }
}
