package codingtest.programers2019;

/**
 * @author delf
 */
public class Q2 {
	private final static int CHESS_MAX_LENGTH = 8;
	boolean[][] field = new boolean[CHESS_MAX_LENGTH][CHESS_MAX_LENGTH];

	public int solution(String[] bishops) {
		for (String bishop : bishops) {
			method(field, bishop);
		}


		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if(field[i][j]) {
					System.out.print("O");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
		int cnt = countEmpty(field);

		return cnt;
	}

	private int countEmpty(boolean[][] field) {
		int count = 0;
		for (boolean[] col : field) {
			for (boolean cell : col) {
				if(cell) {
					count++;
				}
			}
		}
		return count;
	}

	private void method(boolean[][] field, String bishop) {
		int col = getCol(bishop);
		int row = getRow(bishop);

		field[col][row] = false;
		for (int i = col - 1; i >= 0; i--) {
			if (isValidBoundary(col - i, row - i)) {
				field[col - i][row - i] = true;
			}

			if (isValidBoundary(col - i, row + i)) {
				field[col - i][row + i] = true;
			}

			if (isValidBoundary(col + i, row - i)) {
				field[col + i][row - i] = true;
			}

			if (isValidBoundary(col + i, row + i)) {
				field[col + i][row + i] = true;
			}
		}
	}

	private boolean isValidBoundary(int col, int row) {
		if (col < 0 || row < 0) {
			return false;
		}

		if (col > CHESS_MAX_LENGTH - 1 || row > CHESS_MAX_LENGTH - 1) {
			return false;
		}

		return true;
	}

	private int getCol(String bishop) {
		return bishop.charAt(0) - 'A';
	}

	private int getRow(String bishop) {
		return CHESS_MAX_LENGTH - Integer.parseInt(String.valueOf(bishop.charAt(1)));
	}

	public static void main(String[] args) {
		System.out.println(new Q2().solution(new String[]{"D5"}));
	}
}
