package _workspace.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author delf
 */

// https://www.hackerrank.com/challenges/strong-password/problem
public class StrongPassword {
    private static List<Set<Character>> checker = new ArrayList<>();

    static {
        Set<Character> digitChecker = new HashSet();
        for (int i = 0; i <= 9; i++) digitChecker.add((char) ('0' + i));
        checker.add(digitChecker);

        Set<Character> uppercaseChecker = new HashSet<>();
        for (int i = 0; i < 26; i++) uppercaseChecker.add((char) ('A' + i));
        checker.add(uppercaseChecker);

        Set<Character> lowerChecker = new HashSet<>();
        for (int i = 0; i < 26; i++) lowerChecker.add((char) ('a' + i));
        checker.add(lowerChecker);

        Set<Character> spChecker = new HashSet<>();
        char[] sp = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};
        for (char c : sp) spChecker.add(c);
        checker.add(spChecker);

    }

    static int minimumNumber(int n, String password) {
        int result = checker.size();
        boolean[] conditions = new boolean[checker.size()];
        for (char c : password.toCharArray()) {
            for (int i = 0; i < checker.size(); i++) {
                if (!conditions[i] && checker.get(i).contains(c)) {
                    conditions[i] = true;
                    result--;
                    break;
                }
            }
        }
        int deficientLength = (n < 6) ? 6 - n : 0;
        return deficientLength < result ? result : deficientLength;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumber(11, "#HackerRank"));
        System.out.println(minimumNumber(4, "4600"));
        System.out.println(minimumNumber(2, "+)"));
    }
}

    /*Its length is at least .
        It contains at least one digit.
        It contains at least one lowercase English character.
        It contains at least one uppercase English character.
        It contains at least one special character. The special characters are: !@#$%^&*()-+*/
