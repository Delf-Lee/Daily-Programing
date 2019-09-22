package codingtest.line2019;

import java.util.Scanner;

/**
 * @author delf
 */
public class Q4 {
	private static final String EMPTY = "0";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String seatInput = sc.nextLine();
		String[] seats = seatInput.split(" ");

		int emptySeatCount = 0;
		int maxSerialEmptySeatCount = 0;
		for (String seat : seats) {
			if (!seat.equals(EMPTY)) {
				maxSerialEmptySeatCount = Math.max(emptySeatCount, maxSerialEmptySeatCount);
				emptySeatCount = 0;
			}
			emptySeatCount++;
		}

		System.out.println(maxSerialEmptySeatCount / 2);
	}
}
