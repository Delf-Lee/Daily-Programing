package DP008;

import dailyprogramming.Solution_008;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestSolution_008 {

    public static Solution_008 solution;

    @BeforeClass
    public static void init() {
        solution = new Solution_008();
        System.out.println("DP008 Test start");
    }

    @Test
    public void testSolutionCase_01() {
        String str = solution.getReverseWord("abc 123 apple");
        assertEquals("cba 321 elppa", str);
    }

    @Test
    public void testSolutionCase_02() {
        String str = solution.getReverseWord("show me the money");
        assertEquals("wohs em eht yenom", str);
    }

    @AfterClass
    public static void end() {
        System.out.println("DP008 Test end");
    }
}