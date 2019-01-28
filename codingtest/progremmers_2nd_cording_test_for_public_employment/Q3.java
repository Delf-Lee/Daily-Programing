package codingtest.progremmers_2nd_cording_test_for_public_employment;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author delf
 */
public class Q3 {
    public int solution(int[][] board, int[] nums) {
        int answer = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        boolean checkX = true;
        boolean checkXr = true;
        for (int i = 0; i < board.length; i++) {
            boolean checkR = true;
            boolean checkC = true;
            for (int j = 0; j < board[i].length; j++) {
                boolean isFilledRow = set.contains(board[i][j]);
                boolean isFilledCol = set.contains(board[j][i]);
                checkR &= isFilledRow;
                checkC &= isFilledCol;
                if (i == j) {
                    checkX &= isFilledRow;
                }
                if (i == Math.abs(board.length - 1 - j)) {
                    checkXr &= isFilledRow;
                }
            }
            if (checkR) answer++;
            if (checkC) answer++;
        }
        if (checkX) answer++;
        if (checkXr) answer++;

        return answer;
    }

    public static void main(String[] args) {
        Q3 test = new Q3();
        System.out.println(test.solution(new int[][]{{11, 13, 15, 16}, {12, 1, 4, 3}, {10, 2, 7, 8}, {5, 14, 6, 9}}, new int[]{14, 3, 2, 4, 13, 1, 16, 11, 5, 15}));
    }
}
