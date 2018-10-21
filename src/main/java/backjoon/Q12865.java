package backjoon;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/12865
// 평범한 배낭
public class Q12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n + 1][k + 1];
        int w[] = new int[n];
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                if (w[i + 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(v[i] + dp[i - 1][j - w[i]], dp[i - 1][j]);
                }

            }
        }
        System.out.println(dp[n - 1][k - 1]);
    }
}

