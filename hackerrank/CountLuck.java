package hackerrank;

/**
 * @author delf
 */
public class CountLuck {
    private final static int ROW = 0;
    private final static int COL = 1;
    private final static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static char[][] map;
    private static boolean[][] isChecked;
    private static int depth = 0;
    private static int forkCount = 0;

    public static void main(String[] args) {
        /*String[] mat = {".X.X......X", ".X*.X.XXX.X", ".XX.X.XM...", "......XXXX."};
        System.out.println(countLuck(mat, 3));
        String[] mat2 = {"*.M", ".X."};*/
        String[] mat3 = {"*..", "X.X", "..M"};
        System.out.println(countLuck(mat3, 1));
        System.out.println(forkCount);

    }

    static String countLuck(String[] matrix, int k) {

        int[] ron = {0, 0};
        map = new char[matrix.length][matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            map[i] = matrix[i].toCharArray();
            int m = matrix[i].indexOf("M");
            if (m != -1) {
                ron[ROW] = i;
                ron[COL] = m;
            }
        }

        isChecked = new boolean[map.length][map[0].length];
        find(ron[ROW], ron[COL], 0);


        return (k == forkCount) ? "Impressed" : "Oops!";
    }

    static void find(int row, int col, int fk) {
        if (map[row][col] == '*') {
            forkCount = fk;
            return;
        }
        isChecked[row][col] = true;

        int cnt = 0;
        for (int i = 0; i < DIR.length; i++) {
            int nextRow = row + DIR[i][ROW];
            int nextCol = col + DIR[i][COL];
            try {
                if (map[nextRow][nextCol] != 'X' && !isChecked[nextRow][nextCol]) {
                    cnt++;
                    System.out.println("cnt" + cnt);
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }
        if (cnt > 1) {
            fk++;
        }

        for (int i = 0; i < DIR.length; i++) {
            int nextRow = row + DIR[i][ROW];
            int nextCol = col + DIR[i][COL];
            try {
                if (map[nextRow][nextCol] != 'X' && !isChecked[nextRow][nextCol]) {
                    find(nextRow, nextCol, fk);
                    depth++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

}

