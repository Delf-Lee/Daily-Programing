package DP017;

import dailyprogramming.Solution_017;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution_017 {

    private Solution_017 solution = new Solution_017();

    @Test

    public void test1() {
        boolean canRotate = solution.solution(new int[]{1, 2, 4, 0, 3});
        assertEquals(true, canRotate);
        canRotate = solution.solution(new int[]{1, 4, 5, 0, 3, 2});
        assertEquals(true, canRotate);
        canRotate = solution.solution(new int[]{1, 2, 2, 0});
        assertEquals(true, canRotate);
    }
}
