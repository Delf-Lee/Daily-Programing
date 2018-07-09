package DP009;

import java.util.*;

/* 첫 풀이
* List 내 interval들을 두개씩 비교해 나가며 겹치면 합침 */
public class Solution_009 {
    private List<int[]> list; // 결과 interval을 저장할 List

    public int[][] getMergedInterval(int[][] intervals) {
        list = new ArrayList<int[]>(Arrays.asList(intervals));
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (isOverlap(list.get(i), list.get(j))) {
                    int[] merged = getMergedInterval(list.get(i), list.get(j));
                    list.remove(j);
                    list.remove(i);
                    list.add(i, merged);
                    i = j = 0; // 바뀐 interval을 포함하여 다시
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    // 두 간격을 합친다.
    private int[] getMergedInterval(int[] a, int[] b) {
        return new int[]{(a[0] < b[0]) ? a[0] : b[0], (a[1] > b[1]) ? a[1] : b[1]};
    }

    // 두 간격이 겹치는가?
    private boolean isOverlap(int[] a, int[] b) {
        if (a[1] < b[0] && a[0] < b[1]) return false;
        if (b[1] < a[0] && b[0] < a[1]) return false;
        return true;
    }
}