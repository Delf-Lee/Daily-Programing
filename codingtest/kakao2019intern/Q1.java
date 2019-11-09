package codingtest.kakao2019intern;

import java.util.Stack;

/**
 * @author delf
 */
public class Q1 {
	private final static int EMPTY = 0;

	public int solution(int[][] board, int[] moves) {
		int bomb = 0;
		Stack<Integer> bucket = new Stack<>();
		for (int line : moves) {
			int pickedDoll = pickDoll(board, line - 1);

			if (pickedDoll == EMPTY) {
				continue;
			}

			if (!isSameDoll(bucket, pickedDoll)) {
				bucket.push(pickedDoll);
				continue;
			}

			bomb += bombCount(bucket);
		}

		return bomb;
	}

	private int bombCount(Stack<Integer> bucket) {
		bucket.pop();
		return 2;
	}

	private boolean isSameDoll(Stack<Integer> bucket, int pickedDoll) {
		if (bucket.empty()) {
			return false;
		}

		return bucket.peek() == pickedDoll;
	}


	private int pickDoll(int[][] board, int line) {
		for (int i = 0; i < board.length; i++) {
			if (isDoll(board, line, i)) {
				int result = board[i][line];
				board[i][line] = EMPTY;
				return result;
			}
		}
		return EMPTY;
	}

	private boolean isDoll(int[][] board, int line, int depth) {
		return board[depth][line] != EMPTY;
	}


	public static void main(String[] args) {
		System.out.println(new Q1().solution(
				new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 1, 0, 3}, new int[]{0, 2, 5, 0, 1}, new int[]{4, 2, 4, 4, 2}, new int[]{3, 5, 1, 3, 1}},
				new int[]{1, 5, 3, 5, 1, 2, 1, 4})
		);
	}
}


