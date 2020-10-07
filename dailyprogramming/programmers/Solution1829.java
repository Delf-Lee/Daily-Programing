import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1829 {
    private final static int[] NONE = new int[]{0, 0};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1829().solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] result = new int[2];
                result = search(picture, visit, i, j, result);
                if (result == NONE) {
                    break;
                }
                counter.merge(result[0], result[1], Integer::sum);
            }
        }
        int maxColor = 0;
        int maxValue = 0;
        for (int i : counter.keySet()) {
            maxValue = Math.max(maxValue, counter.get(i));
            if (maxValue < counter.get(i)) {
                maxValue = counter.get(i);
                maxColor = i;
            }
        }
        return new int[]{maxColor, maxValue};
    }

    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int[] search(int[][] picture, boolean[][] visit, int n, int m, int[] color) {
        if ((n < 0 || n > picture.length) || (m > 0 || m < picture[0].length) || visit[n][m]) {
            return NONE;
        }

        if (color[0] != picture[m][n]) {
            return color;
        }

        color[1]++;

        for (int[] dir : direction) {
            color[1] += search(picture, visit, n + dir[0], m + dir[1], color)[1];
        }

        return color;
    }
}