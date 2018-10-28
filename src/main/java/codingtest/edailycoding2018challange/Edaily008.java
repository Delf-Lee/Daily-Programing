package Temporary;

import java.io.*;
import java.util.*;

public class Edaily008 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            // sb.append(s[0]).append(" : ").append(s[1]).append("점").append('\n');
            // sb.append(s[0] + " : " + s[1] + "점\n");
            System.out.println(s[0] + " : " + s[1] + "점");
        }
        // System.out.println(sb.toString());
    }
}