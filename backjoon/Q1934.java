package backjoon;

import java.util.Scanner;

// 최소공배수
// https://www.acmicpc.net/problem/1934
public class Q1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(getLCM(x, y));
        }
    }

    public static int getLCM(int x, int y) {
        int g = getGCD(x, y);
        return x * y / g; // g*(x/g)*(y/g)
    }

    public static int getGCD(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}