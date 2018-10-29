package codingtest.nhn2018pretest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NHN_pretest02 {
    static int days;
    static ArrayList<Integer> prices;
    static int coin = 0;
    static int maxMoney = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        days = sc.nextInt();
        prices = new ArrayList();
        for (int i = 0; i < days; i++) {
            prices.add(sc.nextInt());
        }
        int money = 0;
        for (int i = 0; i < days; i++) {
            int todayPrice = prices.remove(0);
            int maxPrice = 0;
            if (!prices.isEmpty()) {
                maxPrice = Collections.max(prices);
            }
            if (todayPrice < maxPrice) { // 산다.(최대 1개 구매 가능)
                System.out.println("산다.");
                money = money - todayPrice;
                coin++;
            } else if (todayPrice == maxPrice) { // 팔지 아무것도 안할지 정한다.
                System.out.println("아무것도 안한다.");
            } else {
                // 코인이 있으면 판다.
                if (coin > 0) {
                    System.out.println("판다.");
                    money = money + (todayPrice * coin) - 1; // 수수료 1원
                    coin = 0;
                }
            }
        }
        System.out.println(money);
    }
}
