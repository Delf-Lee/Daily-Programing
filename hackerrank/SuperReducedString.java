package hackerrank;

import java.util.Stack;

/**
 * @author delf
 */
public class SuperReducedString {

    static String superReducedString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.empty() || ch != stack.peek()) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.remove(0));

        return sb.length() == 0 ? "Empty String" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(superReducedString("zztqooauhujtmxnsbzpykwlvpfyqijvdhuhiroodmuxiobyvwwxupqwydkpeebxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh"));
    }
}
