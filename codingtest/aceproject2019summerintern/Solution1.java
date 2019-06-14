package codingtest.aceproject2019summerintern;

class Solution1 {
	public int solution(int n, int[] v) {
		if (n == 0 || n == 1) {
			return 0;
		}

		int[] accLeft = new int[n + 2];
		int[] accRight = new int[n + 2];

		int before = 0;
		for (int i = 0; i < v.length; i++) {
			accLeft[i + 1] = v[i] + before;
			before = accLeft[i + 1];
		}

		before = 0;
		for (int i = v.length - 1; i >= 0; i--) {
			accRight[i + 1] = v[i] + before;
			before = accRight[i + 1];
		}

		int answer = n - 1;
		int min = Integer.MAX_VALUE;
		for (int i = v.length; i >= 0; i--) {
			int value = Math.abs(accLeft[i] - accRight[i + 1]);
			if (value <= min) {
				min = value;
				answer = Math.min(i, answer);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// System.out.println(new Solution().solution(7, new int[]{3, 2, 3, 4, -1, -2, -3})); //1
		System.out.println(new Solution1().solution(5, new int[]{1, 2, 1, 2, 1})); //2
	}
}