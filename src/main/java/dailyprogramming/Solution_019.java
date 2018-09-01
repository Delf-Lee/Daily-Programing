package dailyprogramming;

public class Solution_019 {
    public int[] solution(int[] arr, int k) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[(k + i) % arr.length];
        }
        return res;
    }
}