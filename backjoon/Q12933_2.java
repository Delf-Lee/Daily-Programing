package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q12933_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayList<Integer>[] quack = (ArrayList<Integer>[]) new ArrayList[5];
        for (int i = 0; i < quack.length; i++) {
            quack[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            quack[getIndex(s.charAt(i))].add(i);
        }

        int size = quack[0].size();
        for (int i = 1; i < quack.length; i++) {
            if (size != quack[i].size()) {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < quack.length - 1; j++) {
                if (quack[j].get(i) > quack[j + 1].get(i)) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        int mx = 1;
        int st = 0;
        for (int i = 1; i < size; i++) {
            while (quack[4].get(st) < quack[0].get(i)) {
                st++;
            }
            mx = Math.max(mx, i - st + 1);
        }
        System.out.println(mx);
    }

    static int getIndex(char c) {
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

    public int solution(String s) {
        ArrayList<Integer>[] quack = (ArrayList<Integer>[]) new ArrayList[5];
        for (int i = 0; i < quack.length; i++) {
            quack[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            quack[getIndex(s.charAt(i))].add(i);
        }

        int size = quack[0].size();
        for (int i = 1; i < quack.length; i++) {
            if (size != quack[i].size()) {
                return -1;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < quack.length - 1; j++) {
                if (quack[j].get(i) > quack[j + 1].get(i)) {
                    return -1;
                }
            }
        }

        int mx = 1;
        int st = 0;
        for (int i = 1; i < size; i++) {
            while (quack[4].get(st) < quack[0].get(i)) {
                st++;
            }
            mx = Math.max(mx, i - st + 1);
        }
        return mx;
    }
}