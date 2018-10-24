package backjoon;

import Temporary.ObjectSizeFetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/12866
// 피노키오
public class Q12866 {
    public static void main(String[] args) throws IOException {
        long div = 1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        Map<Character, Long> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c) ? 1L : map.get(c) + 1);
        }

        if (map.size() < 4) {
            System.out.println(0);
            return;
        }
        long res = 1;
        for (Character i : map.keySet()) {
            res = (res * map.get(i)) % div;
        }
        System.out.println(res);
    }
}