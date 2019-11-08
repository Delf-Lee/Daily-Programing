package codingtest.kakao2019;

import java.util.Stack;

/**
 * @author delf
 */
public class Q2 {
	public String solution(String p) {
		if (p.isEmpty()) {
			return "";
		}

		if(isCorrectBracketString(p)) {
			return p;
		}

		return getCorrectBracketString(p);
	}

	private String getCorrectBracketString(String s) {
		if (s.isEmpty()) {
			return s;
		}

		String u = getMinRegularBracketString(s);
		String v = s.substring(u.length());

		if (isCorrectBracketString(u)) {
			return u + getCorrectBracketString(v);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("(")
				.append(getCorrectBracketString(v))
				.append(")")
				.append(deleteBothEndsAndReverseBracket(u));

		return sb.toString();
	}

	private String getMinRegularBracketString(String s) {
		for (int i = 1; i < s.length(); i++) {
			String subString = s.substring(0, i);
			if (isRegularBracketString(s.substring(0, i))) {
				return subString;
			}
		}
		return s;
	}

	private String deleteBothEndsAndReverseBracket(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length() - 1; i++) {
			sb.append(s.charAt(i) == '(' ? ')' : '(');
		}
		return sb.toString();
	}

	private boolean isRegularBracketString(String s) {
		int cnt = 0;
		for (char ch : s.toCharArray()) {
			cnt += (ch == '(' ? 1 : -1);
		}
		return cnt == 0;
	}


	private boolean isCorrectBracketString(String s) {
		if (s.isEmpty()) {
			return false;
		}

		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		if (!stack.peek().equals('(')) {
			return false;
		}

		for (int i = 1; i < s.length(); i++) {
			char now = s.charAt(i);
			if (now == '(') {
				stack.push(s.charAt(i));
				continue;
			}

			if (stack.empty()) {
				return false;
			}

			if (stack.pop() == now) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println(new Q2().deleteBothEndsAndReverseBracket("((())"));
		// System.out.println(new Q2().isRegularBracketString("(())"));

//		System.out.println(new Q2().solution("(()())()"));
//		System.out.println(new Q2().solution(")("));
		System.out.println(new Q2().solution("()))((()"));

//		 System.out.println(new Q2().isCorrectBracketString("(()())()"));
	}
}
