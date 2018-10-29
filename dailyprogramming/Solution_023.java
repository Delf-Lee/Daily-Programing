package dailyprogramming;

import java.util.HashSet;
import java.util.Set;

// programmers 알고리즘 문제 풀이
// 전화번호부
// #해시
// https://programmers.co.kr/learn/courses/30/lessons/42577
public class Solution_023 {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>();
        for (String s : phoneBook) set.add(s);

        for (String s : phoneBook)
            for (int i = 0; i < s.length(); i++)
                if (set.contains(s.substring(0, i)))
                    return false;
        return true;
    }
}
