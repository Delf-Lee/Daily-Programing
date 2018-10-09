package backjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/12904
// A와 B
public class Q12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        if (s.length() < t.length()) {
            String tmp = s;
            s = t;
            t = tmp;
        }
        StringBuilder bs = new StringBuilder(s);
        boolean flag;
        while (true) {
            if (bs.length() == t.length()) {
                flag = bs.toString().equals(t);
                break;
            }
            char last = bs.charAt(bs.length() - 1);
            bs = bs.deleteCharAt(bs.length() - 1);
            if (last == 'B') {
                bs = bs.reverse();
            }
        }
        System.out.println(flag ? 1 : 0);
    }
}

/*public static boolean check(String s, String t) {
        if (s.length() < t.length()) {
            return check(addA(s), t) || check(addB(s), t);
        }
        System.out.printf("%s == %s\n", s, t);
        return s.equals(t);
    }*/
