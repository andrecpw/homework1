package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("subinoonibus"));
        System.out.println(checkPalindrome("1001"));

        System.out.println(checkPalindrome("abracadabra"));
        System.out.println(checkPalindrome("100"));

        System.out.println(checkBrackets("()[]{}"));
        System.out.println(checkBrackets("([]{})"));
        System.out.println(checkBrackets("((((()))))"));

        System.out.println(checkBrackets(")"));
        System.out.println(checkBrackets("()]{}"));
        System.out.println(checkBrackets("()[{}"));
    }

    public static boolean checkPalindrome(String string) {
        string = string.toLowerCase();
        boolean answer = false;
        if (string.equals("")) {
            return answer;
        }
        String reverse = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reverse = reverse + string.charAt(i);
        }
        if (reverse.equals(string)) {
            answer = true;
        }
        return answer;
    }

    public static boolean checkBrackets(String string) {
        Deque<Character> toBeClosed = new ArrayDeque<Character>();
        char x = "(".charAt(0);
        char y = "[".charAt(0);
        char z = "{".charAt(0);
        for (int i = 0; i < string.length(); i++) {
            char token = string.charAt(i);
            if (token == x || token == y || token == z) {
                toBeClosed.push(token);
                continue;
            }
            else if (toBeClosed.isEmpty()) {
                return false;
            }
            char last;
            switch (token) {
                case ')':
                    last = toBeClosed.pop();
                    if (last == y || last == z) {
                        return false;
                    }
                    break;
                case ']':
                    last = toBeClosed.pop();
                    if (last == x || last == z) {
                        return false;
                    }
                    break;
                case '}':
                    last = toBeClosed.pop();
                    if (last == x || last == y) {
                        return false;
                    }
                    break;
            }
        }
        return (toBeClosed.isEmpty());
    }
}