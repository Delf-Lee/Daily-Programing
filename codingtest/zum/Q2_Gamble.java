package codingtest.zum;

/**
 * @author delf
 */
public class Q2_Gamble {
     public int solution(int N, int K) {
        int round = 0;
        while (N > 1) {
            round++;
            if (K > 0) {
                if (N % 2 == 0) {
                    N /= 2;
                    K--;
                    continue;
                }
            }
            N--;
        }
        return round;
    }

    public static void main(String[] args) {
        System.out.println(new Q2_Gamble().solution(4, 1));
    }
}