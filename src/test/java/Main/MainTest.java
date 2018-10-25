package Main;

import _workspace.Main;
import backjoon.Q12907;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    static Q12907 main = new Q12907();

    @Test
    public void test1() {
        assertEquals(0, main.solution(new int[]{0, 0, 0, 0, 0}));
        System.out.println();
        assertEquals(8, main.solution(new int[]{1, 0, 1, 0, 2, 3, 4, 5, 6}));
        System.out.println();
        assertEquals(2, main.solution(new int[]{0, 1, 2, 3, 4}));
        System.out.println();

        assertEquals(32, main.solution(new int[]{0, 0, 1, 1, 2, 3, 2, 3}));
        System.out.println();
    }

    @Test
    public void test2() {
        assertEquals(32, main.solution(new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 5}));
    }

    @Test
    public void test3() {
        assertEquals(2, main.solution(new int[]{0}));
        assertEquals(2, main.solution(new int[]{0, 1}));
        assertEquals(0, main.solution(new int[]{0, 0, 0}));
    }
}
