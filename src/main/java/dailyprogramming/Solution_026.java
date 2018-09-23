package dailyprogramming;

// programmers 알고리즘 문제 풀이
// 탑
// https://programmers.co.kr/learn/courses/30/lessons/42588

public class Solution_026 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for (int i = heights.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] > heights[i] && answer[j] == 0) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
