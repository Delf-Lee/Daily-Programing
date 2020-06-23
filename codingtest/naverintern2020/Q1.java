public class Solution {
    public int solution(int N) {
        int digit = (int)  Math.log10(N);
        return N < 10 ? digit : (int) Math.pow(10, digit);
    }
}
