package codingtest.kakao2019;

import java.util.*;

/**
 * @author delf
 */
public class Q3 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Q3().solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
		System.out.println("word".startsWith(""));
	}

	public int[] solution(String[] words, String[] queries) {
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Set<String>> matcher = createMatcher(words);
		for (String query : queries) {
			if (!matcher.containsKey(query.length())) {
				answer.add(0);
				continue;
			}
			answer.add(countWord(query, matcher.get(query.length())));
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	private int countWord(String query, Set<String> dictionary) {
		int result = 0;
		String modified = getWordStartWithAlphabet(query);
		for (String word : dictionary) {
			result += word.startsWith(getCore(modified)) ? 1 : 0;
		}

		return result;
	}

	private String getCore(String query) {
		return query.substring(0, query.indexOf("?"));
	}

	private Map<Integer, Set<String>> createMatcher(String[] words) {
		Map<Integer, Set<String>> matcher = new HashMap<>();
		for (String word : words) {
			String modified = (new StringBuilder(word)).reverse().toString();

			if (!matcher.containsKey(word.length())) {
				matcher.put(word.length(), new HashSet<>(Arrays.asList(word, modified)));
			}

			matcher.get(word.length()).add(modified);
			matcher.get(word.length()).add(word);
		}

		return matcher;
	}

	private String getWordStartWithAlphabet(String word) {
		if (word.startsWith("?")) {
			return (new StringBuilder(word)).reverse().toString();
		}
		return word;
	}

}
