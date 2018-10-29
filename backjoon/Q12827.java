package backjoon;

        import java.util.Scanner;
// https://www.acmicpc.net/problem/12871
// 무한문자열
public class Q12827 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        char[] t = sc.nextLine().toCharArray();
        int res = 0;
        int i = 0, j = 0;
        while (true) {
            if(i >= s.length) i = 0;
            if(j >= t.length) j = 0;
            if (s[i++] == t[j++]) {
                if (i == s.length && j == t.length) {
                    res = 1;
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println(res);
    }
}