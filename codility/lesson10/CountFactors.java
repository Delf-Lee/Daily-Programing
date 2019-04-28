package codility.lesson10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author delf
 */
public class CountFactors {

    public int solution(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        int limit = N / 2;
        for (int i = 2; i < limit; i++) {
            while ((N % i) == 0) {
                N /= i;
                map.merge(i, 1, Integer::sum);
            }
        }

        int result = 1;
        for (int key : map.keySet()) {
            result *= (map.get(key) + 1);
        }

        System.out.println(map);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountFactors().solution(3_628_800));
    }
}

/* public int solution(int num) {
        int[] arr = new int[num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int limit = (int) Math.sqrt(arr.length);
        for (int i = 2; i < limit; i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0)
                System.out.println(arr[i]);

        }
        return 0;
    }*/