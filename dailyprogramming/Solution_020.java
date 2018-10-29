package dailyprogramming;

import java.util.HashMap;
import java.util.Map;

public class Solution_020 {

    public static void main(String[] args) {
        Solution_020 test = new Solution_020();
        System.out.println(test.solution(new int[]{4, 1, 2, 3}));

    }

    public boolean solution(int[] arr) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(i + 1)) return false;
            if (!map.get(i + 1)) return false;
            map.put(i + 1, false);
        }
        return true;
    }
}
