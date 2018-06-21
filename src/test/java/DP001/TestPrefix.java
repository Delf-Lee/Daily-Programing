package DP001;

import DP001.Prefix;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPrefix {
    public static Prefix dp001;
    @BeforeClass
    public static void init() {
        dp001 = new Prefix();
    }

    @Test
    public void testPrifix_dog() {
        String[] words = {"dog", "dogs", "doge"};
        assertEquals(dp001.getPrefix(words), "dog");
    }

    @Test
    public void testProfix_ap() {
        String[] words = {"apple", "app", "ape"};
        assertEquals(dp001.getPrefix(words), "ap");
    }

    @Test
    public void testProfix_nothing() {
        String[] words = {"abc", "bcd", "cdef"};
        assertEquals(dp001.getPrefix(words), "");
    }

    @Test
    public void testProfix_ha() {
        String[] words = {"hawaii", "happy"};
        assertEquals(dp001.getPrefix(words), "ha");
    }




}
