package backjoon;

import java.util.Scanner;

public class Q11005 {
    // 진법 변환2
    // https://www.acmicpc.net/problem/11005
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        short b = sc.nextShort();
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = n % b;
            if (r < 10) {
                sb.insert(0, r);
            } else {
                sb.insert(0, (char) ('A' + r - 10));
            }
            n /= b;
        }
        System.out.println(sb);
    }
}