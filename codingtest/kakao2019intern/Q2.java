package codingtest.kakao2019intern;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author delf
 */
public class Q2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Q2().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
	}

	public int[] solution(String s) {
		List<Set<Integer>> tuples = convertToTuples(s);
		tuples = tuples.stream().sorted(Comparator.comparing(Set::size)).collect(Collectors.toList());

		List<Integer> resultList = new ArrayList<>();
		for (Set<Integer> tuple : tuples) {
			addUniqueElement(resultList, tuple);
		}

		return resultList.stream().mapToInt(i->i).toArray();
	}

	private List<Set<Integer>> convertToTuples(String tupleString) {
		String[] tupleArr = tupleString.trim().split("\\},\\{");
		List<Set<Integer>> result = new ArrayList<>();

		for (String s : tupleArr) {
			Set<Integer> tuple = new HashSet<>();
			String[] elements = s.split(",");
			for (int i = 0; i < elements.length; i++) {
				tuple.add(partInt(elements[i]));
			}
			result.add(tuple);
		}

		return result;
	}

	private void addUniqueElement(List<Integer> result, Set<Integer> set) {
		for (int n : set) {
			if (!result.contains(n)) {
				result.add(n);
			}
		}
	}

	private int partInt(String s) {
		return Integer.parseInt(s.replaceAll("[^0-9]", ""));
	}
}
