package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution12987 {
    public static void main(String[] args) {
        Solution12987 m = new Solution12987();
        System.out.println(m.solution(new int[]{6, 4, 7, 8, 5, 4, 9, 4, 5, 5, 6, 2, 8, 8, 3}, new int[]{4, 7, 7, 6, 6, 2, 6, 6, 8, 9, 9, 8, 7, 2, 3}));
        // System.out.println(m.solution(new int[]{1, 3, 2, 2, 3, 4}, new int[]{1, 2, 2, 3, 4, 5}));
        // System.out.println(m.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        // System.out.println(m.solution(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}));
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        Queue<Integer> qA = new LinkedList<>(new ArrayList<>(Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new))));
        Queue<Integer> qB = new LinkedList<>(new ArrayList<>(Arrays.asList(Arrays.stream(B).boxed().toArray(Integer[]::new))));

        int answer = 0;
        while (!qA.isEmpty() && !qB.isEmpty()) {
            if (qA.peek() < qB.peek()) {
                qA.poll();
                answer++;
            }
            qB.poll();
        }
        return answer;
    }
}