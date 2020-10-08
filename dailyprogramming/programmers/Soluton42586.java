package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author delf
 */
public class Soluton42586 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Soluton42586().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
	}

	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		int deployedIdx = 0;
		do {
			for (int i = 0; i < progresses.length; i++) {
				progresses[i] += speeds[i];
			}

			int deployCnt = 0;
			for (int i = deployedIdx; i < progresses.length; i++) {
				if (progresses[i] < 100) {
					break;
				}
				deployCnt++;
				deployedIdx++;
			}
			if (deployCnt != 0) {
				answer.add(deployCnt);
			}
		} while (deployedIdx < progresses.length);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
