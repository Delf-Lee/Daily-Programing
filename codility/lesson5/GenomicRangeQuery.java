package codility.lesson5;

/**
 * @author delf
 */
public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int[] answer = new int[P.length];

        int[] nuA = new int[S.length()];
        int[] nuC = new int[S.length()];
        int[] nuG = new int[S.length()];

        switch (S.charAt(0)) {
            case 'A':
                nuA[0]++;
                break;
            case 'C':
                nuA[0]++;
                break;
            case 'G':
                nuA[0]++;
                break;
        }

        for (int i = 1; i < S.length(); i++)
            switch (S.charAt(i)) {
                case 'A':
                    nuA[i] = nuA[i - 1] + 1;
                    nuC[i] = nuC[i - 1];
                    nuG[i] = nuG[i - 1];
                    break;
                case 'C':
                    nuA[i] = nuA[i - 1];
                    nuC[i] = nuC[i - 1] + 1;
                    nuG[i] = nuG[i - 1];
                    break;
                case 'G':
                    nuA[i] = nuA[i - 1];
                    nuC[i] = nuC[i - 1];
                    nuG[i] = nuG[i - 1] + 1;
                    break;
                default:
                    nuA[i] = nuA[i - 1];
                    nuC[i] = nuC[i - 1];
                    nuG[i] = nuG[i - 1];
                    break;
            }


        for (int i = 0; i < P.length; i++) {
            if (P[i] > 0) {
                if (nuA[Q[i]] > nuA[P[i] - 1]) {
                    answer[i] = 1;
                } else if (nuC[Q[i]] > nuC[P[i] - 1]) {
                    answer[i] = 2;
                } else if (nuG[Q[i]] > nuG[P[i] - 1]) {
                    answer[i] = 3;
                } else {
                    answer[i] = 4;
                }
            } else {
                if (nuA[Q[i]] > 0) {
                    answer[i] = 1;
                } else if (nuC[Q[i]] > 0) {
                    answer[i] = 2;
                } else if (nuG[Q[i]] > 0) {
                    answer[i] = 3;
                } else {
                    answer[i] = 4;
                }
            }
        }
        return answer;
    }
}
