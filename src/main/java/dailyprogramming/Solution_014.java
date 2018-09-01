package dailyprogramming;

import java.util.Scanner;

public class Solution_014 {
    public static void main(String[] args) {
        int prizeInfo[][][] = {
                {{5000000, 1}, {3000000, 2}, {2000000, 3}, {500000, 4}, {300000, 5}, {100000, 6}},
                {{5120000, 1}, {2560000, 2}, {1280000, 4}, {640000, 8}, {320000, 16}}};

        Scanner scn = new Scanner(System.in);
        int nImagine = scn.nextInt();
        int rank[][] = new int[nImagine][prizeInfo.length];
        for (int i = 0; i < nImagine; i++) {
            for (int j = 0; j < rank[i].length; j++) {
                rank[i][j] = scn.nextInt();
            }
        }
        for (int k = 0; k < nImagine; k++) {
            int totalPrize = 0;
            for (int i = 0; i < prizeInfo.length; i++) {
                int rankAcc = 0;
                for (int j = 0; j < prizeInfo[i].length; j++) {
                    rankAcc += prizeInfo[i][j][1];
                    if (rankAcc >= rank[k][i] && rank[k][i] != 0) {
                        totalPrize += prizeInfo[i][j][0];
                        break;
                    }
                }
            }
            System.out.println(totalPrize);
        }
    }
}
