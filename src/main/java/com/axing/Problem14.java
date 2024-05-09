package com.axing;

public class Problem14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs[0].isEmpty()) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        int index = 0;
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                index++;
            }else {
                break;
            }
        }
        return str1.substring(0, index);
    }
}
