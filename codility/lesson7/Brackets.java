package codility.lesson7;

import java.util.EmptyStackException;
import java.util.HashMap;
        import java.util.Map;
        import java.util.Stack;

public class Brackets {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
    }

    public int solution(String S) {
        if (S.length() == 0) return 1;

        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) {
                stack.add(map.get(c));
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
        System.out.println(new Brackets().solution(""));
    }
}
