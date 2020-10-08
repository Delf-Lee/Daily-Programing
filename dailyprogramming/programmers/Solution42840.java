package programmers;

import java.util.*;

public class Solution42840 {
    public int[] solution(int[] answers) {
        int[][] supoPatterns = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        List<Integer> result = new ArrayList<>();

        int maxAnswerCount = 0;
        for (int i = 0; i < supoPatterns.length; i++) {
            int correctAnswerCount = 0;
            for (int j = 0; j < answers.length; j++) {
                if (supoPatterns[i][j % supoPatterns[i].length] == answers[j]) { // 패턴보다 답이 짧은 경우?
                    correctAnswerCount++;
                }
            }

            if (maxAnswerCount > correctAnswerCount) {
                continue;
            }
            if (maxAnswerCount < correctAnswerCount) {
                maxAnswerCount = correctAnswerCount;
                result.clear();
            }
            result.add(i + 1);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(">>>" + Arrays.toString(new Solution42840().solution(new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5})));

    }
}
