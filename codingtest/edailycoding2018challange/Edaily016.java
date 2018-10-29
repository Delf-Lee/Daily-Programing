package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Edaily016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Queue<Character> q = new LinkedList<>();
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (input[i].equals("0")) {
                zero++;
            }
            q.add(input[i].charAt(0));
        }
        if (zero < 2) {
            System.out.println(-1);
            return;
        }

        int res;
        while (true) {
            int sum = 0;
            while (!q.isEmpty()) {
                sum += q.remove() - '0';
            }
            String s = Integer.toString(sum);
            if (s.length() == 1) {
                res = Integer.parseInt(s);
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                q.add(s.charAt(i));
            }
        }

        if (res % 3 == 0) {
            Arrays.sort(input, Collections.reverseOrder());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
