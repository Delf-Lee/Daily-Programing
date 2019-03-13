package hackerrank;

import java.util.Arrays;

/**
 * @author delf
 */
public class FlippingMatrix {

    static int flippingMatrix(int[][] matrix) {
        int N = matrix.length;
        int sum = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                int[] arr = {matrix[i][j], matrix[i][N - 1 - j], matrix[N - 1 - i][j], matrix[N - 1 - i][N - 1 - j]};
                Arrays.sort(arr);
                sum += arr[arr.length - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(flippingMatrix(new int[][]{{12, 42, 83, 119}, {56, 125, 56, 49}, {15, 78, 101, 43}, {62, 98, 114, 108}}));
    }
}

