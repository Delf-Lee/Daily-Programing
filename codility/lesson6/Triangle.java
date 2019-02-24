package codility.lesson6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Triangle {
    private Set<Integer> set = new HashSet<>();

    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 2; i < A.length; i++) {
            if ((long) A[i - 2] + (long) A[i - 1] > A[i]) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().solution(new int[]{1, 1, 1, 1, 5, 5, 5}));
    }
}