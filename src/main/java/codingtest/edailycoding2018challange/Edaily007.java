package Temporary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Edaily007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (!set.contains(i)) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());

        Arrays.sort(arr);
        sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (i != arr[index]) {
                sb.append(i).append(" ");
            } else {
                index++;
            }
        }
        System.out.println(sb.toString());

    }
}

