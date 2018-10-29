package backjoon;


// https://www.acmicpc.net/problem/12865
// 평범한 배낭

import java.util.*;

public class Q12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] d = new int[n + 1][k + 1];
        int w[] = new int[n + 1];
        int v[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i] > j) {
                    d[i][j] = d[i - 1][j];
                } else {
                    d[i][j] = Math.max(v[i] + d[i - 1][j - w[i]], d[i - 1][j]);
                }
            }
        }
        System.out.println(d[n][k]);
    }
}