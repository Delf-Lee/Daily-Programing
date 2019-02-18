package codingtest.zum;

/**
 * @author delf
 */
public class Q4_AreaCcount {
    class Solution {
        private int[][] map;
        private boolean[][] isChecked;
        private final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int solution(int[][] A) {
            map = A;
            isChecked = new boolean[A.length][A[0].length];

            int result = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (checkArea(i, j)) result++;
                }
            }
            return result;
        }

        private boolean checkArea(int i, int j) {
            if (isChecked[i][j]) return false;
            for (int k = 0; k < DIRECTION.length; k++) {
                int nextC = i + DIRECTION[k][0];
                int nextR = j + DIRECTION[k][1];
                try {
                    if (map[nextC][nextR] == map[i][j]) {
                        isChecked[i][j] = true;
                        checkArea(nextC, nextR);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // 배열의 크기를 넘은 참조는 무시한다.
                    // 무시해도 문제가 없다.
                }
            }
            return true;
        }
    }
}
