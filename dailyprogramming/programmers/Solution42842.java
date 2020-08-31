import java.util.*;

public class Solution42842 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution42842().solution(8, 1)));
    }

    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= (yellow / 2) + 1; i++) {
            if (yellow % i == 0) {
                if (i * 2 + (yellow / i + 2) * 2 == brown) {
                    return new int[]{yellow / i + 2, i + 2,};
                }
            }
        }
        throw new IllegalStateException();
    }
}
