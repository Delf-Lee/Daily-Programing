package hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * @author delf
 */
public class SockMerchant {
    public static void main(String[] args) {
        System.out.println(sockMerchant(7, new int[]{1, 2, 1, 2, 1, 3, 2}));
    }

    static int sockMerchant(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int s : arr) {
            if (!set.contains(s)) {
                set.add(s);
            } else {
                set.remove(s);
                res++;
            }
        }
        return res;
    }
}

