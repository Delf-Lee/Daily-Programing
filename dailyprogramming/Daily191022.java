package dailyprogramming;

import java.util.Arrays;

// 원소가 0, 1, 2로 구성된 배열이 주어졌을 때, 상수 공간을 이용해 선형 시간에 배열을 정렬하시오.
public class Daily191022 {
	public int[] solution(int[] arr) {
		int[] counter = new int[3];

		for (int n : arr) {
			counter[n]++;
		}

		for (int i = 0; i < arr.length; i++) { // O(n)
			for (int j = 0; j < counter.length; j++) { // O(3)
				if (counter[j] != 0) {
					arr[i] = j;
					counter[j]--;
					break;
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Daily191022().solution(new int[]{0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0})));
	}
}
