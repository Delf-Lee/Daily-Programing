package DP003;

import java.util.Arrays;

public class Solution_003 {
    public int[] getResultArray(int[] elements) {
        int[] result = getIntArrayFilledOne(elements.length);
        int[] frontArr = getFrontArr(elements); // 입력 배열의 자신을 제외한 앞 부분의 곱: 시간복잡도: O(n)
        int[] rearArr = getRearArr(elements); // 입력 배열의 자신을 제외한 뒷 부분의 곱: 시간복잡도: O(n)

        // 두 배열의 곱: 시간 복잡도 O(n)
        for (int i = 0; i < elements.length; i++) {
            result[i] = frontArr[i] * rearArr[i];
        }
        return result;
    }
    /** @return 자신을 제외한 앞 부분의 곱 */
    private int[] getFrontArr(int[] arr) {
        int[] res = getIntArrayFilledOne(arr.length);
        int product = 1;
        for (int i = 1; i < arr.length; i++) {
            product *= arr[i - 1];
            res[i] = product;
        }
        return res;
    }

    /** @return 자신을 제외한 뒷 부분의 곱 */
    private int[] getRearArr(int[] arr) {
        int[] res = getIntArrayFilledOne(arr.length);
        int product = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            product *= arr[i];
            res[i - 1] = product;
        }
        return res;
    }

    /** @return 1로 초기화된 정수 배열 */
    private int[] getIntArrayFilledOne(int size) {
        int[] res = new int[size];
        Arrays.fill(res, 1);
        return res;
    }
}