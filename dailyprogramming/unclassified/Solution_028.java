package unclassified;

import java.util.Iterator;
import java.util.LinkedList;

// programmers 알고리즘 문제 풀이
// 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587
public class Solution_028 {

    public static void main(String[] args) {
        System.out.println(new Solution_028().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        int answer = 1;
        Printer p = new Printer(priorities);
        while (!p.isEmpty()) {
            int j = p.getNextPrint();
            if (j == location) return answer;
            answer++;
        }

        return answer;
    }

    class Printer extends LinkedList<Printer.Work> {
        public int getNextPrint() {
            while (true) {
                Work j = poll();
                if (!isPriority(j)) add(j);
                else return j.workNo;
            }
        }

        private boolean isPriority(Work p) {
            Iterator<Work> it = iterator();
            while (it.hasNext()) {
                if (it.next().pri > p.pri) return false;
            }
            return true;
        }

        class Work {
            int workNo;
            int pri;

            public Work(int workNo, int pri) {
                this.workNo = workNo;
                this.pri = pri;
            }
        }
        public Printer(int[] priorities) {
            for (int i = 0; i < priorities.length; i++) {
                super.add(new Work(i, priorities[i]));
            }
        }
    }
}
