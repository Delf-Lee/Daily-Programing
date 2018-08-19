package DP018;

import DP017.Solution_017;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution_018 {
    private Solution_018 solution = new Solution_018();

    @Test
    public void test1() {
        boolean testCase = solution.solution(new int[]{1, 2, 3, 7, 10}, 7);
        assertEquals(true, testCase);
    }

    @Test
    public void test2() {
        boolean testCase = solution.solution(new int[]{-5, -3, 0, 1}, 0);
        assertEquals(true, testCase);
    }

    @Test
    public void test3() {
        boolean testCase = solution.solution(new int[]{1, 4, 5, 6, 8, 9}, 10);
        assertEquals(false, testCase);
    }
}
