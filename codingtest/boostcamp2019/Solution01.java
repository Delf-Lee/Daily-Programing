package codingtest.boostcamp2019;

import java.util.ArrayList;
import java.util.List;

class Solution01 {
	private final static int PARAM_MAX_VALUE = 100;
	private final static int[] NONE_RESULT = {-1};

	public int[] solution(int[] param) {
		int[] counter = new int[PARAM_MAX_VALUE];
		for (int n : param) {
			counter[n - 1]++;
		}

		List<Integer> result = new ArrayList<>();
		for (int n : counter) {
			if (n > 1) {
				result.add(n);
			}
		}

		if (result.isEmpty()) {
			return NONE_RESULT;
		}

		return result.stream().mapToInt(i->i).toArray();
	}
}

