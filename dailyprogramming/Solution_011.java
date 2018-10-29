package dailyprogramming;

import java.util.HashMap;
import java.util.Map;

public class Solution_011 {
    public int[] solution(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }
}
