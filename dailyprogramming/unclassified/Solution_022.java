package unclassified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// programmers 알고리즘 문제 풀이
// 완주하지 못한 선수
// #해시
// https://programmers.co.kr/learn/courses/30/lessons/42576
public class Solution_022 {
    public String solution(String[] participant, String[] completion) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap();
        for (String s : participant)
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        for (String s : completion) {
            if (map.put(s, map.get(s) - 1) == 1)
                map.remove(s);
        }
        return map.keySet().toArray(new String[1])[0];
    }
}
