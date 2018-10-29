package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edaily014 {
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());
        boolean isPrime = true;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? 1 : 0);
    }
}
