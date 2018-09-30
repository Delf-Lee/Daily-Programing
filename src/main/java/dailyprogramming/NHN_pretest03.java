package dailyprogramming;

import java.util.Scanner;

public class NHN_pretest03 {
    public static void main(String[] args) {
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

            if (isBuy(flu, i)) {
                System.out.println("i" + i);
                profit -= flu[i];
                coin++;
                System.out.println("buy: " + profit);
            } else {
                int todayProfit = coin * flu[i] + profit - 1;
                int futureProfit = getFutureMaxProfit(coin, i, flu) + profit;
                System.out.println("futureProfit: " + futureProfit);
                // System.out.println("sell: " + todayProfit);
                profit += todayProfit;
                // getFutureMaxProfit()
            }
        }

        System.out.println(profit);
    }

    static boolean isBuy(int[] flu, int day) {
        if (day == flu.length - 1) return false; // 마지막 날
        for (int i = 0; i < flu.length; i++) {
            if (flu[i] > flu[day]) {
                return true;
            }
        }
        return false;
    }

    static int getFutureMaxProfit(int coin, int day, int[] flu) {
        int max = 0;
        for (int i = day + 1; i < flu.length - 1; i++) {
            int dayReturn = flu[i] * (coin + i) - getPayBuyCoin(day, i, flu) - 1;
            if (max < dayReturn) max = dayReturn;
        }
        return max;
    }

    static int getPayBuyCoin(int start, int end, int[] flu) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += flu[i];
        }
        return sum;
    }
}