package programmers;

public class Solution12904 {
    public int solution(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] array = s.toCharArray();
        int max = 0;
        for (int i = 0; i < array.length - 1; i++) {
            max = Math.max(max, check(array, i));
        }

        return max;
    }

    private int check(char[] array, int index) {
        int sameLetter = 0;
        for (int i = index + 1; i < array.length; i++) {
            if (array[index] != array[i]) {
                break;
            }
            sameLetter++;
        }
        int max = sameLetter + 1;
        for (int i = 1; i < array.length; i++) {
            int leftIdx = index - i;
            int rightIdx = index + sameLetter + i;

            if (leftIdx < 0 || rightIdx > array.length - 1) {
                break;
            }
            if (array[leftIdx] != array[rightIdx]) {
                break;
            }
            max += 2;
        }

        return max;
    }
}

