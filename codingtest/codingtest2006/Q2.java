package domain.frame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(new Q2().solution(3, 4, new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}}));
    }

    public double solution(int N, int M, int[][] arr) {
        List<Point> points = getPoints(arr);
        if (points.size() < 2) {
            return 0.0;
        }

        double result = getDistance(new Point(), new Point(N - 1, M - 1));
        for (int i = 0; i < points.size(); i++) {
            Point firstPoint = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                result = Math.min(result, getDistance(firstPoint, points.get(j)));
            }
        }

        return Math.round(result * 100) / 100.0;
    }

    public double getDistance(Point p, Point q) {
        int dx = Math.abs(p.x - q.x);
        int dy = Math.abs(p.y - q.y);

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    private List<Point> getPoints(int[][] arr) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    points.add(new Point(i, j));
                }
            }
        }

        return points;
    }
}
