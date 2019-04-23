package codility.lesson9;


/**
 * @author delf
 */
public class MaxProfit {
    public int solution(int[] A) {
        if (A.length == 1 || A.length == 0) {
            return 0;
        }

        int maxSoFar = 0;
        int maxEndingHere = 0;
        int minPrice = A[0];

        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(0, A[i] - minPrice);
            minPrice = Math.min(minPrice, A[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
    }
}
