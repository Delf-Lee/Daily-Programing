package codingtest.line2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author delf
 */
public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int[] msgProcessTimes = new int[a];
		for (int i = 0; i < a; i++) {
			msgProcessTimes[i] = sc.nextInt();
		}
		
		int[] consumersProcessTimeCount = new int[b];

		for (int i = 0; i < msgProcessTimes.length; i++) {
			int minIdx = getIndexOfMinValue(consumersProcessTimeCount);
			consumersProcessTimeCount[minIdx] += msgProcessTimes[i];
		}

		System.out.println(Arrays.stream(consumersProcessTimeCount).max().getAsInt());
	}


	public static int getIndexOfMinValue(int[] array) {
		int minValue = Integer.MAX_VALUE;
		int minIndex = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if (minValue > array[i]) {
				minValue = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
