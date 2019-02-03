package codility.lesson1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author delf
 */
public class BinaryGap {
    static Set<Integer> set = new HashSet<>();

    static {
        for (int i = 0; i < 32; i++) set.add((int) Math.pow(2, i));
    }

    public int solution(int N) {
        if (set.contains(N)) return 0;

        int max = 0, res = 0;
        boolean flag = false;
        while (N > 0) {
            if (N % 2 == 0) {
                if (flag) max++;
            } else {
                if (!flag) flag = true;
                res = Math.max(max, res);
                max = 0;
            }
            N /= 2;
        }
        return res;
    }
}
