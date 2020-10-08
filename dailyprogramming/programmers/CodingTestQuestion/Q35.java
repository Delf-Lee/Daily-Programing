package programmers.CodingTestQuestion;

/**
 * @author delf
 */
/*
 * 중복된 원소가 없는 정렬된 배열이 있습니다. 이 배열에서 원소의 값이 원소의 인덱스 값과 같다면 프린트 하시오. 시간복잡도 O(log n).
 * Given a sorted array of unique values, find an element where its value is equal to the index.
 * */
public class Q35 {
    private static final int NONE = -1;

    public int solution(int[] arr) {
        if (arr[0] > 0) {
            return NONE;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < i) {
                continue;
            }
            if (arr[i] > i) {
                break;
            }
            if (arr[i] == i) {
                return i;
            }
        }
        return NONE;
    }

    public static void main(String[] args) {
        System.out.println(new Q35().solution(new int[]{-30, 1, 4, 60}));
        System.out.println(new Q35().solution(new int[]{0, 3, 10, 60}));
        System.out.println(new Q35().solution(new int[]{-40, -30, -20, 3}));
    }
}