import java.util.*;

public class Q1 {
    public int solution(int p) {
        int year = p;
        while (year <= 10000) {
            String s = Integer.toString(++year);
            HashSet<Integer> set = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
            for (char c : s.toCharArray()) {
                if(!set.remove(Integer.parseInt(String.valueOf(c)))) {
                    break;
                }
            }
            System.out.println(set);
            if (set.size() == 6) {
                return year;
            }
        }
        throw new IllegalArgumentException();
    }
}
