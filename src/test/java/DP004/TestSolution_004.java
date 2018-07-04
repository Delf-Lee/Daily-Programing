package DP004;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolution_004 {
    public static Solution_004 solution;

    @BeforeClass
    public static void init() {
        System.out.println("DP004 Test start");
    }

    @Before
    public void initMap() {
        solution = new Solution_004();
    }

    @Test
    public void testSolution_Case_01() {
        boolean res = solution.isPossibleOneToOneEncryption("ABBCD","APPLE");
        System.out.println("test 01: " + res);
        assertTrue(res);
    }

    @Test
    public void testSolution_Case_02() {
        boolean res = solution.isPossibleOneToOneEncryption("EGG","FOO");
        System.out.println("test 02: " + res);
        assertTrue(res);
    }

    @Test
    public void testSolution_Case_03() {
        boolean res = solution.isPossibleOneToOneEncryption("AAB","FOO");
        System.out.println("test 03: " + res);
        assertFalse(res);
    }

    @Test
    public void testSolution_Case_04() {
        boolean res = solution.isPossibleOneToOneEncryption("SLWWE","QVFFS");
        System.out.println("test 04: " + res);
        assertFalse(res);
    }

    @AfterClass
    public static void end() {
        System.out.println("DP004 Test end");
    }

}
