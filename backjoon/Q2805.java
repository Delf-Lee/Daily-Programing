package backjoon;

import java.util.Scanner;



public class Q2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] t = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextLong();
            max = Math.max(t[i], max);
        }

        long start = 0;
        long end = max;
        long ans = 0;
        while (start <= end) {
            long cut = (start + end) / 2;
            if (check(t, m, cut)) {
                start = cut + 1;
                ans = Math.max(cut, ans);
            } else {
                end = cut - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean check(long[] tree, int m, long cut) {
        long sum = 0;
        for (int i = 0; i < tree.length; i++) {
            sum += (tree[i] > cut ? tree[i] - cut : 0);
        }
        return sum >= m;
    }
}
