package dailyprogramming;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution_001 {
    public static Solution_001 solution;
    @BeforeClass
    public static void init() {
        solution = new Solution_001();
    }

    @Test
    public void testPrifix_dog() {
        String[] words = {"dog", "dogs", "doge"};
        assertEquals("dog", solution.getPrefix(words));
    }

    @Test
    public void testProfix_ap() {
        String[] words = {"apple", "app", "ape"};
        assertEquals("ap", solution.getPrefix(words));
    }

    @Test
    // 아무것도 겹치지 않을 시 테스트
    public void testProfix_nothing() {
        String[] words = {"abc", "bcd", "cdef"};
        assertEquals("", solution.getPrefix(words));
    }

    @Test
    public void testProfix_ha() {
        String[] words = {"hawaii", "happy"};
        assertEquals("ha", solution.getPrefix(words));
    }
}
