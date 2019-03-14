package codility.lesson8;

import java.util.Stack;

/**
 * @author delf
 */
public class Dominator {

    public int solution(int[] A) {
        Stack<Integer> stack = new Stack<>();
        stack.add(A[0]);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (!stack.isEmpty() && A[i] != stack.peek()) {
                stack.pop();
            } else {
                res = i;
                stack.push(A[i]);
            }
        }
        if (stack.isEmpty()) return -1;
        return res;
    }


    public static void main(String[] args) {
        // System.out.println(new Solution3().solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        // System.out.println(new Solution3().solution(new int[]{1}));
        System.out.println(new Dominator().solution(new int[]{2, 1, 1, 3, 4}));
    }
}

