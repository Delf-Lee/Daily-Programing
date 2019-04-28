package codility.lesson9;

/**
 * @author delf
 */
public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        if (A.length == 3) {
            return 0;
        }

        int[] sumLeft = new int[A.length];
        int[] sumRight = new int[A.length];

        for (int i = 1; i < A.length - 1; i++) {
            sumLeft[i] = Math.max(0, sumLeft[i - 1] + A[i]);
        }
        
        for (int i = A.length - 2; i >= 1; i--) {
            sumRight[i] = Math.max(0, sumRight[i - 1] + sumRight[i + 1] + A[i]);
        }

        int maxSum = 0;
        for (int i = 1; i < A.length - 1; i++) {
            maxSum = Math.max(maxSum, sumLeft[i - 1] + sumRight[i + 1]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDoubleSliceSum().solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
    }
}

