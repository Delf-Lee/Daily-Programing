package programmers;

import java.util.Arrays;

public class Solution12982 {
    public static void main(String[] args) {
        Solution12982 main = new Solution12982();
        System.out.println(main.solution(new int[]{2, 2, 3, 3}, 10));
    }

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int i;
        for (i = 0; i < d.length; i++) {
            if (d[i] > budget) break;
            budget -= d[i];
        }
        return i;
    }
}