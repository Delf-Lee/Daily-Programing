package codingtest.baemintechcourse2019;

import javax.naming.NotContextException;

/**
 * @author delf
 */
public class PageMax {

    public int solution(int[] pobi, int[] crong) {

        try {
            int maxPobi = getMaxOfPage(pobi);
            int maxCrong = getMaxOfPage(crong);

            if(maxPobi == maxCrong) return 0;
            return maxPobi > maxCrong ? 1 : 2;
        } catch (Exception e) {
            return -1;
        }

    }

    private int getMaxOfPage(int[] arr) throws Exception {
        if (arr[1] - arr[0] != 1) {
            throw new Exception();
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum, mult;
            mult = sum = arr[i] % 10;
            while ((arr[i] /= 10) > 0) {
                sum += arr[i] % 10;
                mult *= arr[i] % 10;
            }
            max = Math.max(max, Math.max(sum, mult)); // 합과 곱중 최댓값
        }
        return max;
    }

    public static void main(String[] args) throws NotContextException {
        System.out.println(new PageMax().solution(new int[]{97, 98}, new int[]{197, 198}));
        System.out.println(new PageMax().solution(new int[]{131, 132}, new int[]{211, 212}));
        System.out.println(new PageMax().solution(new int[]{99, 102}, new int[]{211, 212}));
    }
}

