package codingtest.winterconding2018;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author delf
 */
public class VisitLength {
    private final int[][] DIR_XY = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] boundary = new int[12][12];

    public int solution(String dirs) {
        Map<String, String> map = new HashMap<>();
        int answer = 0;
        Point now = new Point(0, 0);
        for (char direction : dirs.toCharArray()) {
            try {
                int oldX = now.x;
                int oldY = now.y;
                boundary[oldX + 5][oldY + 5] = 0;
                switch (direction) {
                    case 'U':
                        System.out.print("U: ");
                        now.x += DIR_XY[0][0];
                        now.y += DIR_XY[0][1];
                        break;
                    case 'D':
                        System.out.print("D: ");
                        now.x += DIR_XY[1][0];
                        now.y += DIR_XY[1][1];
                        break;
                    case 'R':
                        System.out.print("R: ");
                        now.x += DIR_XY[2][0];
                        now.y += DIR_XY[2][1];
                        break;
                    case 'L':
                        System.out.print("L: ");
                        now.x += DIR_XY[3][0];
                        now.y += DIR_XY[3][1];
                        break;
                }
                String older = oldX + "," + oldY;
                String newer = now.x + "," + now.y;
                System.out.printf("%s -> %s\n", older, newer);
                if (map.containsKey(older)) {
                    if (!map.get(older).equals(newer)) {
                        System.out.println("count1");
                        map.put(older, newer);
                        map.put(newer, older);
                        answer++;
                    }
                } else if (map.containsKey(newer)) {
                    if (!map.get(newer).equals(older)) {
                        System.out.println("count2");
                        map.put(older, newer);
                        map.put(newer, older);
                        answer++;
                    }
                } else {
                    System.out.println("count3");
                    answer++;
                    map.put(older, newer);
                    map.put(newer, older);
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("무시");
                // 무시한다.
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        // System.out.println(new Solution3().solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        // System.out.println(new Solution3().solution(new int[]{1}));
        // System.out.println(new Solution3().solution("ULURRDLLU"));
        // System.out.println(new Solution3().solution("LULLLLLLU"));

        System.out.println(new VisitLength().solution("UDRLUDRLUDRL"));


    }
}

