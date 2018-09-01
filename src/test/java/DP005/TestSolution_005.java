package DP005;

import dailyprogramming.Solution_005;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution_005 {
    public static Solution_005 solution;
    @BeforeClass
    public static void init() {
        System.out.println("DP005 Test start");
    }

    @Before
    public void initTest() {
        solution = new Solution_005();
    }

    @Test
    public void testSolutionCase_01() {
        String subString = solution.getNotLongestSubStringWithoutDuplicate("aabcbcbc");
        System.out.println("test 01: " + subString);
        assertEquals("abc", subString);
    }

    @Test
    public void testSolutionCase_02() {
        String subString = solution.getNotLongestSubStringWithoutDuplicate("aaaaaaaa");
        System.out.println("test 02: " + subString);
        assertEquals("a", subString);
    }

    @Test
    public void testSolutionCase_03() {
        String subString = solution.getNotLongestSubStringWithoutDuplicate("abbbcedd");
        System.out.println("test 03: " + subString);
        assertEquals("bced", subString);
    }

    @Test
    public void testSolutionCase_04() {
        String subString = solution.getNotLongestSubStringWithoutDuplicate("abbfbabaabfggababgbagfa");
        System.out.println("test 04: " + subString);
        assertEquals("abfg", subString);
    }

    @AfterClass
    public static void end() {
        System.out.println("DP005 Test end");
    }
}
