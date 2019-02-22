package dailyprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author delf
 */
public class RectangleCoordination {
    public int[] solution(int[][] v) {
        Set<Integer> X = new HashSet<>();
        Set<Integer> Y = new HashSet<>();
        for (int i[] : v) {
            if (!X.remove(i[0])) X.add(i[0]);
            if (!Y.remove(i[1])) Y.add(i[1]);
        }
        return new int[]{X.iterator().next(), Y.iterator().next()};
    }

}
