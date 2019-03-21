package codility.lesson8;

import java.util.*;

/**
 * @author delf
 */
public class Dominator {
    // https://app.codility.com/demo/results/trainingFJGPHF-2U6/
    public int solution(int[] A) {
        int maxCount = -1;
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int count = (map.get(A[i]) == null) ? 1 : map.get(A[i]) + 1;
            map.put(A[i], count);

            if (count == maxCount) {
                result = -1;
            }
            if (count > maxCount) {
                maxCount = count;
                result = i;
            }
        }

        return maxCount > A.length / 2 ? result : -1;
    }


    public static void main(String[] args) {
        System.out.println(new Dominator().solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        System.out.println(new Dominator().solution(new int[]{2}));
        System.out.println(new Dominator().solution(new int[]{2, 1, 1, 3, 4}));
        System.out.println(new Dominator().solution(new int[]{2147483647}));
    }
}

