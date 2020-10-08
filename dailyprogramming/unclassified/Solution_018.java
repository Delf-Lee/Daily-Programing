package unclassified;

public class Solution_018 {
    public boolean solution(int[] arr, int n) {
        int start = 0;
        int end = arr.length;
        int mid;
        while (true) {
            mid = (start + end) / 2;
            if (arr[mid] < n) {
                if (start == mid) return false;
                start = mid;
            } else if (arr[mid] > n) {
                if (end == mid) return false;
                end = mid;
            } else {
                return true;
            }
        }
    }
}