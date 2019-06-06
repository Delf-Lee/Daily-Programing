package codility.lesson11;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class CountNonDivisible {
    // https://app.codility.com/demo/results/trainingXWMWST-JVN/
    public int[] solution(int[] A) {
        Map<Integer, Integer> numberCounter = new HashMap<>();
        for (int n : A) {
            numberCounter.merge(n, 1, Integer::sum);
        }

        Map<Integer, Integer> nonDivisibleCounter = new HashMap<>();
        for (Iterator<Integer> it = numberCounter.keySet().iterator(); it.hasNext(); ) {
            int next = it.next();
            nonDivisibleCounter.merge(next, getCountNonDivisible(next, numberCounter), Integer::sum);
        }

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = nonDivisibleCounter.getOrDefault(A[i], 0);
        }
        return result;
    }

    private int getCountNonDivisible(int n, Map<Integer, Integer> map) {
        int count = 0;
        for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext(); ) {
            int next = it.next();
            if (map.containsKey(next) && n % next != 0) {
                count += map.get(next);
            }
        }
        return count;
    }
    /*public int[] solution(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                if(A[i] % A[j] != 0) {
                    result[i]++;
                }
            }
        }
        return result;
    }*/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountNonDivisible().solution(new int[]{3, 1, 2, 3, 6})));
    }
}

