package codingtest.winterconding2018;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.*;

/**
 * @author delf
 */
public class VisitLength {
    private final int[][] DIR_XY = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] boundary = new int[12][12];
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        Point now = new Point(0, 0);

        for (char c : dirs.toCharArray()) {
            String old = now.x + "," + now.y;
            int x = 0, y = 0;
            switch (c) {
                case 'U':
                    x = now.x + DIR_XY[0][0];
                    y = now.y + DIR_XY[0][1];
                    break;
                case 'D':
                    x = now.x + DIR_XY[1][0];
                    y = now.y + DIR_XY[1][1];
                    break;
                case 'R':
                    x = now.x + DIR_XY[2][0];
                    y = now.y + DIR_XY[2][1];
                    break;
                case 'L':
                    x = now.x + DIR_XY[3][0];
                    y = now.y + DIR_XY[3][1];
                    break;
            }

            try {
                boundary[x + 5][y + 5] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }

            now.x = x;
            now.y = y;
            if (!set.contains(old + ":" + now)) {
                set.add(old + ":" + now);
                set.add(now + ":" + old);
                answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new VisitLength().solution("ULURRDLLU"));
        System.out.println(new VisitLength().solution("LULLLLLLU"));
    }
    /*private Set<Path> set = new HashSet<>();
    private final int[][] DIR_XY = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] boundary = new int[12][12];

    public int solution(String dirs) {
        int answer = 0;
        Point now = new Point(0, 0);
        for (char c : dirs.toCharArray()) {
            Point old = new Point(now);
            switch (c) {
                case 'U':
                    now.x += DIR_XY[0][0];
                    now.y += DIR_XY[0][1];
                    break;
                case 'D':
                    now.x += DIR_XY[1][0];
                    now.y += DIR_XY[1][1];
                    break;
                case 'R':
                    now.x += DIR_XY[2][0];
                    now.y += DIR_XY[2][1];
                    break;
                case 'L':
                    now.x += DIR_XY[3][0];
                    now.y += DIR_XY[3][1];
                    break;
            }
            try {
                boundary[now.x + 5][now.y + 5] = 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }

            Path path = new Path(old, now);
            System.out.printf("%d, %d -> %d, %d\n", old.x, old.y, now.x, now.y);
            System.out.println(path.hashCode());
            if (!set.contains(path)) {
                set.add(path);
                answer++;
                System.out.println("         count");
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(new VisitLength().solution("ULURRDLLU"));
        System.out.println(new VisitLength().solution("LULLLLLLU"));
    }

    class Path {
        Point p1;
        Point p2;

        public Path(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public int hashCode() {
            Set<Point> set = new HashSet<>();
            set.add(p1);
            set.add(p2);
            return set.hashCode();
        }
    }*/
}

