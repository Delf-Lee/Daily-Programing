package codingtest.baemintechcourse2019;

import java.util.Arrays;

/**
 * @author delf
 */
public class Currency {
    private final int[] CURRENCY = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public int[] solution(int money) {
        int[] result = new int[CURRENCY.length];
        for (int i = 0; i < result.length; i++) {
            if ((money / CURRENCY[i]) > 0) {
                result[i] = money / CURRENCY[i];
                money -= CURRENCY[i] * result[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Currency().solution(165237)));
    }
}

