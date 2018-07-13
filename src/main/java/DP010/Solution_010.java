package DP010;

import java.util.Arrays;

public class Solution_010 {
    private int[][] map; // 주어진 맵
    private boolean[][] isVisit; // 해당 배열에 방문했는지 여부
    private int minDistance; // 목적지까지 도달한 거리 중 가장 작은 값
    private int[] finish; // 도착 좌표
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 탐색할 상하좌우 네 방향

    public int getShortestDistance(int[][] map, int[] start, int[] finish) {
        // 변수 세팅
        this.map = map;
        this.isVisit = new boolean[map.length][map[0].length];
        for (int i = 0; i < isVisit.length; i++) {
            Arrays.fill(isVisit[i], false);
        }
        minDistance = map.length * map[0].length;
        this.finish = finish;

        // 깊이우선탐색(DFS) 시작
        findDestination(start[0], start[1], 0);

        return minDistance;
    }

    private void findDestination(int col, int row, int distance) {
        isVisit[col][row] = true;
        if (col == finish[0] && row == finish[1]) { // 목적지 도착 시, 거리 비교
            minDistance = distance < minDistance ? distance : minDistance;
            return;
        }
        int nextCol, nextRow;
        for (int i = 0; i < dir.length; i++) { // 상하좌우 탐색
            nextCol = col + dir[i][0]; // 다음 탐색 좌표 설정
            nextRow = row + dir[i][1];
            if (nextCol < 0 || nextRow < 0 || nextCol > map.length - 1 || nextRow > map[0].length - 1) continue;
            if (isVisit[nextCol][nextRow] == false && map[nextCol][nextRow] == 1) { // 방문하지 않은 길인가?
                findDestination(nextCol, nextRow, distance + 1); // 다음 좌표 탐색
            }
        }
        isVisit[col][row] = false;
    }
}
