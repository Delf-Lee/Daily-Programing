package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edaily001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            field[i] = br.readLine().toCharArray();
        }

        int[][] cnt = new int[2][n];
        int totalB = 0; // 전체 검은돌 수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 'B') {
                    totalB++;
                    cnt[0][i]++;
                    cnt[1][j]++;
                }
            }
        }
        int min = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int rcB = cnt[0][i] + cnt[1][j] - ((field[i][j] == 'B') ? 2 : 0);
                int changeW = 2 * (rcB - n) + 2;
                if (min > changeW) {
                    min = changeW;
                }
            }
        }
        System.out.println(n * n - totalB + min);
    }
}
