public class Solution12904 {
    public int solution(String s) {
        char[] array = s.toCharArray();
        int max = 0;
        for (int i = 1; i < array.length - 1; i++) {
            max = Math.max(max, check(array, i));
        }

        return max;
    }

    private int check(char[] array, int index) {
        int revision = array[index] == array[index + 1] ? 1 : 0;
        int max = 1 + revision;
        for (int i = 1; i < array.length; i++) {
            int leftIndex = index - i;
            int rightIndex = index + i + revision;
            if (leftIndex < 0 || rightIndex > array.length - 1) {
                break;
            }
            if (array[leftIndex] == array[rightIndex]) {
                max += 2;
            }
        }
        return max;
    }
}

