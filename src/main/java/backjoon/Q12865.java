package backjoon;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/12865
// 평범한 배낭
public class Q12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Pair[] o = new Pair[n];
        for (int i = 0; i < n; i++) {
            o[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(o);

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int weight = o[i].w;
            int value = o[i].v;
            for (int j = i + 1; j < n; j++) {
                weight += o[j].w;
                value += o[j].v;
                if (weight > k) {
                    break;
                }
                if (value > max) {
                    max = value;
                }
            }
        }

        System.out.println(max);
    }
}

class Pair implements Comparable<Pair> {
    int w;
    int v;

    Pair(int w, int v) {
        this.w = w;
        this.v = v;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(w, o.w);
    }
}