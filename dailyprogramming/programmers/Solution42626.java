package programmers;

import java.util.*;

public class Solution42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int n : scoville) {
            priorityQueue.add(n);
        }

        while (!priorityQueue.isEmpty() && priorityQueue.peek() < K) {
            int lowest = priorityQueue.poll();
            if (priorityQueue.isEmpty()) {
                return -1;
            }
            int merge = lowest + (priorityQueue.poll() * 2);
            if(merge == 0) {
                return -1;
            }
            priorityQueue.add(merge);
            answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(new Solution42626().solution(new int[]{0,0,0,0}, 7));
    }
}
