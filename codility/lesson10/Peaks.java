package codility.lesson10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author delf
 */
public class Peaks {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Set<Integer> peekIndices = new HashSet<>(A.length / 2);
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peekIndices.add(i);
            }
        }

        if (peekIndices.isEmpty()) {
            return 0;
        }
        if (peekIndices.size() == 1) {
            return 1;
        }

        int max = 0;
        for (int i = 2; i < A.length; i++) {
            int range;
            if (i * i == A.length) {
                range = i;
            } else if (A.length % i == 0) {
                range = A.length / i;
            } else {
                continue;
            }

            if(contains(peekIndices, A, range)) {
                max = Math.max(max, i);
            } else {
                break;
            }
        }

        return max;
    }

    public boolean contains(Set indices, int[] array, int range) {
        boolean result = false;
        for (int i = 0; i < array.length; i += range) {
            for (int j = i; j < i + range; j++) {
                result |= indices.contains(j);
                if(result) break;
            }
            if(!result) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Peaks().solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }
}