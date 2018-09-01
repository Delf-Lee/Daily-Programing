package DP019;

import dailyprogramming.Solution_019;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest_019 {
    private Solution_019 solution = new Solution_019();

    @Test
    public void test01() {

        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, solution.solution(new int[]{1, 2, 3, 4, 5}, 2));

        assertArrayEquals(new int[]{1, 2, 3, 4, 0}, solution.solution(new int[]{0, 1, 2, 3, 4}, 1));
    }
}