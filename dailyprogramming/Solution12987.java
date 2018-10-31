package dailyprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution12987 {
    public static void main(String[] args) {
        Solution12987 m = new Solution12987();
        // System.out.println(m.solution(new int[]{6, 4, 7, 8, 5, 4, 9, 4, 5, 5, 6, 2, 8, 8, 3}, new int[]{4, 7, 7, 6, 6, 2, 6, 6, 8, 9, 9, 8, 7, 2, 3}));
        System.out.println(m.solution(new int[]{1, 2, 2, 3, 4}, new int[]{1, 2, 2, 3, 4}));
        // System.out.println(m.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        // System.out.println(m.solution(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}));
    }

    public int solution(int[] A, int[] B) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : B) counter.put(i, counter.getOrDefault(i, 0) + 1);
        Arrays.sort(A);
        // Arrays.sort(B);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        System.out.println(counter);

        int score = 0;
        for (int i : A) {
            for (int j : counter.keySet()) {
                if (i < j) {
                    System.out.printf("%d < %d\n", i, j);
                    score++;
                    if (counter.put(j, counter.get(j) - 1) == 1) {
                        counter.remove(j);
                    }
                    break;
                }
            }
            System.out.println(counter);
        }
        return score;
    }
}