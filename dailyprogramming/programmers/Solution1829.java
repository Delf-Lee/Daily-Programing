package programmers;

import java.util.Arrays;

public class Solution1829 {
	private static final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution1829().solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
	}

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int area;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (picture[i][j] == 0) {
					continue;
				}

				area = dfs(i, j, picture[i][j], picture);
				if (maxSizeOfOneArea < area) {
					maxSizeOfOneArea = area;
				}

				numberOfArea++;
			}
		}

		return new int[]{numberOfArea, maxSizeOfOneArea};
	}

	private int dfs(int x, int y, int preColor, int[][] picture) {
		if (picture[x][y] != preColor) {
			return 0;
		}

		picture[x][y] = 0;


		int count = 1;
		for (int i = 0; i < direction.length; i++) {

			int nx = x + direction[i][0];
			int ny = y + direction[i][1];

			if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {
				continue;
			}

			if (picture[nx][ny] == 0 || picture[nx][ny] != preColor) {
				continue;
			}

			count += dfs(x + direction[i][0], y + direction[i][1], preColor, picture);
		}
		return count;
	}
}