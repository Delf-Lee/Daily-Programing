package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution12899 {
    private final static List<Integer> threeSquares = new ArrayList<>();
    static {
        int value = 1;
        do {
            threeSquares.add(value *= 3);
        } while (threeSquares.get(threeSquares.size() - 1) < 500_000_000);
    }
    public static void main(String[] args) {
//        System.out.println(threeSquares);
//        System.out.println(new Solution12899().solution(1));
//        System.out.println(new Solution12899().solution(2));
//        System.out.println(new Solution12899().solution(3));
//        System.out.println(new Solution12899().solution(7));
        System.out.println(new Solution12899().solution(21));
    }

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        char[] otfNation = {'4', '1', '2'};
        while (n > 0) {
            answer.insert(0, otfNation[n % 3]);
            n = n / 3 - (n % 3 == 0 ? 1 : 0);
        }

        return answer.toString();
    }
}
