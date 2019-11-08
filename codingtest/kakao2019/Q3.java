package codingtest.kakao2019;

import java.util.*;

/**
 * @author delf
 */
public class Q3 {
	public static void main(String[] args) {
		String word = "???for";
		System.out.println(word.lastIndexOf('?'));
		System.out.println(word.substring(word.lastIndexOf('?') + 1));

	}

	public int[] solution(String[] words, String[] queries) {
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Set<String>> matcher = createMatcher(words);
		for (String query : queries) {
			if (!matcher.containsKey(query.length())) {
				continue;
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	private int findWords(String query, Set<String> dictionary) {
		int result = 0;
		for (String word : dictionary) {
			getCore(word);
		}

		return result;
	}

	private String getCore(String query) {
		if (query.charAt(0) != '?') {
			return query.substring(0, query.indexOf('?'));
		}
		return query.substring(query.lastIndexOf('?') + 1);
	}

	private Map<Integer, Set<String>> createMatcher(String[] words) {
		Map<Integer, Set<String>> matcher = new HashMap<>();
		for (String word : words) {
			if (!matcher.containsKey(word.length())) {
				matcher.put(word.length(), new HashSet<>(Collections.singletonList(word)));
			}
			matcher.get(word.length()).add(word);
		}
		return matcher;
	}

}
