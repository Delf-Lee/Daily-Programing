public class Q43162 {

    private final static int CONNECTED = 1;

    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, visit, computers);
                result++;
            }
        }
        return result;
    }

    public void dfs(int node, boolean[] visit, int[][] computers) {
        if (visit[node]) {
            return;
        }

        visit[node] = true;
        for (int i = 0; i < visit.length; i++) {
            if (node != i && isConnected(node, i, computers)) {
                dfs(i, visit, computers);
                visit[i] = true;
            }
        }
    }

    public static boolean isConnected(int v1, int v2, int[][] computers) {
        if (computers[v1][v2] != CONNECTED) {
            return false;
        }
        return computers[v1][v2] == computers[v2][v1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}