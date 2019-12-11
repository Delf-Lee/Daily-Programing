package codingtest.kakao2019;

import java.util.*;

/**
 * @author delf
 */
public class Q3 {
	private Map<Character, TrieNode<Character>> roots = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Q3().solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
	}

	public int[] solution(String[] words, String[] queries) {

		for (String word : words) {
			// TrieNode<Character> root =
		}

		return null;
	}

	private TrieNode<Character> createTrie(String word) {
		char first = word.charAt(0);
		TrieNode<Character> root = roots.putIfAbsent(first, new TrieNode<>(first));
		roots.computeIfAbsent(first, TrieNode::new);

		for (int i = 1; i < word.length(); i++) {
			// tmp
		}
		return root;
	}

	static class TrieNode<E> {
		private E e;
		private long height;
		private TrieNode parent;
		private Set<TrieNode> children;

		public TrieNode(E e) {
			this.e = e;
		}

		private long getChildrenHeight() {
			return height + 1;
		}

		private void setParent(TrieNode<E> parent) {
			this.parent = parent;
			this.height = parent.getChildrenHeight();
		}

		private E getElement() {
			return e;
		}

		public void addChild(TrieNode<E> child) {
			child.setParent(this);
			children.add(child);
		}

		@Override
		public boolean equals(Object obj) {
			return this.getElement().equals(obj);
		}

		public boolean hasParent(E e) {
			return children.contains(e);
		}
	}
}
