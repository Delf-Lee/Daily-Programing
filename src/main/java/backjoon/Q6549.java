package backjoon;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/6549
public class Q6549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
            int area = 0;
            for (int i = 0; i < arr.length; i++) {
                while (!s.empty() && arr[s.peek()] > arr[i]) {
                    int height = arr[s.pop()];
                    int width = i;
                    if (!s.empty()) width = i - s.peek() - 1;
                    if (width * height > area) area = width * height;
                }
                s.push(i);
            }
            while (!s.empty()) {
                int height = arr[s.pop()];
                int width = arr.length;
                if (!s.empty()) width = width - s.peek() - 1;
                if (width * height > area) area = width * height;
            }
            System.out.println(area);
        }
    }
}
