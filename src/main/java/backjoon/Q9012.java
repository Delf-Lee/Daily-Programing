package backjoon;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class Q9012 {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            System.out.println(isValid(sc.nextLine()));
            stack.clear();
        }
    }

    public static String isValid(String ps) {
        System.out.println(ps);
        for (int j = 0; j < ps.length(); j++) {
            if (ps.charAt(j) == '(') {
                stack.push('(');
            } else {
                if (stack.empty()) return "NO";
                stack.pop();
            }

        }
        if (stack.empty()) return "YES";
        else return "NO";
    }
}
