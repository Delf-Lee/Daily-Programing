package backjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1373
// #진법
// 2진수 8진수
public class Q1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String b = sc.next();
        StringBuilder result = new StringBuilder("");
        if (b.length() % 3 == 1) {
            result.append(b.charAt(0));
        } else if (b.length() % 3 == 2) {
            result.append((b.charAt(0) - '0') * 2 + (b.charAt(1) - '0'));
        }
        for (int i = b.length() % 3; i < b.length(); i += 3) {
            result.append((b.charAt(i) - '0') * 4 + (b.charAt(i + 1) - '0') * 2 + (b.charAt(i + 2) - '0'));
        }
        System.out.println(result);
    }
}
