package DP012;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution_012 {
    public static Solution_012 solution;

    @BeforeClass
    public static void init() {
        System.out.println("DP012 Test start");
        solution = new Solution_012();
    }

    @Test
    public void testSolutionCase_01() {
        String[] conditions = {"N~F=0", "R~T>2"};
        assertEquals(3648, solution.getCase(conditions));
    }

    @AfterClass
    public static void end() {
        System.out.println("DP012 Test end");
    }
}
