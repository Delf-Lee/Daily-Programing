package codingtest.naverhackday2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            map.merge(n, 1, Integer::sum);
        }

        int[] values = new int[6];

        for (int n : map.keySet()) {
            for (int i = 0; i < values.length; i++) {
                if (n == i + 1) {
                    continue;
                }

                if (n == 6 - i) {
                    values[i] += (2 * map.get(n));
                } else {
                    values[i] += map.get(n);
                }
            }
        }
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));
        return values[0];
    }

    public static void main(String[] args) {
        System.out.println(new Q1().solution(new int[]{1, 2, 3}));
        System.out.println(new Q1().solution(new int[]{1, 1, 6}));
        System.out.println(new Q1().solution(new int[]{1, 6, 2, 3}));

    }

}

