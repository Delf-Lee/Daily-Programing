package codility.lesson6;

import java.util.Arrays;

public class Distinct {
    public int solution(int[] A) {
        if (A.length < 2) return A.length;

        Arrays.sort(A);
        int before = A[0];
        int result = 1;
        for (int i = 1; i < A.length; i++) {
            if (before != A[i]) {
                result++;
                before = A[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Distinct().solution(new int[]{2, 2, 2, 3, 3, 3, 1}));
    }
}
