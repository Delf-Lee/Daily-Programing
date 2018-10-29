package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Edaily013 {
    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m1 = 1, m2 = 1;
        for (int i = 0; i < input[0] - input[1]; i++) {
            m1 *= input[0] - i;
            m2 *= i + 1;
        }
        System.out.println(m1 / m2);
    }
}
