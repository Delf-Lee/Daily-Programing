package codility.lesson7;

import java.util.Stack;

/**
 * @author delf
 */
public class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack();
        int blockCnt = 0;
        for(int i =0 ; i < H.length; i++){

            while(stack.size() > 0 && stack.peek() > H[i]){
                stack.pop();
            }

            if(stack.size() == 0 || stack.peek() < H[i]){
                stack.push(H[i]);
                blockCnt++;
            }

        }
        return blockCnt;
    }

    public static void main(String[] args) {
        System.out.println(new StoneWall().solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }
}
