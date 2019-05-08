package codility.lession11;

import java.util.Arrays;

/**
 * @author delf
 */
public class CountSemiPrime {
    public static void main(String[] args) {

        int[] prime = prime();
        System.out.println(Arrays.toString(prime));

    }

    public static int[] prime() {
        final int MAX = 1000;
        int[] prime = new int[MAX];
        int pn = 0;
        boolean[] check = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            if (!check[i]) {
                prime[pn++] = i;
                for (int j = i + i; j <= MAX; j += i) {
                    check[j] = true;
                }
            }
        }
        return prime;
    }
}
