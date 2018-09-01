package dailyprogramming;

import java.util.HashMap;

public class Solution_004 {
    private HashMap<Character, Character> match = new HashMap<Character, Character>();

    public boolean isPossibleOneToOneEncryption(String domain, String range) { // domain: 정의역, range: 공역
        for (int i = 0; i < domain.length(); i++) {
            char before = domain.charAt(i);
            char after = range.charAt(i);

            if (match.containsKey(before)) {
                if (match.get(before) != after) return false;
            }
            match.put(before, after);

            if (match.containsKey(after)) {
                if (match.get(after) != before) return false;
            }
            match.put(after, before);
        }
        return true;
    }
}