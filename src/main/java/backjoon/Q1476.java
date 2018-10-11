package backjoon;

import java.util.Scanner;
// https://www.acmicpc.net/problem/1476
// 날짜 계산
public class Q1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int[] LIMIT = new int[]{15, 28, 19};
        int[] t = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        int[] now = new int[t.length];
        int cnt = 0;
        while (true) {
            cnt++;
            boolean[] flag = new boolean[t.length];
            for (int i = 0; i < now.length; i++) {
                now[i] = now[i]++ < LIMIT[i] ? now[i] : 1;
                flag[i] = (now[i] == t[i]);
            }
            if (flag[0] && flag[1] && flag[2]) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
