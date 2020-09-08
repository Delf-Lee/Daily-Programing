import java.util.*;

public class Solution42884 {

    public static void main(String[] args) {
        System.out.println(new Solution42884().solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    int solution(int[][] routes) {
        int answer = 1;

        List<Section> sections = new ArrayList<>();
        for (int[] route : routes) {
            sections.add(new Section(route[0], route[1]));
        }

        sections.sort(Section::compareTo);

        int tmp = sections.get(0).end;

        for (int i = 0; i < sections.size() - 1; i++) {
            if (tmp > sections.get(i).end) tmp = sections.get(i).end;
            if (tmp < sections.get(i + 1).start) {
                answer += 1;
                tmp = sections.get(i + 1).end;
            }
        }
        return answer;
    }

    static class Section implements Comparable<Section> {
        public Section(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;

        @Override
        public int compareTo(Section o) {
            return start - o.start;
        }
    }
}
