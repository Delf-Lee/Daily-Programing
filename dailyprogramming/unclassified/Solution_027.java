package unclassified;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution_027 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int second = 0;
        Queue<Integer> wait = new LinkedList<>(); // 대기 트럭 큐
        Bridge bridge = new Bridge(bridge_length, weight); // 다리 지나는 트럭 큐
        wait.addAll(Arrays.stream(truck_weights).boxed().collect(Collectors.toList())); // 대기 트럭 큐 초기화
        while (!wait.isEmpty() || !bridge.isEmpty()) {
            if (!wait.isEmpty()) {
                if (bridge.isFull(wait.peek())) { // 무게 초과하지 않으면
                    bridge.add(wait.poll(), second); // 다리에 추가
                }
            }
            if (!bridge.isEmpty()) {
                bridge.afterOneSecond(++second);
            }
        }

        return second + 1;
    }

    class Bridge extends LinkedList<Integer[]> {
        final static int WIGHT = 0;
        final static int SECOND = 1;
        int length;
        int limitWeight;
        int nowWeight;

        public Bridge(int length, int limitWeight) {
            this.length = length;
            this.limitWeight = limitWeight;
        }

        public boolean add(int truck, int second) {
            nowWeight += truck;
            // System.out.printf("truck=%d, second=%d\n", truck, second);
            return super.add(new Integer[]{truck, second});
        }

        public int deQueue() {
            return super.poll()[WIGHT];
        }

        public boolean isFull(int truck) {
            //System.out.printf("nowWeight=%d, truck=%d\n", nowWeight, truck);
            // System.out.printf("nowWeight(%d) + truck(%d) <= limitWeight(%d)\n", nowWeight, truck, limitWeight);
            return (nowWeight + truck <= limitWeight);
        }

        public boolean afterOneSecond(int second) {
            System.out.printf("second(%d) - peek[SECOND](%d) peek[WEIGHT](%d) >= leength(%d) : %s\n", second, peek()[SECOND], peek()[WIGHT], length, second - peek()[SECOND] >= length);
            if (!isEmpty() && second - peek()[SECOND] >= length) {
                nowWeight -= deQueue();
                return true;
            }
            return false;
        }
    }
}
