package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/10815
// 숫자카드
public class Q10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(s[i]));
        }
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sb.append(set.contains(Integer.parseInt(s[i])) ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}
