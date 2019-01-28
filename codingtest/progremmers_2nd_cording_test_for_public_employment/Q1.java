package codingtest.progremmers_2nd_cording_test_for_public_employment;

/**
 * @author delf
 */
public class Q1 {
    public boolean solution(int[] arrA, int[] arrB) {
        if (arrA.length != arrB.length) return false;

        boolean flag;
        for (int i = 0; i < arrA.length; i++) {
            flag = true;
            if (arrA[0] == arrB[i]) {
                for (int j = i + 1; j < arrB.length + i + 1; j++) {
                    if (arrA[(j - i) % arrA.length] != arrB[j % arrB.length]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q1 test = new Q1();
        System.out.println(test.solution(new int[]{7, 8, 10, 1, 2, 3}, new int[]{10, 1, 2, 3, 7, 8}));
    }
}
