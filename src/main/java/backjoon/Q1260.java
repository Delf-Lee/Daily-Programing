package backjoon;

import java.util.*;

// https://www.acmicpc.net/problem/1260
// DFS와 BFS
public class Q1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        ArrayList<Integer>[] e = (ArrayList<Integer>[]) new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            e[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            e[u].add(v);
            e[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(e[i]);
        }

        boolean[] c = new boolean[n + 1];
        dfs(e, c, start);
        System.out.println();
        c = new boolean[n + 1];
        bfs(e, c, start);
        System.out.println();
    }

    public static void dfs(List<Integer>[] e, boolean[] c, int x) {
        if (c[x]) {
            return;
        }
        c[x] = true;
        System.out.print(x + " ");
        for (int i : e[x]) {
            if (!c[i]) {
                dfs(e, c, i);
            }
        }
    }

    public static void bfs(List<Integer>[] e, boolean[] c, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        c[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int i : e[x]) {
                if (!c[i]) {
                    c[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
