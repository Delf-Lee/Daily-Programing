package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
// https://www.acmicpc.net/problem/12933
// 오리
public class Q12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] counter = new int[5];
        int res = -1;
        int index;
        if (s.charAt(0) != 'q' || s.charAt(s.length() - 1) != 'k' || s.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            index = toInt(s.charAt(i));
            counter[index]++;
            if (index == 4) {
                for (int j = 0; j < counter.length; j++) {
                    if (--counter[j] < 0) {
                        System.out.println(-1);
                        return;
                    }

                }
            } else {
                for (int j = 0; j < index; j++) {
                    if (counter[j] < counter[index]) {
                        System.out.println(-1);
                        return;
                    }
                }
                if (counter[index] > res) {
                    res = counter[index];
                }
            }
        }
        for (int c : counter) {
            if (c != 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(res);
    }

    static int toInt(char c) {
        switch (c) {
            case 'q':
                return 0;
            case 'u':
                return 1;
            case 'a':
                return 2;
            case 'c':
                return 3;
            case 'k':
                return 4;
        }
        return -1;
    }
}