package backjoon;

import java.util.Scanner;
// https://www.acmicpc.net/problem/1654
// 랜선 자르기
public class Q1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] lines = new long[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = sc.nextLong();
            max = Math.max(max, lines[i]);
        }
        long ans = 0;
        long start = 1;
        long end = max;
        while (start <= end) {
            long cut = (start + end) / 2;
            if (check(lines, n, cut)) {
                ans = Math.max(ans, cut);
                start = cut + 1;
            } else {
                end = cut - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean check(long[] lines, int n, long cut) {
        int cnt = 0;
        for (int i = 0; i < lines.length; i++) {
            cnt += lines[i] / cut;
        }
        return cnt >= n;
    }
}
