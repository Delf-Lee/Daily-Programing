package programmers;

import java.util.*;

public class Solution42861 {

    public static void main(String[] args) {
        System.out.println(new Solution42861().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;
    static PriorityQueue<Edge> adj;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        adj = new PriorityQueue<>();

        for (int[] cost : costs) {
            Edge edge = new Edge(cost[0], cost[1], cost[2]);
            adj.offer(edge);
        }

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        while (!adj.isEmpty()) {
            Edge edge = adj.poll();

            if (find(edge.from) == find(edge.to)) {
                continue;
            }

            union(edge.from, edge.to);
            answer += edge.cost;
        }

        return answer;
    }

    public int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;
    }
}
