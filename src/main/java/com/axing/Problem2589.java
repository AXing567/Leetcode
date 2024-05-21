package com.axing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem2589
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/15 上午8:36
 * @version: 1.0
 */
public class Problem2589 {


    public static void main(String[] args) {
        Problem2589 p = new Problem2589();
        int[][] case1 = {{2, 3, 1}, {4, 5, 1}, {1, 5, 2}};
        System.out.println(p.findMinimumTime(case1));
    }

    public int findMinimumTime(int[][] tasks) {
        boolean[] time = new boolean[2005];
        // 按照end进行从小到大排序
        Arrays.sort(tasks, Comparator.comparingInt((int[] o) -> o[1]));
        // 维护一个时间数组
        // 对每一组进行时间统计
        for (int i = 0; i < tasks.length; i++) {
            // 统计重叠部分的时长
            int overlap = 0;
            int begin = tasks[i][0], end = tasks[i][1], duration = tasks[i][2];
            for (int t = begin; t <= end; t++) {
                overlap += (time[t] ? 1 : 0);
            }
            // 判断重叠部分时长是否超过本任务的持续时间
            if (overlap >= duration) continue;
            // 重叠时长未超过本任务持续时间，对未超过部分进行标记
            int diff = duration - overlap;
            for (int t = end; t >= begin; t--) {
                if (!time[t]) {
                    time[t] = true;
                    diff--;
                }
                if (diff == 0) {
                    break;
                }
            }
        }
        int res = 0;
        for (boolean i : time) {
            res += i ? 1 : 0;
        }
        return res;
    }
}
