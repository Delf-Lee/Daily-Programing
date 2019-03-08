package codility.lesson8;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author delf
 */
public class EquiLeader {
    public int solution(int[] A) {
        int uqiLeaderCnt = 0;
        int leader;
        try {
            leader = getLeader(A, 0, A.length);
        } catch (NoSuchElementException e) {
            return 0;
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (leader != A[i]) {
                continue;
            }
            try {
                if (getLeader(A, 0, i) == getLeader(A, i + 1, A.length)) {
                    /*System.out.printf("%d~%d:%d, %d~%d:%d\n", 0, i, getLeader(A, 0, i), i + 1, A.length, getLeader(A, i + 1, A.length));
                    System.out.println(i);*/
                    uqiLeaderCnt++;
                }
            } catch (NoSuchElementException e1) {
                // System.out.println("no2");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("arr2");
            }
        }

        return uqiLeaderCnt;
    }

    private int getLeader(int[] A, int start, int end) {
        System.out.println(start + " " + end);
        if (end - start == 1) {
            throw new NoSuchElementException();
        } else if (end - start == 0) {
            return A[start];
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(A[start]);
        for (int i = start + 1; i < end; i++) {
            if (!stack.isEmpty() && A[i] != stack.peek()) {
                stack.pop();
            } else {
                stack.push(A[i]);
            }
        }

        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EquiLeader().solution(new int[]{4, 3, 4, 4, 4, 2}));
    }
}
