package DP021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11651
public class Solution_021 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[][] points = new int[sc.nextInt()][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int p[], int q[]) {
                if (p[1] == q[1]) return Integer.compare(p[0], q[0]);
                else return Integer.compare(p[1], q[1]);
            }
        });
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}