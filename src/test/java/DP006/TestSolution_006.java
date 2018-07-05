package DP006;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution_006 {

    public static Solution_006 solution;

    @BeforeClass
    public static void init() {
        solution = new Solution_006();
        System.out.println("DP006 Test start");
    }

    @Test
    public void testSolutionCase_01() {
        String res = solution.getSecondValue(new int[]{10, 5, 4, 3, -1});
        assertEquals("5", res);
    }

    @Test
    public void testSolutionCase_02() {
        String res = solution.getSecondValue(new int[]{3, 3, 3});
        assertEquals("Dose not exist", res);
    }

    @Test
    public void testSolutionCase_03() {
        String res = solution.getSecondValue(new int[]{1, 2, 3, 5, 4});
        assertEquals("4", res);
    }

    @AfterClass
    public static void end() {
        System.out.println("DP006 Test end");
    }
}
