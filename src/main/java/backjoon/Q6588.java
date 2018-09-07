package backjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/6588
public class Q6588 {
    public static void main(String[] args) {
        final int MAX = 1000000;
        int[] prime = new int[MAX];
        int pn = 0;
        boolean[] check = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            if (!check[i]) {
                prime[pn++] = i;
                for (int j = i + i; j <= MAX; j += i) {
                    check[j] = true;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            for (int i = 1; i < pn; i++) {
                if (!check[n - prime[i]]) {
                    System.out.println(n + " = " + prime[i] + " + " + (n - prime[i]));
                    break;
                }
            }
        }
    }
}
