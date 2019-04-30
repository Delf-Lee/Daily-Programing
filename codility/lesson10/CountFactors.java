package codility.lesson10;

/**
 * @author delf
 */
public class CountFactors {
    // https://app.codility.com/demo/results/training25JHCR-6X7/
    public int solution(int N) {
        int result = 0;
        for (int i = 1; i <= (int) Math.sqrt(N); i++) {
            result += (i * i == N) ? 1 : (N % i == 0) ? 2 : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(new CountFactors().solution(3_628_800));
        System.out.println(new CountFactors().solution(4));
    }
}