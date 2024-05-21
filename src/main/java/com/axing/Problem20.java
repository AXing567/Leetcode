package com.axing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Problem20 {
    public static void main(String[] args) {
        System.out.println(isValid("(((())))}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if(stack.empty()){
                    return false;
                }
                if (getV(stack.pop()) != getV(c)) {
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }

    public static int getV(char c) {
        return switch (c) {
            case '(', ')' -> 1;
            case '{', '}' -> 2;
            case '[', ']' -> 3;
            default -> -1;
        };
    }
    class Solution {
        private static final Map<Character,Character> map = new HashMap<>(){{
            put('{','}'); put('[',']'); put('(',')'); put('?','?');
        }};
        public boolean isValid(String s) {
            // 看第一个字符是不是合规的左括号
            if(!map.containsKey(s.charAt(0))) return false;
            // 为避免空栈时弹出，增加一个‘？’  这里学到一个新技巧，双括号初始化
            LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
            // 循环遍历字符串s,调用字符型变量c
            for(Character c : s.toCharArray()){
                // 如果是左括号，入栈
                if(map.containsKey(c)) stack.addLast(c);
                    // 如果是右括号  并且  栈顶（同时出栈）不是右括号 则返回错误
                else if(map.get(stack.removeLast()) != c) return false;
            }
            // 如果全是左括号则长度不为1
            return stack.size() == 1;
        }

        public boolean test(String s){
            if(!map.containsKey(s.charAt(0))) return false;
            LinkedList<Character> stack = new LinkedList<>(){{add('?');}};
            for (char c : s.toCharArray()) {
                if(map.containsKey(c)) stack.addLast(c);
                else if (map.get(stack.removeLast()) != c) return false;
            }

            return stack.size() == 1;
        }
    }}

