package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Edaily004 {
    private static int weights[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nv = Integer.parseInt(input[0]);
        int ne = Integer.parseInt(input[1]);
        weights = new int[nv + 1][nv + 1];
        for (int i = 0; i < ne; i++) {
            String[] ftc = br.readLine().split(" "); // from to cost
            int from = Integer.parseInt(ftc[0]);
            int to = Integer.parseInt(ftc[1]);
            int cost = Integer.parseInt(ftc[2]);
            weights[from][to] = cost;
            weights[to][from] = cost;
        }

        int[][] map = new int[nv + 1][nv + 1];
        for (int i = 1; i < nv + 1; i++) {
            map[i] = dijkstra(i, nv);
        }

        for (int i = 1; i < nv + 1; i++) {
            boolean[] c = new boolean[nv + 1];
            // int dist = min(map[i], c);
        }
        
    }

    // TODO: 구현중
    /*public static int min(int[] arr, boolean[] c) {
        int min = 10000;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        q.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        while (!q.isEmpty()) {

        }
    }*/

    public static int[] dijkstra(int start, int n) {
        int dist[] = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        check[start] = true;

        for (int i = 1; i < n + 1; i++) {
            if (!check[i] && weights[start][i] != 0) {
                dist[i] = weights[start][i];
            }
        }

        for (int a = 0; a < n - 1; a++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && dist[i] != Integer.MAX_VALUE) {
                    if (dist[i] < min) {
                        min = dist[i];
                        min_index = i;
                    }
                }
            }

            check[min_index] = true;
            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && weights[min_index][i] != 0) {
                    if (dist[i] > dist[min_index] + weights[min_index][i]) {
                        dist[i] = dist[min_index] + weights[min_index][i];
                    }
                }
            }

        }

        return dist;
    }
}
/*public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nv = Integer.parseInt(input[0]);
        int ne = Integer.parseInt(input[1]);

        List<Edge>[] lines = new List[nv + 1];
        for (int i = 1; i < nv + 1; i++) {
            lines[i] = new ArrayList<>();
        }
        for (int i = 0; i < ne; i++) {
            String[] ftc = br.readLine().split(" "); // from to cost
            int from = Integer.parseInt(ftc[0]);
            int to = Integer.parseInt(ftc[1]);
            int cost = Integer.parseInt(ftc[2]);
            System.out.printf("from:%d, to:%d, cost:%d\n", from, to, cost);
            lines[from].add(new Edge(cost, to));
        }


    }

    public static int dfs(List<Edge>[] lines, boolean[] c, int x) {
        if (c[x]) {
            return x;
        }
        c[x] = true;
        System.out.print(x + " ");
        for (Edge e : lines[x]) {
            if (!c[e.to]) {
                return dfs(lines, c, e.to);
            }
        }
    }

    static class Edge {
        public int to;
        public int cost;

        public Edge(int cost, int to) {
            this.cost = cost;
            this.to = to;
        }
    }
}*/

