package atmp;

import java.util.Stack;

public class Q1 {
    public static int getMin(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.empty()) {
                result++;
                continue;
            }

            if (stack.peek() == '(') {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        result += stack.size();

        return result;
    }
    //
    public static void main(String[] args) {
        System.out.println(Q1.getMin("()))"));
        System.out.println(Q1.getMin("()()))("));

    }
}
