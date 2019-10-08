package codingtest.nhn2019;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author delf
 */
public class Q1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] insects = scanner.nextLine().split(" ");

		int minCardCnt = 1000;

		Map<String, Integer> insectMap = new HashMap<>();
		for (String insect : insects) {
			int cardCnt = insectMap.merge(insect, 1, Integer::sum);
			minCardCnt = Integer.min(cardCnt, minCardCnt);
		}

		int minCnt = 0;
		for (String insect : insectMap.keySet()) {
			if (insectMap.get(insect) != minCardCnt) {
				continue;
			}
			minCnt++;
		}

		if (minCnt == 1) {
			System.out.println("Y");
			System.out.println(n + 1);
		} else if (minCnt == n) {
			System.out.println("Y");
			System.out.println(n);
		} else {
			System.out.println("N");
			System.out.println(n);
		}
		System.out.println(insectMap.keySet().size());
	}
}
