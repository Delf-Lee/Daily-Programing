package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edaily020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read() - '0';
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (1 + i) + (n * (n - 1) + i + 1);
        }
        for (int i = 1; i < n - 1; i++) {
            sum += n * i + 1 + n * (i + 1);
        }
        System.out.println(sum);
    }
}

