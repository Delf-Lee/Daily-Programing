package backjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2743
public class Q2743 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        try {
            while (true) str.charAt(++i);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(i);
        }
        // System.out.println(new Scanner(System.in).nextLine().length());
    }

}
