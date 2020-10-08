package unclassified;

public class Solution_007 {
    public int[] moveZeroToRight(int[] arr) {
        int cursor = 0;
        for (int i = 0; i < arr.length; i++) { // 한번 순회하며 0이 아닌 정수로만 배열울 재구성
            if (arr[i] != 0)
                arr[cursor++] = arr[i];
        }
        for (int i = cursor; i < arr.length; i++) { // 나머지를 0으로 채운다
            arr[i] = 0;
        }
        return arr;
    }
}