package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edaily012 {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < n; i++) {
            sb.append(n + i).append(", ");
        }
        System.out.println(sb.replace(sb.length() - 2, sb.length() - 1, "}"));
        // System.out.println(sb.insert(sb.length() - 1, "}").toString());
    }
}
