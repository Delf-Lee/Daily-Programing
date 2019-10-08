package codingtest.nhn2019;

import java.util.*;

/**
 * @author delf
 */
public class Q2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] command = new String[n];
		for (int i = 0; i < n; i++) {
			command[i] = scanner.nextLine();
		}

		FQ fq = new FQ();
		for (int i = 0; i < command.length; i++) {
			String[] split = command[i].split(" ");
			if (split[0].equals("enqueue")) {
				fq.enq(Integer.parseInt(split[1]));
			} else {
				System.out.println(fq.deq());
			}
		}

	}

	static class FQ {
		private Map<Integer, Integer> freqInfo = new HashMap<>();
		private List<Integer> data = new ArrayList<>();
		private int max = Integer.MIN_VALUE;

		public void enq(int n) {
			int freq = freqInfo.merge(n, 1, Integer::sum);
			max = Math.max(freq, max);
			data.add(n);
		}

		public int deq() {
			if (data.isEmpty()) {
				return -1;
			}

			if (isUniqueMax()) {
				int key = getKeyByValue(max);
				remove(key);
				max--;
				return key;
			}

			for (int n : data) {
				if (freqInfo.get(n) == max) {
					remove(n);
					return n;
				}
			}

			throw new RuntimeException();
		}

		private void remove(int n) {
			freqInfo.merge(n, -1, Integer::sum);
			data.remove(Integer.valueOf(n));
		}

		private boolean isUniqueMax() {
			int maxCnt = 0;
			for (int n : freqInfo.keySet()) {
				maxCnt += (freqInfo.get(n) == max ? 1 : 0);
			}

			return maxCnt == 1;
		}

		private int getKeyByValue(int value) {
			for (int n : freqInfo.keySet()) {
				if (freqInfo.get(n) == value) return n;
			}
			throw new RuntimeException();
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}


}
