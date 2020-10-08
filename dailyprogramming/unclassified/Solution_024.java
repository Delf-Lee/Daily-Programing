package unclassified;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// programmers 알고리즘 문제 풀이
// 위장
// #해시
// https://programmers.co.kr/learn/courses/30/lessons/42578
public class Solution_024 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] ss : clothes)
            map.put(ss[1], map.containsKey(ss[1]) ? map.get(ss[1]) + 1 : 1);

        Iterator<String> it = map.keySet().iterator();
        int result = 1;
        while (it.hasNext()) result *= map.get(it.next()) + 1;
        return result - 1;
    }
}
