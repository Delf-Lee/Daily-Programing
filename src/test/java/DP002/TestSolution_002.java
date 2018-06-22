package DP002;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution_002 {
    public static Solution_002 solution;

    @BeforeClass
    public static void init() {
        System.out.println("DP002 Test Start");
        solution = new Solution_002();
    }

    @Test
    public void testCase001() {
        int[] nums = {-1, 3, -1, 5, 4};
        int rank = 2;

        int rankedElements = solution.getRankedElementInArray(nums, rank);
        assertEquals(rankedElements, 4);
    }

    @Test
    public void testCase002() {
        int[] nums = {2, 4, -2, -3, 8};
        int rank = 1;

        int rankedElements = solution.getRankedElementInArray(nums, rank);
        assertEquals(rankedElements, 8);
    }

    @Test
    public void testCase003() {
        int[] nums = {-5, -3, 1};
        int rank = 3;

        int rankedElements = solution.getRankedElementInArray(nums, rank);
        assertEquals(rankedElements, -5);
    }

    @AfterClass
    public static void end() {
        System.out.println("DP002 Test End");
    }

}
