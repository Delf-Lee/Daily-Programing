package domain.frame;

import java.util.*;

public class Solution42585 {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        char[] sticks = arrangement.toCharArray();
        for (char ch : sticks) {
            if (ch == '(') {
                flag = true;
                stack.push(ch);
                continue;
            }

            if (stack.peek() == '(') {
                if (flag) {
                    answer += stack.size() - 1;
                    flag = false;
                } else {
                    answer++;
                }
                stack.pop();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42585().solution("()(((()())(())()))(())"));
    }
}
