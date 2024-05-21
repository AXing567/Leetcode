package com.axing;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @projectName: Leetcode
 * @package: com.axing
 * @className: Problem994
 * @author: Axing
 * @description: TODO
 * @date: 2024/5/14 上午9:28
 * @version: 1.0
 */
public class Problem994 {
    public static void main(String[] args) {
        int[][] orange = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(orange));
    }

    public static int orangesRotting(int[][] grid) {
        // 行
        int M = grid.length;
        // 列
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 新鲜橘子的数量
        int count = 0;
        // 统计新鲜橘子的数量 和 让腐烂的句子入队
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    // 腐烂的橘子入队
                    queue.add(new int[]{r, c});
                }
            }
        }

        // round表示腐烂的轮数、分钟数
        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {

                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                //
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count--;
                    queue.add(new int[]{r - 1, c});
                }

                if (r + 1 < M && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    queue.add(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    count--;
                    queue.add(new int[]{r, c - 1});
                }
                if (c + 1 < N && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    count--;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }
        if (count > 0) {
            return -1;
        } else {
            return round;
        }

    }
}
