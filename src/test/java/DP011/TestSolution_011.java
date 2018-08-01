package DP011;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution_011 {
    public static Solution_011 solution;

    @BeforeClass
    public static void init() {
        System.out.println("DP011 Test start");
        solution = new Solution_011();
    }

    @Test
    public void testSolutionCase_01() {
        int[] res = solution.solution(new int[]{2, 5, 6, 1, 10}, 8);
        System.out.println(res[0] + ", " + res[1]);
        assertArrayEquals(new int[]{0, 2}, res);
    }

    @Test
    public void testSolutionCase_02() {
        int[] res = solution.solution(new int[]{1, 5, 8, 2, 9, 10, -1}, 14);
        System.out.println(res[0] + ", " + res[1]);
        assertArrayEquals(new int[]{1, 4}, res);
    }

    @AfterClass
    public static void end() {
        System.out.println("DP011 Test end");
    }

}