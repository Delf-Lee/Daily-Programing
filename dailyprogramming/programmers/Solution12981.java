/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package programmers;

import java.util.Arrays;
import java.util.Stack;

// 프로그래머스
//코딩테스트 연습 > 2018 서머코딩 > 영어 끝말잇기
public class Solution12981 {
    public static void main(String[] args) {
        Solution12981 main = new Solution12981();
        // System.out.println(Arrays.toString(main.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(main.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
    }

    public int[] solution(int n, String[] words) {
        Stack<String> stack = new Stack<>();
        int i;
        stack.push(words[0]); // 첫 단어 입력
        for (i = 1; i < words.length; i++) {
            if (stack.contains(words[i])) { // 단어 중복
                break;
            } else {
                String last = stack.peek();
                if (!words[i].startsWith(String.valueOf(last.charAt(last.length() - 1)))) {
                    break; // 끝말잇기 규칙
                }
                stack.push(words[i]);
            }
        }
        // return {틀린 사람, 틀린 턴}
        return i == words.length ? new int[]{0, 0} : new int[]{(i % n) + 1, (i + 1) / n};
    }
}