package backjoon;

import java.util.Scanner;

public class Q2110 {

    // https://www.acmicpc.net/problem/2110
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int ans = 1;
        int l = b[0];
        int r = b[n - 1];

        while (l <= r) {
            int mid = (l + r) / 2;
            if (possible(b, c, mid)) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);

    }

    public static boolean possible(int[] a, int c, int mid) {
        int cnt = 1;
        int last = a[0];
        for (int house : a) {
            if (house - last >= mid) {
                cnt += 1;
                last = house;
            }
        }
        return cnt >= c;
    }
}
