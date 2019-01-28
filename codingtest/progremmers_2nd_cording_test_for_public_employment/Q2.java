package codingtest.progremmers_2nd_cording_test_for_public_employment;

import java.util.Arrays;

/**
 * @author delf
 */
public class Q2 {
    public int solution(int l, int[] v) {
        Arrays.sort(v);
        int left = v[0];
        int right = l - v[v.length - 1];

        int dMax = 0;
        for (int i = 0; i < v.length - 1; i++) {
            if (v[i + 1] - v[i] > dMax) {
                dMax = v[i + 1] - v[i];
            }
        }
        return Math.max(Math.max(right, left), Math.round((float)dMax / 2));
    }

    public static void main(String[] args) {
        Q2 test = new Q2();
        System.out.println(test.solution(8, new int[]{2, 3, 4, 5, 6, 7}));
    }
}
