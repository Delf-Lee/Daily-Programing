package codingtest.baemintechcourse2019;

import java.util.Stack;

/**
 * @author delf
 */
public class Cryptogram {

    public String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            if (!stack.contains(c)) {
                stack.add(c);
            } else {
                if (stack.peek() == c) {
                    System.out.println(stack.pop());
                }
            }
        }
        // System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.remove(0));

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Cryptogram().solution("browoanoommnaonb"));
    }
}

