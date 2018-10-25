package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q12907 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        int i;
        int cnt = 0;
        for (i = 0; i < n; i++) {
            if (a[i] == cnt) {
                if (i % 2 != 0) cnt++;
            } else {
                break;
            }
        }
        int tall = ++cnt;
        for (int j = i; j < n; j++) {
            if (a[j] != cnt++) {
                System.out.println(0);
                return;
            }
        }
        System.out.println((int) Math.pow(2, tall));
    }


    public int solution(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int i;
        int cnt = 0;
        for (i = 0; i < n; i++) {
            if (a[i] == cnt) {
                if (i % 2 != 0) cnt++;
            } else {
                break;
            }
        }
        System.out.printf("i=%d, cnt=%d\n", i, cnt);
        int tall = ++cnt;
        System.out.println("tall: " + tall);
        for (int j = i; j < n; j++) {
            System.out.printf("a[%d]=%d, cnt=%d\n", j, a[j], cnt);
            if (a[j] != cnt++) return 0;
        }
        return (int) Math.pow(2, tall);
    }
}