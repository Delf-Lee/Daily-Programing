package hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author delf
 */
public class MinimumDistances {
    private final static int[][] boundary = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {3, 4}, {4, 5}};

    static int bricksGame(int[] arr) {
        int[] score = {0, 0};
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length; i++) {
                int max = 0;
                for (int j = 0; j < boundary.length; j++) {
                    int sum;
                    try {
                        System.out.printf("%d %d\n", boundary[j][0], boundary[j][1]);
                        sum = arr[i + boundary[j][0]] + arr[i + boundary[j][1]];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        sum = 0;
                    }

                    max = arr[i] + Math.max(max, sum);
                    // System.out.println("max =" + max);
                }
                System.out.println();
                score[i % 2] += max;
            }
        }
        return score[0];
    }

    public static void main(String[] args) {
        System.out.println(bricksGame(new int[]{123, 4, 56, 19, 20})); // 183
        System.out.println(bricksGame(new int[]{15, 17, 25, 128, 95})); // 110
        System.out.println(bricksGame(new int[]{15, 17, 19, 10, 100})); // 114
    }
}

