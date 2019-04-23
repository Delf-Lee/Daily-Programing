package codility.lesson9;

/**
 * @author delf
 */
public class MaxSliceSum {
    public int solution(int[] A) {
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
