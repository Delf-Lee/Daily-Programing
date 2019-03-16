package codingtest.baemintechcourse2019;

/**
 * @author delf
 */
public class ThreeSixNine {

    public int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            String s = Integer.toString(i);
            for (char c : s.toCharArray()) {
                if (c == '3') {
                    count++;
                    continue;
                }
                if (c == '6') {
                    count++;
                    continue;
                }
                if (c == '9') {
                    count++;
                }
            }
        }
        return count;
    }

    /*public int solution2(int number) {
        String s = Integer.toString(number);
        for (char c : s.toCharArray()) {
            int n = Character.getNumericValue(c);
        }
    }*/

    public static void main(String[] args) {
        // System.out.println(new Solution().solution("I love you"));
        // System.out.println(new Solution().solution(457));
        char c = '3';
        System.out.println(Character.getNumericValue(c) + 1);
    }
}

