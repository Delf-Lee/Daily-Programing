package codingtest.baemintechcourse2019;

import java.awt.*;

/**
 * @author delf
 */
public class LandIncludeWall {
    private static final int X1 = 0;
    private static final int Y1 = 1;
    private static final int X2 = 2;
    private static final int Y2 = 3;

    public boolean solution(int[][] lands, int[][] wells, int[] point) {
        return isExcludeLand(point, lands) && isIncludeWall(point, wells);
    }

    private boolean isIncludeWall(int[] point, int[][] wells) {

        Point p1 = new Point(point[0], point[1]);
        Point p2 = new Point(point[2], point[3]);

        for (int[] land : wells) {
            Rectangle rectangle = getTrimRectangle(land);

            if (p1.x < rectangle.left.x && p2.x > rectangle.left.x) {
                if (p1.y < rectangle.left.y && p2.y > rectangle.left.y) {
                    return true;
                }
            } else if (p1.x < rectangle.right.x && p2.x > rectangle.right.x) {
                if (p1.y < rectangle.right.y && p2.y > rectangle.right.y) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isExcludeLand(int[] point, int[][] lands) {
        Point p1 = new Point(point[0], point[1]);
        Point p2 = new Point(point[2], point[3]);

        for (int[] land : lands) {
            Rectangle rectangle = getTrimRectangle(land);

            if (p1.x < rectangle.left.x && p2.x > rectangle.left.x) {
                if (p1.y < rectangle.left.y && p2.y > rectangle.left.y) {
                    return false;
                }
            } else if (p1.x < rectangle.right.x && p2.x > rectangle.right.x) {
                if (p1.y < rectangle.right.y && p2.y > rectangle.right.y) {
                    return false;
                }
            }
        }
        return true;
    }

    /* 좌표 표준화 */
    private Rectangle getTrimRectangle(int[] points) {
        return new Rectangle(new Point(Math.min(points[X1], points[X2]), Math.min(points[Y1], points[Y2])), new Point(Math.min(points[X1], points[X2]), Math.min(points[Y1], points[Y2])));
    }

    /* 입력 좌표 표준화를 위한 클래스 */
    class Rectangle {
        Point left; // 좌측 하단 좌표
        Point right; // 우측 상단 좌표

        Rectangle(Point left, Point right) {
            this.left = left;
            this.right = right;
        }
    }


    /*public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{10,5, 30, 0}, {0, 30, 20, 50}, {30, 30, 40, 40}}, new int[][]{{15, 15, 25, 25}, {40, 10, 50, 20}}, new int[]{10, 10, 30, 30}));
        System.out.println(new Solution().solution(new int[][]{{0, 0, 20, 10}, {20, 20, 10, 40}, {30, 0, 50, 20}}, new int[][]{{20, 40, 30, 50}, {30, 20, 50, 30}}, new int[]{20, 30, 30, 40}));
    }*/
}

