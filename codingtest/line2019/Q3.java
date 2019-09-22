package codingtest.line2019;

import java.util.Scanner;

/**
 * @author delf
 */
public class Q3 {
	private static final int START = 0;
	private static final int END = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		int[][] period = new int[a][2];
		for (int i = 0; i < a; i++) {
			period[i][START] = sc.nextInt();
			period[i][END] = sc.nextInt();
		}

		ToiletManager toiletManager = new ToiletManager();
		for (int i = 0; i < period.length; i++) {
			if (!toiletManager.hasToilet(period[i][START])) {
				toiletManager.increaseMaxToilet();
			}

			toiletManager.enter(period[i][END]);
		}

		System.out.println(toiletManager.getMax());

	}

	static class ToiletManager {
		private static final int MAX_ENTRY = 1000;
		private int max = 1;
		private int now;
		private int[] endTimes = new int[MAX_ENTRY];

		public void enter(int endTime) {
			endTimes[now++] = endTime;
		}

		public void increaseMaxToilet() {
			max++;
		}

		private void outToilet() {
			now--;
		}


		public boolean hasToilet(int startTime) {
			if (max > now) {
				return true;
			}

			if (startTime < getMinEndTimeOfEntry()) {
				return false;
			}

			outToilet();
			return true;
		}

		public int getMax() {
			return max;
		}

		private int getMinEndTimeOfEntry() {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < max; i++) {
				min = Integer.min(endTimes[i], min);
			}
			return min;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(now).append("\n")
					.append(max).append("\n");
			// .append(Arrays.toString(endTimes));
			return sb.toString();
		}
	}

}
