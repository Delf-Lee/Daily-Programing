public class Q1 {
    public static void main(String[] args) {
        System.out.println(new Q1().solution(3, 4, new int[][]{{2, 0, 0, 8}, {2, 1, 99, 0}, {0, 2, 2, 4}}));
    }

    public int solution(int N, int M, int[][] map) {
        boolean[][] isVisit = new boolean[N][M];

        return clean(0, 0, isVisit, map, 0);
    }

    public int clean(int r, int c, boolean[][] isVisit, int[][] map, int trash) {
        if (r >= isVisit.length || c >= isVisit[0].length) {
            return 0;
        }

        if (r == isVisit.length - 1 && c == isVisit[0].length - 1) {
            return map[r][c];
        }

        int right = clean(r, c + 1, isVisit, map, trash);
        int down = clean(r + 1, c, isVisit, map, trash);
        System.out.println(Math.max(right, down) + map[r][c]);
        return Math.max(right, down) + map[r][c];
    }
}