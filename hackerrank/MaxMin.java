package hackerrank;

import java.util.Arrays;

/**
 * @author delf
 */
public class MaxMin {
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - k; i++) {
            if (arr[i + k - 1] - arr[i] < min) min = arr[i + k - 1] - arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxMin(4, new int[]{1, 2, 3, 4, 10, 20, 30, 40, 100, 200}));
        System.out.println(maxMin(3, new int[]{100, 200, 300, 350, 400, 401, 402}));
    }
}
