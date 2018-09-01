package DP003;

import dailyprogramming.Solution_003;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution_003 {
    public static Solution_003 solution;

    @BeforeClass
    public static void init() {
        solution = new Solution_003();
        System.out.println("DP003 Test start");
    }

    @Test
    public void testSolution_Case_01() {
        int[] testInput = {1, 2, 3, 4, 5};
        int[] testOutput = {120, 60, 40, 30, 24};
        assertArrayEquals(testOutput, solution.getResultArray(testInput));
    }

    @Test
    public void testSolution_Case_02() {
        int[] testInput = {24, 31, 7, 17, 9, 11};
        int[] testOutput = {365211, 282744, 1252152, 515592, 973896, 796824};
        assertArrayEquals(testOutput, solution.getResultArray(testInput));
    }

    @AfterClass
    public static void end() {
        System.out.println("DP003 Test end");
    }


}