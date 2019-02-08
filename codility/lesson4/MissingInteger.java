package codility.lesson4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author delf
 */
public class MissingInteger {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (i > 0) set.add(i);
        }
        int cnt = 1;
        while (!set.isEmpty()) {
            if (!set.remove(cnt)) break;
            cnt++;
        }
        return cnt;
    }
}
