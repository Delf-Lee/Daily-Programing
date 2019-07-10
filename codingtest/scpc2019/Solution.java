package codingtest.scpc2019;

import java.util.*;

class Solution {

	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String args[]) throws Exception {
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		Map<Integer, Integer> map = new HashMap<>();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			int answer = 0;
			for (int j = end; j >= start; j--) {
				int depth = 0;
				int n = j;
				if (map.containsKey(n)) {
					answer += map.get(n);
					continue;
				}

				while (n != 1) {
					if (n % 2 == 0) {
						n /= 2;
						depth++;
					} else {
						n = (n + 1) / 2;
						depth += 2;
					}
				}
				map.merge(j, depth, Integer::sum);
				answer += depth;
			}
			System.out.println("Case #" + (i + 1));
			System.out.println(answer);
		}
	}

}

