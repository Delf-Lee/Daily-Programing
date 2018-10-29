package backjoon;

import java.util.Scanner;

public class Q2745 {
    // 진법 변환
    // #진법
    // https://www.acmicpc.net/problem/2745
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());
        short b = sc.nextShort();
        int result = 0;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            double m = Math.pow(b, sb.length() - 1 - i);
            int dec = Character.isAlphabetic(ch) ? (ch - 'A' + 10) : ch;
            result += dec * m;
        }
        System.out.println(result);
    }
}
