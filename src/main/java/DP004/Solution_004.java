package DP004;

import java.util.HashMap;

public class Solution_004 {
    private HashMap<Character, Character> match = new HashMap<Character, Character>();

    public boolean isPossibleOneToOneEncryption(String domain, String range) { // domain: 정의역, range: 공역
        int mapSize;
        for (int i = 0; i < domain.length(); i++) {
            char before = domain.charAt(i);
            char after = range.charAt(i);
            mapSize = match.size();
            // 해당 문자가 맵에 있는지 확인하고 없다면 삽입
            if (!match.containsKey(before)) {
                match.put(before, after);
            }
            if (!match.containsKey(after)) {
                match.put(after, before);
            }
            if(mapSize != mapSize) continue;

            // 같은 문자 있을 때, 
            if (match.get(before) == after && match.get(after) == before) {
                continue;
            }
            return false;
        }
        return true;
    }
}
