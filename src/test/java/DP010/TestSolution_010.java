package DP010;

import dailyprogramming.Solution_010;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestSolution_010 {
    public static Solution_010 solution;

    @BeforeClass
    public static void init() {
        System.out.println("DP010 Test start");
    }

    @Before
    public void initTest() {
        System.out.println("testinit");
        solution = new Solution_010();
    }

    @Test
    public void testSolutionCase_01() {
        int[][] map = {{1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1}};
        assertEquals(8, solution.getShortestDistance(map, new int[]{0, 0}, new int[]{0, 4}));

    }

    @Test
    public void testSolutionCase_02() {
        int[][] map = {{1, 0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1}};
        assertEquals(8, solution.getShortestDistance(map, new int[]{2, 3}, new int[]{4, 5}));
    }

    @Test
    public void testSolutionCase_03() {
        int[][] map = {{1, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1, 1}};
        assertEquals(17, solution.getShortestDistance(map, new int[]{0, 0}, new int[]{4, 5}));
    }

    @Test
    public void testSolutionCase_04() {
        int[][] map = new int[100][100];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 1);
        }
        try {
            assertEquals(0, solution.getShortestDistance(map, new int[]{0, 0}, new int[]{4, 5}));
        } catch (StackOverflowError e) {
            System.err.println("Stack overflow error");
            fail();
        }

    }


    @AfterClass
    public static void end() {
        System.out.println("DP010 Test end");
    }
}
