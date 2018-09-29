package dailyprogramming;

import java.util.Scanner;

public class NHN_pretest03 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] flu = new int[n];
        for (int i = 0; i < n; i++) {
            flu[i] = sc.nextInt();
        }
        int profit = 0;
        int coin = 0;

        for (int i = 0; i < n; i++) {
            System.out.printf("day%d: coin:%d, profit:%d\n", i, coin, profit);
            int todayReturn = (flu[i] * coin) - coin;
            System.out.printf("todayReturn: %d\n", todayReturn);
            if (todayReturn <= 0) {
                continue;
            } else {
                int expReturn = expectMaxReturn(coin, i, flu);
                if(expReturn == 0) {
                    continue;
                }
                System.out.printf("expReturn: %d\n\n", expReturn);
                if (todayReturn > expReturn) {
                    profit += todayReturn;
                } else {
                    coin++;
                    profit -= flu[i];
                }
            }
        }

        System.out.println(profit);
    }

    static int expectMaxReturn(int coin, int day, int[] flu) {
        int max = 0;
        System.out.printf("day%d, coin%d\n", day, coin);
        for (int i = day + 1; i < flu.length - 1; i++) {
            int dayReturn = flu[i] * (coin + i) - i;
            if (dayReturn > max) max = dayReturn;
        }
        return max;
    }
}
