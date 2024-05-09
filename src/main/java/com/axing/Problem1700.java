package com.axing;

import java.util.Arrays;

public class Problem1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        // 累加students中元素的和
        int s1 = Arrays.stream(students).sum();
        // 元素为0的个数
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }
}
