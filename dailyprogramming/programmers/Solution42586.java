import java.util.*;

public class Solution42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        boolean[] completed = new boolean[progresses.length];


        while (!isAllEnd(completed)) {
            boolean hasEndWork = false;
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];

                if (!completed[i] && progresses[i] > 100) {
                    completed[i] = true;
                    queue.add(i);
                    hasEndWork = true;
                }
            }
            System.out.println(Arrays.toString(progresses));
            System.out.println(">>" + queue);

            if (!hasEndWork) {
                continue;
            }

            for (int i = 0; i < progresses.length; i++) {
                while (true) {
                    if (!queue.isEmpty() && queue.peek() < i) {
                        queue.poll();
                        continue;
                    }
                    break;
                }
                if (!completed[i]) {
                    queue.add(i);
                }
            }
        }

        return answer;
    }

    private boolean isAllEnd(boolean[] progresses) {
//        System.out.println(Arrays.toString(progresses));
        boolean result = true;
        for (boolean progress : progresses) {
            result &= progress;
        }
        return result;
    }

    private boolean progressWork(int[] progresses, int[] speeds) {
        boolean flag = false;
        for (int i = 0; i < progresses.length; i++) {
            progresses[i] += speeds[i];
            if (!flag && progresses[i] > 100) {
                flag = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution42586().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }
}
