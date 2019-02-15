package codility.lesson5;

import java.util.Arrays;

/**
 * @author delf
 */
public class GenomicRangeQuery {
    private int plus(char c, int n) {
        switch (c) {
            case 'A':
                return n == 0 ? 1 : 0;
            case 'C':
                return n == 1 ? 1 : 0;
            case 'G':
                return n == 2 ? 1 : 0;
        }
        return 0;
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int[] answer = new int[P.length];
        int[][] nucleotides = new int[3][S.length() + 1];

        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 0; j < nucleotides.length; j++) {
                nucleotides[j][i] = nucleotides[j][i - 1] + plus(S.charAt(i - 1), j);
            }
        }

        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;
            for (int j = 0; j < nucleotides.length; j++) {
                if (nucleotides[j][end] > nucleotides[j][start]) {
                    answer[i] = j + 1;
                    break;
                } else {
                    answer[i] = 4;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GenomicRangeQuery().solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        // System.out.println(Arrays.toString(new GenomicRangeQuery().solution("A", new int[]{0}, new int[]{0})));
    }

}
