package codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution2(int[] A) {
        if (A.length == 3) return A[0] * A[1] * A[2];

        Arrays.sort(A);
        int flag;
        for (flag = 0; flag < A.length; flag++) if (A[flag] >= 0) break;
        boolean zero = A[flag] == 0;
        int negCnt = flag;
        int posCnt = A.length - flag - (zero ? 1 : 0); // = start index of positive
        int posStartIdx = A.length - posCnt;

        if (posCnt < 2) { // when result of product only negative
            if (zero) return 0;
            int negEndIdx = negCnt - 1;
            int result = A[negEndIdx] * A[negEndIdx - 1];
            if (posCnt == 0) {
                return result * A[negEndIdx - 2];
            } else {
                int smaller = Math.abs(A[negEndIdx - 2]) < Math.abs(A[posStartIdx]) ? A[negEndIdx - 2] : A[posStartIdx];
                return result * smaller;
            }
        } else { // when result of product possible positive
            int posEndIdx = A.length - 1;
            if (posCnt == 2) {
                int bigger = Math.max(A[posEndIdx], A[posEndIdx - 1]);
                return A[0] * A[1] * bigger;
            } else {
                int bigger = Math.max(A[posEndIdx - 1] * A[posEndIdx - 2], A[0] * A[1]);
                return A[posEndIdx] * bigger;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductOfThree().solution2(new int[]{-3, 1, 2, -2,0, 5, 6}));
    }
}
