package codingtest.line2019;

import java.util.Scanner;

/**
 * @author delf
 */
public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int fieldX = sc.nextInt();
		int fieldY = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();

		if (isOutOfField(fieldX, fieldY, x, y)) {
			System.out.println("fail");
			return;
		}

		System.out.println(getShortestDistance(x, y));
		System.out.println(getCaseOfNumberShortestDistance(x, y));

	}

	public static boolean isOutOfField(int fieldX, int fieldY, int x, int y) {
		if (x < 0 || y < 0) {
			return true;
		}

		if (x > fieldX || y > fieldY) {
			return true;
		}

		return false;
	}

	public static int getShortestDistance(int width, int height) {
		return width + height;
	}

	/**
	 * actual logic -> factorial(width + height) / factorial(width) * factorial(height)
	 */
	public static int getCaseOfNumberShortestDistance(int width, int height) {

		int result = 1;
		int bigger = Math.max(width, height);

		for (int i = (width + height); i > bigger; i--) {
			result *= i;
		}

		int smaller = Math.min(width, height);
		int tmp = 1;
		for (int i = 1; i <= smaller; i++) {
			tmp *= i;
		}
		return result / tmp;
	}
}
