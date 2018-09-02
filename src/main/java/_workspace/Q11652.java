package _workspace;

import java.math.BigInteger;
import java.util.*;

public class Q11652 {
    // https://www.acmicpc.net/problem/11652
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger[] arr = new BigInteger[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextBigInteger();
        }
        Arrays.sort(arr);
        BigInteger ans = arr[0];
        int ansCnt = 1;
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) cnt++;
            else cnt = 1;

            if (ansCnt < cnt) {
                ansCnt = cnt;
                ans = arr[i];
            }
        }
        System.out.println(ans);
    }
}

/*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long input;
        Map<Long, Long> map = new HashMap<Long, Long>(1000000);
        for (int i = 0; i < n; i++) {

            input = sc.nextInt();
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, (long) 1);
            }
        }

        Iterator<Long> it = map.keySet().iterator();
        long num, res = 0, max = 0;
        while (it.hasNext()) {
            num = it.next();
            // System.out.println(num + "(" + map.get(num) + ")");
            if (map.get(num) > max) {
                res = num;
                max = map.get(num);
            }
        }
        System.out.println(res);
    }*/