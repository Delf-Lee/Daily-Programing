package codility.lesson8;

import java.util.Stack;

/**
 * @author delf
 */
public class EquiLeader {
    public int solution(int[] A) {
        if (A.length == 1) {
            return 0;
        } else if (A.length == 2) {
            if (A[0] == A[1]) return 1;
            else return 0;
        }

        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (!stack.isEmpty() && A[i] != stack.peek()) {
                stack.pop();
            } else {
                cnt++;
                stack.push(A[i]);
            }
        }
        if (stack.isEmpty()) return 0;

        int equiLeaderCnt = 0;
        int leaderOrder = 0;
        int leader = stack.pop();
        // System.out.printf("leader = %d, cnt = %d\n", leader, cnt);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) leaderOrder++;
            // System.out.printf("%d > %d && %d > %d\n", leaderOrder, (i + 1) / 2, cnt - leaderOrder, (A.length - i - 1) / 2);
            if ((leaderOrder > (i + 1) / 2) && (cnt - leaderOrder > (A.length - i - 1) / 2)) {
                equiLeaderCnt++;
            }
        }

        return equiLeaderCnt;
    }

    private int getWholeLeader(int[] A) {
        return 0;

    }


    public static void main(String[] args) {
        int a = new EquiLeader().solution(new int[]{4, 4, 2, 5, 3, 4, 4, 4});
        System.out.println(a + " " + (a == 3));
        int b = new EquiLeader().solution(new int[]{1, 2, 1, 1, 2, 1});
        System.out.println(b + " " + (b == 3));

    }
}
