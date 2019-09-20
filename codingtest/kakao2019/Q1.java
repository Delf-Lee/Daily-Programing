package codingtest.kakao2019;

/**
 * @author delf
 */
public class Q1 {

	public int solution(String s) {
		int minLength = s.length();
		for (int i = 1; i <= s.length(); i++) {
			minLength = Math.min(minLength, findCompressStrLength(s, i));
		}
		System.out.println(minLength);
		return minLength;
	}

	private int findCompressStrLength(String s, int cutLength) {
		System.out.println("!!" + s.length() + " + " + cutLength);
		int length = 0;
		for (int i = 0; i <= s.length() - cutLength; i += cutLength) {
			String repeatSection = s.substring(i, (i + cutLength) > s.length() ? s.length() : (i + cutLength));
			int cnt = countContinueStrEqual(s, repeatSection, i + cutLength);
			i += cutLength;
			length += (resultLength(cnt) + cutLength);
			System.out.println(repeatSection + " ::" + length);
		}
		System.out.println(length);
		return length;
	}

	private int countContinueStrEqual(String s, String repeatSection, int startIdx) {
		int cnt = 0;
		int length = repeatSection.length();
		for (int i = startIdx; i < s.length(); i += length) {
			/*// System.out.println(i + " - " + (i + length));
			if (i + length > s.length()) {
				continue;
			}*/
			if (!s.substring(i, (i + length) > s.length() ? s.length() : i + length).equals(repeatSection)) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	private int resultLength(int length) {
		return length == 0 ? 0 : (int) Math.log10(length) + 1;
	}

	public static void main(String[] args) {
		// new Q1().test();
		/*System.out.println("## 001");
		if (new Q1().solution("aabbaccc") != 7) {
			System.out.println("not 7");
		}
		System.out.println("## 002");
		if (new Q1().solution("ababcdcdababcdcd") != 9) {
			System.out.println("not 9");
		}*/
		System.out.println("## 003");
		if (new Q1().solution("abcabcdede") != 8) {
			System.out.println("not 8");
		}
		System.out.println("## 004");
		if (new Q1().solution("abcabcabcabcdededededede") != 14) {
			System.out.println("not 14");
		}
		/*System.out.println("## 005");
		if (new Q1().solution("xababcdcdababcdcd") != 17) {
			System.out.println("not 17");
		}*/
	}

	private void test() {
		findCompressStrLength("aabbaccc", 2);
	}


}
