package backjoon;

import java.io.*;
import java.util.*;
import java.util.regex.*;

// https://www.acmicpc.net/problem/10820
public class Q10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int[] cnt = new int[4];
        String[] regExp = {"[a-z]", "[A-Z]", "[0-9]", "\\s"};
        String input;
        while ((input = br.readLine()) != null) {
            for (int j = 0; j < 4; j++) {
                Pattern p = Pattern.compile(regExp[j]);
                Matcher m = p.matcher(input);
                while (m.find()) cnt[j]++;
                result.append(cnt[j] + " ");
            }
            System.out.println(result);
            result.delete(0, result.length());
            Arrays.fill(cnt, 0);
        }
    }
}