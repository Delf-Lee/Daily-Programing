package domain.frame;

public class Q43163 {
    private String[] words;

    public int solution(String begin, String target, String[] words) {
        this.words = words;
        boolean[] isVisit = new boolean[words.length];
        return dfs(begin, target, isVisit, 0);
    }


    private int dfs(String begin, String target, boolean[] isVisit, int depth) {
        if (begin.equals(target)) {
            return depth;
        }

        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (isVisit[i]) {
                continue;
            }

            if (hasNext(begin, words[i])) {
                isVisit[i] = true;
                int tmp = dfs(words[i], target, isVisit, depth + 1);
                isVisit[i] = false;
                min = Math.min(min, tmp);
            }
        }
        System.out.println();
        return min;
    }


    private boolean hasNext(String begin, String target) {
        boolean hasNext = false;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                if (hasNext) {
                    return false;
                }
                hasNext = true;
            }
        }
        return hasNext;
    }

    public static void main(String[] args) {
        System.out.println("답 : " + new Q43163().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println("답 : " + new Q43163().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
