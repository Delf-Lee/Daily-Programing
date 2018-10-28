package codingtest.nhn2018pretest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NHN_pretest01 {
    public static void main(String[] args) {
        int[] cards;
        List<Integer> cardList = new ArrayList<>();

        // 입력
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int p = sc.nextInt();
        int[] n = new int[p];
        for (int i = 0; i < p; i++) {
            n[i] = sc.nextInt();
        }

        // 카드 초기화
        cards = new int[c];
        for (int i = 0; i < cards.length; i++) {
            cardList.add(i+1);
        }

        // 섞기
        for (int i : n) {
            shuffle(c, i, cardList);
        }

        // 출력
        for (int i = 0; i < 5; i++) {
            System.out.println(cardList.get(i));
        }
    }

    public static void shuffle(int c, int n, List<Integer> cardList) {
        // 카드 위로 올리기
        for (int i = 0; i < cardList.size() - n * 2; i++) {
            cardList.add(0, cardList.remove(cardList.size() - n - 1));
        }
        // 조건에 대하여 리커시브
        if (c > n * 2) {
            shuffle(c - 2 * n, n, cardList.subList(0, cardList.size() - n * 2)); // 리커시브
        }
    }
}
