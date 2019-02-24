package codingtest.remotejobfair2019;

import java.util.Map;

/**
 * @author delf
 */
public class Q1_SumOfThreePrime {
    //static int[][] arr = new int[][]{{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0}};
    static int[][] arr = new int[][]{{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 9, 2, -4, -4, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, -1, -2, -4, 0}};

    public static void main(String[] args) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                max = Math.max(sumHourglass(i, j), max);
            }

        }
        System.out.println(max);
    }

    static int sumHourglass(int r, int c) {
        int sum = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (i - r == 1) {
                    if (j - c == 0 || j - c == 2) {
                        continue;
                    }
                }
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
