package dailyprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_030 {
    private static int[][] m;
    private static boolean[][] isVisit;
    private final static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = new int[n][n];
        isVisit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        List<Integer> areaList = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (!isVisit[i][j] && m[i][j] == 1) {
                    areaList.add(floodFill(i, j) + 1);
                }
            }
        }

        Collections.sort(areaList);
        System.out.println(areaList.size());
        for (Integer area : areaList) {
            System.out.print(area + " ");
        }
    }

    private static int floodFill(int c, int r) {
        isVisit[c][r] = true;
        int nc, nr, cnt = 0;
        for (int i = 0; i < dir.length; i++) {
            nc = c + dir[i][0];
            nr = r + dir[i][1];
            try {
                if (!isVisit[nc][nr] && m[nc][nr] == 1) {
                    cnt += floodFill(nc, nr) + 1;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return cnt;
    }

}
