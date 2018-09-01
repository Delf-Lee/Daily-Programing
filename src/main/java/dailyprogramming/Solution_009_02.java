package dailyprogramming;

import java.util.*;
/* 두번째 풀이
* 인터넷의 C++ 코드를 참고하여 Java 코드로 변환 */
public class Solution_009_02 {
    public int[][] getMergedInterval(int[][] input) {
        List<int[]> intervals = new ArrayList<int[]>(Arrays.asList(input));
        Collections.sort(intervals, new Comparator<int[]>() { // interval을 '시작좌표' 기준으로 오름차순 정렬
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
            }
        });

        LinkedList<int[]> solution = new LinkedList<int[]>(); // 결과 interval이 저장될 List
        solution.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (solution.getLast()[1] > interval[0]) { // 하나씩 끝을 비교해 나가면서 겹치면 병합
                solution.getLast()[1] = Math.max(solution.getLast()[1], interval[1]);
            } else { // 겹치치 않으면 interval 추가
                solution.add(interval);
            }
        }
        return solution.toArray(new int[solution.size()][2]);
    }
}
