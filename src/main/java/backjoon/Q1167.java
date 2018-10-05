package backjoon;

import java.util.*;

// https://www.acmicpc.net/problem/1167
public class Q1167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Edge>[] tree = new List[sc.nextInt() + 1];
        for (int i = 1; i < tree.length; i++) {
            int n = sc.nextInt();
            tree[n] = new ArrayList<>();
            int input;
            while ((input = sc.nextInt()) != -1) {
                tree[n].add(new Edge(sc.nextInt(), input));
            }
        }

        int[] dist = find(tree, tree.length, 1);
        int start = 1;
        for (int i = 2; i <= tree.length; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = find(tree, tree.length, start);
        int ans = dist[1];
        for (int i = 2; i <= tree.length; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);
    }

    public static int[] find(List<Edge>[] tree, int n, int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int edge = q.remove();
            for (Edge e : tree[edge]) {
                int des = e.to;
                int cost = e.cost;
                if (!check[des]) {
                    dist[des] = dist[edge] + cost;
                    q.add(des);
                    check[des] = true;
                }
            }
        }
        return dist;
    }
}

class Edge {
    public int to;
    public int cost;

    public Edge(int cost, int to) {
        this.cost = cost;
        this.to = to;
    }
}