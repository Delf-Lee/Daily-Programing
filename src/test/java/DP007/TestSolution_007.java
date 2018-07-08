package DP007;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution_007 {

    public static Solution_007 solution;

    @BeforeClass
    public static void init() {
        solution = new Solution_007();
        System.out.println("DP007 Test start");
    }

    @Test
    public void testSolutionCase_01() {
        int arr[] = solution.moveZeroToRight(new int[]{0, 5, 0, 3, -1});
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        assertArrayEquals(new int[]{5, 3, -1, 0, 0}, arr);
    }

    @Test
    public void testSolutionCase_02() {
        int arr[] = solution.moveZeroToRight(new int[]{3, 0, 3});
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        assertArrayEquals(new int[]{3, 3, 0}, arr);
    }

    @Test
    public void testSolutionCase_03() {
        int arr[] = solution.moveZeroToRight(new int[]{4, 7, 5, 0, 2, 0, 3, 2, 7, 1, 3, 7, 6, 0, 4, 0});
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        assertArrayEquals(new int[]{4, 7, 5, 2, 3, 2, 7, 1, 3, 7, 6, 4, 0, 0, 0, 0}, arr);
    }

    @AfterClass
    public static void end() {
        System.out.println("DP007 Test end");
    }
}