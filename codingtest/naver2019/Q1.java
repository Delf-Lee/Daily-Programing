package codingtest.naver2019;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author delf
 */
public class Q1 {
	private final static String AT = "@";
	private final static Set<String> TOP_LVL_DOMAIN = new HashSet<>(Arrays.asList("com", "org", "net"));

	public int solution(String[] emails) {
		int result = 0;
		for (String email : emails) {
			result += isValidEmail(email) ? 1 : 0;
		}
		return result;
	}

	private boolean isValidEmail(String email) {
		String[] splitEmail = email.split(AT);
		if (splitEmail.length != 2) {
			return false;
		}

		String name = splitEmail[0];
		if (!isValidName(name)) {
			return false;
		}

		String domain = splitEmail[1];
		if (!isValidDomain(domain)) {
			return false;
		}

		return true;
	}

	private boolean isValidName(String name) {
		for (char ch : name.toCharArray()) {
			if (!Character.isAlphabetic(ch) && ch != '.') {
				return false;
			}
		}
		return true;
	}

	private boolean isValidDomain(String domain) {
		String[] splitDomain = domain.split("\\.");
		if (splitDomain.length != 2) {
			return false;
		}

		String topLevelDomain = splitDomain[1];
		return isValidTopLevelDomain(topLevelDomain);
	}

	private boolean isValidTopLevelDomain(String topLevelDomain) {
		return TOP_LVL_DOMAIN.contains(topLevelDomain);
	}

	public static void main(String[] args) {
		System.out.println(new Q1().solution(new String[]{"d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"}));
		System.out.println(new Q1().solution(new String[]{"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"}));

	}
}

// 	규격에 맞는 메일은 이름@도메인이름.탑레벨도메인 형식입니다.
// 		이름은 영문 소문자와 .로만 구성됩니다.
// 		도메인이름은 영문 소문자로만 구성됩니다.
// 		탑레벨도메인은 com, net, org 중 하나입니다.
