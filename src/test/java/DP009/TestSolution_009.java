package DP009;

import dailyprogramming.Solution_009;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSolution_009 {
    public static Solution_009 solution;

    @BeforeClass
    public static void init() {
        System.out.println("DP009 Test start");
    }

    @Before
    public void initTest() {
        System.out.println("testinit");
        solution = new Solution_009();
    }

    @Test
    public void testSolutionCase_01() {
        int[][] input = {{2, 4}, {1, 5}, {7, 9}};
        int[][] res = solution.getMergedInterval(input);
        int[][] expect = {{1, 5}, {7, 9}};
        assertTrue(isEqualsTwoDimensionalArr(res, expect));
    }

    @Test
    public void testSolutionCase_02() {
        int[][] input = {{3, 6}, {1, 3}, {2, 4}};
        int[][] res = solution.getMergedInterval(input);
        int[][] expect = {{1, 6}};
        assertTrue(isEqualsTwoDimensionalArr(res, expect));
    }

    @Test
    public void testSolutionCase_03() {
        int[][] input = {{1, 2}, {2, 3}, {3, 4}};
        int[][] res = solution.getMergedInterval(input);
        int[][] expect = {{1, 4}};
        assertTrue(isEqualsTwoDimensionalArr(res, expect));
    }

    @Test
    public void testSolutionCase_04() {
        int[][] input = {{-1, 0}, {1, 100}, {22, 23}, {3, 6}, {200, 203}};
        int[][] res = solution.getMergedInterval(input);
        int[][] expect = {{-1, 0}, {1, 100}, {200, 203}};
        assertTrue(isEqualsTwoDimensionalArr(res, expect));
    }

    @Test
    public void testSolutionCase_05() {
        int[][] input = {{1, 4}, {8, 10}, {3, 9}};
        int[][] res = solution.getMergedInterval(input);
        int[][] expect = {{1, 10}};
        assertTrue(isEqualsTwoDimensionalArr(res, expect));
    }

    private boolean isEqualsTwoDimensionalArr(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
                if (a[i][j] != b[i][j]) return false;
            }
            System.out.println();
        }
        return true;
    }

    @AfterClass
    public static void end() {
        System.out.println("DP009 Test end");
    }
}
