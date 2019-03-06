package codility.lesson7;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author delf
 */
public class Nesting {
    public int solution(String S) {
        if (S.length() == 0) return 1;

        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.add(')');
            } else {
                try {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        return 0;
                    }
                } catch (EmptyStackException e) {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Nesting().solution("((()))"));
    }
}
