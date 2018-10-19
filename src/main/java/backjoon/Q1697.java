package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1697
public class Q1697 {
    static final int MAX = 1000000;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] chk = new boolean[MAX];
        int[] d = new int[MAX];
        chk[n] = true;
        d[n] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int x = q.remove();
            if (x - 1 >= 0 && !chk[x - 1]) {
                q.add(x - 1);
                chk[x - 1] = true;
                d[x - 1] = d[x] + 1;
            }
            if (x + 1 < MAX && !chk[x + 1]) {
                q.add(x + 1);
                chk[x + 1] = true;
                d[x + 1] = d[x] + 1;
            }
            if (x * 2 < MAX && !chk[x * 2]) {
                q.add(x * 2);
                chk[x * 2] = true;
                d[x * 2] = d[x] + 1;

            }
        }
        System.out.println(d[k]);
    }
}

