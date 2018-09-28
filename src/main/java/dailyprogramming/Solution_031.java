package dailyprogramming;

import java.util.Arrays;
// 프고그래머스 알고리즘 연습문제
// https://programmers.co.kr/learn/courses/30/lessons/42584
public class Solution_031 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_031().solution(new int[]{3, 4, 1, 2})));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int index = 0;
        for (int i = 0; i < prices.length; i++) {
            int n = prices[i];
            int cnt = 0;
            for (int j = i+1; j < prices.length; j++) {
                cnt++;
                if (prices[j] < n) break;
            }
            answer[index++] = cnt;
        }
        return answer;
    }
}
