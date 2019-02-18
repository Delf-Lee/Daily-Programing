package codingtest.zum;

/**
 * @author delf
 */
public class Q1_SmallestDigit {
    public int solution(int N) {
        if(N < 10) return 0;
        return (int) Math.pow(10, (int) Math.log10(N));
    }
}