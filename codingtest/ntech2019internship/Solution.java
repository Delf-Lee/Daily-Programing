package codingtest.ntech2019internship;

/**
 * @author delf
 */
public class Solution {
	private boolean[] numberFlags = new boolean[9];
	private long origin;
	private long number;

	public int solution(long n) {
		this.origin = n;
		this.number = origin;

		int flagCnt = 0;
		while (hasNextNumber()) {

			int next = getNextNumber();

			if (isDivided(next)) {
				divide(next);
				flagCnt++;
			}

			if (flagCnt == numberFlags.length) {
				return flagCnt;
			}
		}

		return flagCnt;
	}

	private boolean hasNextNumber() {
		return number >= 1;
	}

	private int getNextNumber() {
		int nextNumber = (int) (number % 10);
		number /= 10;
		return nextNumber;
	}

	private boolean isDivided(int num) {
		if (num == 0) {
			return false;
		}

		if(!numberFlags[num - 1]) {
			return this.origin % num == 0;
		}

		return false;
	}

	private void divide(int num) {
		numberFlags[num - 1] = true;
	}

	public static void main(String[] args) {
		System.out.println("@@" + new Solution().solution(56244));
	}
}
