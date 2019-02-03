package codility.lesson2;

/**
 * @author delf
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) return A;

        int r = K % A.length;
        if (r == 0) return A;

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[(i + r) % res.length] = A[i];
        }
        return res;
    }
}
