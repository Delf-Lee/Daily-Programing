package unclassified;

public class Solution_017 {
    private final int NA = Integer.MIN_VALUE;

    public boolean solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            try {
                if (arr[value] == NA) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return true;
    }
}