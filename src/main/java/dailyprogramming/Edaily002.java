package dailyprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edaily002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = (int) Math.pow(2, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < e; i++) {
            sb.append(String.format("%0" + n + "d\n", Integer.parseInt(Integer.toBinaryString(i))));
        }
        System.out.println(sb.toString());
    }
}
