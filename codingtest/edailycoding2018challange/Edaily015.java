package codingtest.edailycoding2018challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Edaily015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] dic = new String[n];
        for (int i = 0; i < n; i++) {
            dic[i] = br.readLine();
        }
        Comparator<String> order = (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length());
        };
        Arrays.sort(dic, order);
        for (int i = 0; i < n; i++) {
            if (i != 0 && dic[i].equals(dic[i - 1])) {
                continue;
            }
            System.out.println(dic[i]);
        }
    }
}
