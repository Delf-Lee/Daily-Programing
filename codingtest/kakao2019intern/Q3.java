package codingtest.kakao2019intern;

import java.util.Arrays;

/**
 * @author delf
 */
public class Q3 {
	public static void main(String[] args) {
		// System.out.println("##" + new Q1().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
		// System.out.println("##" + new Q1().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
		System.out.println("##" + new Q3().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));

//		 System.out.println(new Q1().combination(2,2));

	}

	public int solution(String[] userIds, String[] bannedIds) {
		int answer = 1;
		Arrays.sort(bannedIds);
		/*for (String bannedId : bannedIds) {
			answer *= countCandidate(bannedId, userIds);
			System.out.println();
		}
*/
		int tmp = countCandidate(bannedIds[0], userIds);
		int sameIdCnt = 1;
		for (int i = 0; i < bannedIds.length - 1; i++) {
			if (bannedIds[i].equals(bannedIds[i + 1])) {
				System.out.println("++" + sameIdCnt++);
				continue;
			}

//			System.out.println(tmp + " " + sameIdCnt + " " + combination(tmp, sameIdCnt));
			answer *= combination(tmp, sameIdCnt);
			sameIdCnt = 1;
			// System.out.println(answer);
			tmp = countCandidate(bannedIds[i + 1], userIds);
		}

		return answer * combination(tmp, sameIdCnt);
	}

	private int combination(int n, int r) {
		int answer = 1;
		for (int i = n; i > n - r; i--) {
			answer *= i;
		}

		for (int i = r; i > 1; i--) {
			answer /= i;
		}

		return answer;
	}

	private int countCandidate(String bannedId, String[] userIds) {
		int count = 0;
		for (int i = 0; i < userIds.length; i++) {
			System.out.println(Arrays.toString(userIds));
			if (isApplied(userIds[i])) {
				continue;
			}

			if (!isCandidate(bannedId, userIds[i])) {
				continue;
			}

			count++;
			checkUser(userIds, i);
		}
		return count;
	}

	private boolean isApplied(String userId) {
		return userId == null;
	}

	private void checkUser(String[] userIds, int index) {
		userIds[index] = null;
	}

	private boolean isCandidate(String bannedId, String userId) {
		if (bannedId.length() != userId.length()) {
			return false;
		}

		for (int i = 0; i < bannedId.length(); i++) {
			if (bannedId.charAt(i) == '*') {
				continue;
			}

			if (bannedId.charAt(i) != userId.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}


