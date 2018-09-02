package backjoon;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11004
public class Q11004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        int n = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        /*int tmp;
        int i;
        for (i = 0; i < n; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }*/
        System.out.println(arr[n]);
    }
}
