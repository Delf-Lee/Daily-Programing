package codility.lesson10;

/**
 * @author delf
 */
public class MinPerimeterRectangle {
    // https://app.codility.com/demo/results/trainingZHVMUZ-7VV/
    public int solution(int N) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= (int) Math.sqrt(N); i++) {
            if (i * i == N) {
                min = Math.min(min, 2 * (i + i));
            } else if (N % i == 0) {
                min = Math.min(min, 2 * (i + (N / i)));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new MinPerimeterRectangle().solution(30));
    }
}