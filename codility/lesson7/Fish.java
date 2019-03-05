package codility.lesson7;

import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {
        int feedCount = 0;
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (B[i] == 1) { // downstream fish
                stack.add(i);
            } else { //upstream fish
                while (!stack.empty()) {
                    feedCount++;
                    if (A[stack.peek()] < A[i]) stack.pop();
                    else break;
                }
            }
        }
        return n - feedCount;
    }


    public static void main(String[] args) {
        System.out.println(new Fish().solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));

    }
}
