package dailyprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NHN_pretest04 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        int[][] obstacle = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = sc.next().charAt(0);
                if (Character.isDigit(ch)) {
                    obstacle[i][j] = ch - '0';
                } else {
                    map[i][j] = ch;
                }
            }
        }
        // 계산 및 출력
        BoardGame boardGame = new BoardGame(map, obstacle);
        boardGame.endGame(); // 계산
        boardGame.showEndGame(); // 출력
    }

    static class BoardGame {
        private int n; // N*N 배열 크기
        private char[][] map; // 점령 상황 표시 배열
        private int[][] barrier; // 장애물 표시 배열
        private int turn; // 턴 수
        private boolean hasNext = true; // 다음 턴 가능 여부

        private Map<Character, Integer> battleField = new HashMap<>();

        final static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 방향

        public BoardGame(char[][] map, int[][] obstacle) {
            this.map = map;
            this.barrier = obstacle;
            this.n = map.length;
        }

        public void nextTurn() {
            hasNext = false;
            char[][] nextMap = new char[n][n]; // 이번 턴에 점령될 필드
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isEmptyField(i, j)) { // 아무도 점령하지 않은 필드에서
                        char occupant = findOccupant(i, j); // 해당 위치의 점령자를 결정
                        if (isExistOccupant(occupant)) { // 필드 점령자가 있다면,
                            // System.out.println("승자는 " + occupant);
                            nextMap[i][j] = occupant; // 필드 갱신
                            hasNext = true; // 행렬 순회 내에 한번이라도 점령자의 변화가 있었다면 "다음 턴이 있다"라고 판단
                        }
                    }
                }
            }
            renewalMap(nextMap); // 맵 갱신
        }

        private char findOccupant(int i, int j) {
            for (int k = 0; k < dir.length; k++) { // [i][j]기준 4방향 순회
                if (barrier[i][j] != 0) {
                    if (isBlocked(i, j, k)) { // k방향이 막혔으면 패스
                        continue;
                    }
                }

                // 행렬 위치 설정(상, 하, 좌, 우)
                int nc = i + dir[k][0];
                int nr = j + dir[k][1];
                try {
                    char nearCountry = map[nc][nr]; // 주변 필드에
                    if (nearCountry != 0) {
                        if (i == 3 && j == 2) {
                            System.out.println(nearCountry);
                        }
                        entryBattle(nearCountry); // 국가가 있으면 점령자 후보에 참가
                        // System.out.printf("[%d][%d]에 %c국가 참전\n", i, j, nearCountry);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue; // 배열 밖 범위는 패스 (그냥 명시)
                }
            }

            char winner = winner();
            battleField.clear();
            return winner; // 점령자 후보중 승자를 결정
        }

        private void entryBattle(char ch) {
            battleField.put(ch, battleField.containsKey(ch) ? battleField.get(ch) + 1 : 1);
        }

        private char winner() {
            switch (battleField.size()) {
                case 0:
                case 4:
                    return 0; // 승자 없음
                case 1:
                    return battleField.keySet().iterator().next(); // 한명이 승자
                case 2:
                case 3:
                    int max = 0;
                    char winner = 0;
                    for (Character candidate : battleField.keySet()) {
                        int nField = battleField.get(candidate);
                        if (nField > max) {
                            max = nField;
                            winner = candidate;
                        }
                    }
                    if (max == 1) return 0;
                    else return winner;
            }
            throw new NoSuchElementException();
        }

        private boolean isEmptyField(int i, int j) {
            return map[i][j] == 0;
        }

        private boolean isExistOccupant(char ch) {
            return ch != 0;
        }

        private boolean isBlocked(int i, int j, int dir) {
            String b = String.format("%04d", Integer.parseInt(Integer.toBinaryString(barrier[i][j])));
            return b.charAt(dir) == '1';
        }

        public void endGame() {
            while (hasNext) {
                turn++;
                nextTurn();
                debugPrint();
            }
        }

        public void renewalMap(char[][] next) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char ch = next[i][j];
                    if (ch != 0) {
                        map[i][j] = ch;
                    }
                }
            }
            battleField.clear();
        }

        private void debugPrint() {
            System.out.printf("---%d---\n", turn);
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    char ch = map[i][j];
                    if (ch != 0) {
                        System.out.print(map[i][j] + " ");
                    } else {
                        System.out.print(barrier[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }

        public void showEndGame() {
            System.out.println(turn);
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    char ch = map[i][j];
                    if (ch != 0) {
                        System.out.print(map[i][j] + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
