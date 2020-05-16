package atmp;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static int maxHeight(List<Integer> wallPositions, List<Integer> wallHeights) {
        int maxHeight = 0;

        for (int i = 1; i < wallPositions.size(); i++) {
            int wallThickness = Math.abs(wallPositions.get(i) - wallPositions.get(i - 1));
            int diffWallHeight = Math.abs(wallHeights.get(i) - wallHeights.get(i - 1));

            int practicalWallThickness = Math.abs(wallThickness - diffWallHeight);

            if (practicalWallThickness >= wallThickness) {
                maxHeight = Math.max(wallThickness, maxHeight);
                // System.out.println(maxHeight);
                continue;
            }
//            System.out.println("check");
            int additionalMudHeight = practicalWallThickness / 2;
            maxHeight = Math.max(Math.max(wallHeights.get(i), wallHeights.get(i - 1)) + additionalMudHeight, maxHeight);
        }

        return maxHeight;
    }
}


