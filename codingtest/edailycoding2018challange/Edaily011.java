package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edaily011 {
    public static void main(String[] args) throws IOException {
        System.out.printf("%.02f", Math.log10(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }
}
