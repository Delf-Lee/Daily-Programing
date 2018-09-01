package DP013;

import dailyprogramming.Solution_013;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution_013 {
    public static Solution_013 solution;

    @BeforeClass
    public static void init() {
        System.out.println("DP013 Test start");
        solution = new Solution_013();
    }

    @Test
    public void testSolutionCase_01() {
        String clearText = solution.getClearText("HaEaLaLaObWORLDb"); //
        assertEquals("HELLO WORLD", clearText);

        clearText = solution.getClearText("SpIpGpOpNpGJqOqA");
        assertEquals("SIGONG JOA", clearText);

        clearText = solution.getClearText("AxAxAxAoBoBoB");
        assertEquals("invalid", clearText);

        clearText = solution.getClearText("aAcBcCa");
        assertEquals("ABC", clearText);
    }

    @AfterClass
    public static void end() {
        System.out.println("DP013 Test end");
    }
}
