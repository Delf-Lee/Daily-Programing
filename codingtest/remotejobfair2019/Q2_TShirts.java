package codingtest.remotejobfair2019;

import java.util.Arrays;

/**
 * @author delf
 */
public class Q2_TShirts {
    public int solution(int[] people, int[] tshirts) {
        Arrays.sort(people);
        Arrays.sort(tshirts);

        int i, j = 0, result = 0;
        for (i = 0; i < people.length; i++) {
            for (; j < tshirts.length; j++) {
                if (people[i] <= tshirts[j]) {
                    System.out.printf("people[%d]=%d, tshirts[%d]=%d\n", i, people[i], j, tshirts[j]);
                    result++;
                    j++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q2_TShirts().solution(new int[]{2, 3}, new int[]{1, 2, 3})); // 2
        System.out.println(new Q2_TShirts().solution(new int[]{1, 2, 3}, new int[]{1, 1})); // 1
        System.out.println(new Q2_TShirts().solution(new int[]{2, 3, 4}, new int[]{1, 2, 3})); //2
        System.out.println(new Q2_TShirts().solution(new int[]{1, 5, 7}, new int[]{2, 4, 6})); //2
        System.out.println(new Q2_TShirts().solution(new int[]{1, 2, 3}, new int[]{2})); //1
    }
}
