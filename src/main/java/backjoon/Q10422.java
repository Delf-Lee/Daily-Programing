package backjoon;

import java.util.Scanner;

public class Q10422 {

    public static void main(String[] args) {
        final int div = 1000000007;
        long[] sq = new long[2501];
        sq[0] = 1;
        for (int i = 1; i <= sq.length - 1; i++) {
            sq[i] = 0;
            for (int j = 0; j < i; j++) {
                sq[i] += sq[j] * sq[i - 1 - j];
                sq[i] %= div;
            }
            sq[i] %= div;
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            result.append((n % 2 == 0 ? sq[n / 2] : 0) + "\n");

        }
        result.delete(result.length() - 1, result.length());
        System.out.println(result);
    }
}
