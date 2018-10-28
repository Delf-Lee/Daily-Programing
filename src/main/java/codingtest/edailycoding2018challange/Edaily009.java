package Temporary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Edaily009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else if (arr[i] < 0) {
                neg.add(arr[i]);
            }
        }
        Comparator<Integer> abs = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(o2), Math.abs(o1));
            }
        };
        pos.sort(abs);
        neg.sort(abs);

        List<Integer> m = new ArrayList<>(4);
        try {
            m.add(pos.get(0) * pos.get(1));
        } catch (IndexOutOfBoundsException e) {}
        try {
            m.add(neg.get(0) * neg.get(1));
        } catch (IndexOutOfBoundsException e) {}
        try {
            m.add(pos.get(0) * pos.get(1) * pos.get(2));
        } catch (IndexOutOfBoundsException e) {}
        try {
            m.add(pos.get(0) * neg.get(0) * neg.get(1));
        } catch (IndexOutOfBoundsException e) {}


        int res = 0;
        for (int i = 0; i < m.size(); i++) {
            if (res < m.get(i)) {
                res = m.get(i);
            }
        }

        System.out.println(res);
    }
}

