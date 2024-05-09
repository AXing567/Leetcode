package com.axing;

public class Problem13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("XXIV"));
    }

    private static int romanToInt(String s) {
        int sum = 0;
        int preV = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int currentV = getValue(s.charAt(i));
            if (currentV > preV){
                sum -= preV;
            }else {
                sum += preV;
            }
            preV = currentV;
        }
        return sum + preV;


    }


    private static int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}
