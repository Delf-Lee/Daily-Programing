package domain.frame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {

    private String[] map;
    private boolean[][] isVisit;

    public static void main(String[] args) {
        System.out.println(new Q3().solution(5, 7, new String[]{"--*AB**", "AB*A*BA", "B*-A*BB", "*-A*A**", "BC*BC*C"}));
    }

    public String solution(int N, int M, String[] map) {
        this.map = map;
        this.isVisit = new boolean[N][M];

        List<Colony> colonies = getColonies(N, M, map);
        System.out.println(colonies);
        Map<Virus, Integer> virusCounter = new HashMap<>();
        for (Colony c : colonies) {
            Virus virus = c.getStrongestVirus();
            System.out.println(virus);
            virusCounter.merge(virus, c.getVirusCount(virus), Integer::sum);
        }

        StringBuilder result = new StringBuilder();
        for (Virus v : virusCounter.keySet()) {
            result.append(v.name).append(virusCounter.get(v));
        }

        return result.toString();
    }

    private List<Colony> getColonies(int N, int M, String[] map) {
        List<Colony> colonies = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisit[i][j] && map[i].charAt(j) != '*') {
                    Colony colony = new Colony();
                    colonies.add(colony);
                    expand(i, j, colony);
                }
            }
        }

        return colonies;
    }

    private void expand(int r, int c, Colony colony) {
        if (r < 0 || r >= isVisit.length || c < 0 || c >= isVisit[0].length) {
            System.out.println();
            return;
        }

        if (isVisit[r][c]) {
            System.out.println();
            return;
        }

        char cell = map[r].charAt(c);
        if (cell == '*') {
            return;
        }

        if (Character.isAlphabetic(cell)) {
            Virus virus = new Virus(map[r].charAt(c));
            colony.addVirus(virus);
        }

        isVisit[r][c] = true;

        expand(r - 1, c, colony);
        expand(r + 1, c, colony);
        expand(r, c - 1, colony);
        expand(r, c + 1, colony);
    }

    static class Colony {
        Map<Virus, Integer> viruses = new HashMap<>();

        public void addVirus(Virus virus) {
            viruses.merge(virus, 1, Integer::sum);
        }

        public Virus getStrongestVirus() {
            List<Virus> list = new ArrayList<>(viruses.keySet());
            Virus strongestVirus = Virus.NOTHING;
            if (list.size() == 1) {
                return list.get(0);
            }

            for (int i = 0; i < list.size(); i++) {
                Virus v1 = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {

                    Virus v2 = list.get(j);
                    System.out.println("####" + v1 + " " + v2);
                    if (viruses.get(v1).equals(viruses.get(v2))) {
                        return v1.isStronger(v2) ? v1 : v2;
                    }
                    return viruses.get(v1) > viruses.get(v2) ? v1 : v2;
                }
            }
            return strongestVirus;
        }

        public int getVirusCount(Virus virus) {
            return viruses.get(virus);
        }

        @Override
        public String toString() {
            return "Colony{" +
                    "viruses=" + viruses +
                    '}';
        }
    }

    static class Virus {
        public static final Virus NOTHING = new Virus(' ');
        private char name;

        public Virus(char name) {
            this.name = name;
        }

        public boolean isStronger(Virus virus) {
            return name < virus.name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Virus virus = (Virus) o;

            return name == virus.name;
        }

        @Override
        public int hashCode() {
            return name;
        }

        @Override
        public String toString() {
            return "Virus{" +
                    "name=" + name +
                    '}';
        }
    }
}
