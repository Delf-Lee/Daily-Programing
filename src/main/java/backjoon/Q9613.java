package backjoon;
 
import java.util.Scanner;

// https://www.acmicpc.net/problem/9613
public class Q9613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr;

        while (t-- > 0) {
            arr = new int[sc.nextInt()];
            for (int i = 0; i < arr.length; i++)
                arr[i] = sc.nextInt();

            int sum = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    sum += getGCD(arr[i], arr[j]);
                }
            }
            System.out.println(sum);
        }
    }

    static int getGCD(int x, int y) {
        if (x < y) {
            x ^= y;
            y ^= x;
            x ^= y;
        }

        while (y > 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}