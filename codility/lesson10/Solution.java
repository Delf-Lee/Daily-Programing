package codility.lesson10;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author delf
 * 단어 단위 선택하기
 */
public class Solution {

    public int[] solution(int N, int[] P, int[] Q) {
        int n = N / 2;
        int rootSqrt = (int) Math.sqrt(N);
        boolean[] array = new boolean[n + 1];

        for (int i = 2; i <= rootSqrt; i++) {

            if (array[i]) {
                continue;
            }

            for (int j = i + i; j <= n; j += i) {
                array[j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (!array[i] && !array[j]) {
                    list.add(i * j);
                }
            }
        }
        Collections.sort(list);
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                if (P[i] <= list.get(j) && Q[i] >= list.get(j)) {
                    cnt++;
                }
            }
            result[i] = cnt;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20})));
    }
}