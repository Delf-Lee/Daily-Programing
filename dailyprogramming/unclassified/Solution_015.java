package unclassified;

import java.util.Scanner;

public class Solution_015 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int total = scn.nextInt();
        int n = scn.nextInt();
        double[] arr = new double[total];
        for (int i = 0; i < total; i++) {
            arr[i] = scn.nextInt();
        }

        double minStdDev = Double.MAX_VALUE;
        for (int i = 0; i <= arr.length - n; i++) {
            double sum = 0.0;
            for (int j = i; j < i + n; j++) {
                sum += arr[j];
            }
            double avg = sum / n;
            double sumSquare = 0.0;
            double diff;
            for (int j = i; j < i + n; j++) {
                diff = arr[j] - avg;
                sumSquare += diff * diff;
            }
            double stdDev = Math.sqrt(sumSquare / n);
            minStdDev = stdDev < minStdDev ? stdDev : minStdDev;
            System.out.println(i);
        }
        System.out.println(minStdDev);
    }
}
