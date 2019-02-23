package codingtest.remotejobfair2019;

import java.util.*;

/**
 * @author delf
 */
public class Q3_HighestDamage {
    private final int UP_DMG = 0;
    private final int DOWN_HP = 1;

    public int[] solution(int[] healths, int[][] items) {
        List<Integer> result = null;
        int max = 0;
        for (int i = 0; i < healths.length; i++) {
            int dmg = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < items.length; j++) {
                if (healths[i] - items[j][DOWN_HP] >= 100) {
                    dmg += items[j][UP_DMG];
                    list.add(j + 1);
                }
            }
            if (max < dmg) {
                max = dmg;
                result = list;
            }
        }
        Collections.sort(Objects.requireNonNull(result));
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q3_HighestDamage().solution(new int[]{200, 120, 150}, new int[][]{{30, 100}, {500, 30}, {100, 400}})));
    }
}
