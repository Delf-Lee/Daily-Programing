package dailyprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edaily003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sumSubject = new int[3];
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int n = Integer.parseInt(s[j]);
                System.out.print(n + " ");
                sum += n;
                sumSubject[j] += n;
            }
            System.out.println(sum);
        }
        int total = 0;
        for (int i : sumSubject) {
            System.out.print(i + " ");
            total += i;
        }
        System.out.println(total);
    }
}