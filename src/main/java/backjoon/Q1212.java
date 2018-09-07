package backjoon;

import java.util.Scanner;

public class Q1212 {
    public static void main(String[] args) {
        String[] octal = {"000", "001", "010", "011", "100", "101", "110", "111"};
        char[] arr = new Scanner(System.in).next().toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) result.append(octal[arr[i] - '0']);
        while (result.length() > 1 && result.charAt(0) == '0') result.deleteCharAt(0);
        System.out.println(result);
    }
}
