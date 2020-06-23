import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B, int N) {
        int[] cities = new int[N];
        int maxTunnel = 0;
        for (int i = 0; i < A.length; i++) {
            cities[A[i] - 1]++;
            cities[B[i] - 1]++;

            maxTunnel = Math.max(cities[A[i] - 1], maxTunnel);
            maxTunnel = Math.max(cities[B[i] - 1], maxTunnel);
        }
        System.out.println(Arrays.toString(cities));
        int result = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] == maxTunnel) {
                for (int j = 0; j < A.length; j++) {
                    if (A[j] == i || B[j] == i) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
