import java.util.*;

public class Solution42747 {
    public int solution(int[] citations) {

        Arrays.sort(citations);

        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            if (!isHIndex(citations, i)) {
                continue;
            }

            max = citations[i];
            for (int j = citations[i] - 1; i > 1 && j > citations[i - 1]; j--) {
                if (isHIndex(citations, j)) {
                    max = Math.max(max, citations[j]);
                }
            }
        }
        return max;
    }

    private boolean isHIndex(int[] citations, int n) {
        return citations[n] <= citations.length - n && citations[n] >= n;
    }

    public static void main(String[] args) {
        System.out.println(">>>" + new Solution42747().solution(new int[]{3, 0, 6, 1, 5, 2}));
    }
}
